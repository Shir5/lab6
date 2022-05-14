package common;


import interfaces.IClient;
import interfaces.packages.IHandlePackage;
import packages.CommandPackage;
import packages.HandlePackage;
import util.LoggerUtil;
import util.SerializationUtil;

import java.io.EOFException;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Client implements IClient {
    private String HOST;
    private int PORT;
    private CommandPackage input;
    private ByteBuffer buffer = ByteBuffer.allocate(32768);


    public Client(String HOST, int PORT) {
        this.HOST = HOST;
        this.PORT = PORT;
    }


    @Override
    public void start() {
        SocketChannel channel = null;
        try {
            channel = SocketChannel.open();
            channel.configureBlocking(false);
            Selector selector = Selector.open();
            channel.register(selector, SelectionKey.OP_CONNECT);
            channel.connect(new InetSocketAddress(HOST, PORT));
            InputRequest inputRequest = new InputRequest(new Scanner(System.in));

            SocketChannel finalChannel = channel;
            new Thread(() -> {
                while (true) {
                    try {
                        input = CommandPacker.pack(inputRequest.getScanner().nextLine());
                        finalChannel.write(ByteBuffer.wrap(SerializationUtil.serialize(input)));
                    } catch (NoSuchElementException e) {
                        LoggerUtil.negative("Ctrl+D");
                        System.exit(0);
                    } catch (IOException e) {
                        LoggerUtil.negative("Хз, что ты наделал");
                    }

                }
            }).start();

            while (true) {
                selector.select();
                for (SelectionKey key : selector.selectedKeys()) {
                    if (key.isConnectable()) {
                        channel.finishConnect();
                        key.interestOps(SelectionKey.OP_READ);
                    } else if (key.isReadable()) {
                        buffer.clear();
                        channel.read(buffer);
                        buffer.flip();
                        byte[] bytes = new byte[buffer.limit()];
                        buffer.get(bytes);
                        HandlePackage pack = (HandlePackage) SerializationUtil.deserialize(bytes);
                        pack.unpack();
                        buffer.flip();
                    }
                }
            }
        } catch (IOException e) {
            LoggerUtil.negative("Не удалось подключиться к серверу, выход");
            System.exit(0);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
