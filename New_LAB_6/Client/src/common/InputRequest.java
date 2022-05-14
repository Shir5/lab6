package common;



import interfaces.InputRequestInterface;
import util.LoggerUtil;

import java.util.Scanner;
import java.util.function.Function;


public class InputRequest implements InputRequestInterface {
    Scanner scanner;

    public InputRequest(Scanner scanner) {
        this.scanner = scanner;
    }

    public <T> T request(String message, Function<String, Object> define) {

        T input = null;
        boolean ex = false;
        while (input == null) {
            System.out.printf("%s: ", message);
            try {
                input = (T) define.apply(scanner.nextLine().trim());
            } catch (Exception e) {
                ex = true;
            }
            if (ex || input == null || input.equals("null")) {
                LoggerUtil.negative("Формат введенных вами данных не соответствует требуемому.");
            }
        }
        return input;
    }

    public Scanner getScanner() {
        return scanner;
    }
}
