package common;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Server {
    private int port;
    private ServerSocketChannel channel;
    public Server(int port) {
        this.port = port;
        try {
            channel = ServerSocketChannel.open();
            channel.bind(new InetSocketAddress(port));
            channel.configureBlocking(false);
            System.out.println("Сервер запущен...");
        } catch (IOException e) {
            System.out.println("Подключение не удалось");
            System.exit(0);
        }
    }

    public void start(){
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        SocketChannel user = null;
        while (user == null) {
            try {
                user = channel.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Соединение установлено");
    }
}
