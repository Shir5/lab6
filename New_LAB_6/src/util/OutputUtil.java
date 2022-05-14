package util;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Output
 */

public class OutputUtil {
    private static SocketChannel channel;

    public static void setChannel(SocketChannel channel) {
        OutputUtil.channel = channel;
    }

    public static void outputManager(String s) {
        try {
            channel.write(ByteBuffer.wrap(s.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void outputManagerLiner(String s) {
        try {
            channel.write(ByteBuffer.wrap(s.getBytes()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
