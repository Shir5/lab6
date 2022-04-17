import common.Server;

public class SMain {

    private static final int port = 7777;

    public static void main(String[] args) {
        Server server = new Server(port);
        server.start();
    }
}
