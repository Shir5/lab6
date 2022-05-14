package common;


import interfaces.IServer;
import packages.CommandPackage;
import packages.HandlePackage;
import util.LoggerUtil;
import util.SerializationUtil;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;

import java.util.Iterator;


import static java.nio.channels.SelectionKey.*;

public class Server implements IServer {
    private int PORT;
    private ByteBuffer buffer = ByteBuffer.allocate(2048);
    ServerSocketChannel serverChannel;
    Selector selector;
    SocketChannel channel;
    String msg = null;
    HandlePackage aPackage;


    public Server(int PORT) {
        this.PORT = PORT;
        try {
            serverChannel = ServerSocketChannel.open();
            serverChannel.configureBlocking(false);
            serverChannel.socket().bind(new InetSocketAddress(PORT));
            selector = SelectorProvider.provider().openSelector();
            serverChannel.register(selector, SelectionKey.OP_ACCEPT);
            LoggerUtil.positive("Сервер запущен...");
        } catch (IOException e) {
            LoggerUtil.negative("При запуске произошла ошибка");
            System.exit(0);
        }
    }

    @Override
    public void start() throws Exception {
        while(true) {
            selector.select();
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                iterator.remove();
                if (key.isAcceptable()) {
                    accept(key);
                } else if (key.isReadable()) {
                    read(key);
                } else if (key.isWritable()) {
                    write(key);
                }
            }
        }
    }

    private void accept(SelectionKey key) throws IOException {
        channel = serverChannel.accept();
        channel.configureBlocking(false);
        channel.register(selector, OP_WRITE);
    }

    private void write(SelectionKey key) throws IOException {
        aPackage = new HandlePackage(msg);
        channel.write(ByteBuffer.wrap(SerializationUtil.serialize(aPackage)));
        channel.register(key.selector(), OP_READ);
    }

    private void read(SelectionKey key) {
        try {
            buffer.clear();
            channel.read(buffer);
            buffer.flip();
            byte[] bytes = new byte[buffer.limit()];
            buffer.get(bytes);
            CommandPackage pack = (CommandPackage) SerializationUtil.deserialize(bytes);
            msg = pack.getCommandName();
            System.out.println(msg);
            buffer.flip();
            channel.register(key.selector(), OP_WRITE);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
}
