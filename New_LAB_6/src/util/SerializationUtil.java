package util;

import java.io.*;

public class SerializationUtil {

    public static byte[] serialize(Object object) throws IOException{
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try (ObjectOutputStream stream = new ObjectOutputStream(output)){
                stream.writeObject(object);
                stream.flush();
            return output.toByteArray();
        }
    }

    public static Object deserialize(byte[] array) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bis = new ByteArrayInputStream(array);
        try (ObjectInputStream in = new ObjectInputStream(bis)) {
            return in.readObject();
        }
    }
}
