import common.Client;

public class ClientMain {
    private final static int PORT = 6699;
    private final static String HOST = "localhost";

    public static void main(String[] args) throws Exception {
        Client client = new Client(HOST, PORT);
        client.start();
    }
}
