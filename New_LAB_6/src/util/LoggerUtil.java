package util;


public class LoggerUtil {
    public static String common(String message) {return String.format("[LAB] %s%s", message, Color.RESET);}
    public static String negativeAsString(String message) {return common(Color.RED + message);}
    public static String positiveAsString(String message) {
        return common(Color.GREEN + message);
    }
    public static String infoAsString(String message) {
        return common(Color.BLUE + message);
    }
    public static void log(String message) {
        System.out.println(common(message));
    }
    public static void negative(String message) {
        System.out.println(negativeAsString(message));
    }
    public static void positive(String message) {
        System.out.println(positiveAsString(message));
    }
    public static void info(String message) {
        System.out.println(infoAsString(message));
    }


    public interface Color {
        String RESET = "\u001B[0m",
                RED = "\u001b[31m",
                GREEN = "\u001b[32m",
                BLUE = "\u001b[34m";
    }

}
