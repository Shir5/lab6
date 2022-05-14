import common.Server;


public class ServerMain {
    private static int PORT = 6699;

    public static void main(String[] args) throws Exception {
        Server server = new Server(PORT);
        server.start();
    }
}
