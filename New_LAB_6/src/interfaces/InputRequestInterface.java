package interfaces;

import java.util.Scanner;
import java.util.function.Function;

public interface InputRequestInterface {

    <T> T request(String message, Function<String, Object> handler);

    default String request(String message) {return request(message, input -> input);}

    Scanner getScanner();
}
