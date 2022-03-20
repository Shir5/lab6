package util;


import collection.*;
import java.util.Scanner;

public class InputUtil {

    public static String requestCommand() {
        Scanner scanner = new Scanner(System.in);
        OutputUtil.outputManager("Введите команду: ");
        String command = scanner.nextLine();

        if (command.isEmpty()) {
            OutputUtil.outputManagerLiner("Команда не может быть пустой");
            return requestCommand();
        } else {
            return command;

        }
    }


    public static Integer requestKey() {
        try{
            Scanner scanner = new Scanner(System.in);
            OutputUtil.outputManager("Введите ключ: ");
            Integer key = Integer.valueOf(scanner.nextLine());
            return key;
        } catch (Exception e) {
            OutputUtil.outputManagerLiner("Неправильный формат ввода");
            return requestKey();
        }

    }

    public static Integer requestId() {
        try{
            Scanner scanner = new Scanner(System.in);
            OutputUtil.outputManager("Введите ключ: ");
            Integer id = Integer.valueOf(scanner.nextLine());
            return id;
        } catch (Exception e) {
            OutputUtil.outputManagerLiner("Неправильный формат ввода");
            return requestId();
        }

    }

    public static long requestHeight() {
        try {
            Scanner scanner = new Scanner(System.in);
            OutputUtil.outputManager("Введите высоту: ");
            Long height = Long.parseLong(scanner.nextLine());
            if (height == null || height <= 0) {
                OutputUtil.outputManagerLiner("Некорректное значение высоты");
                return requestHeight();
            } else {
                return height;
            }
        } catch (Exception e) {
            OutputUtil.outputManagerLiner("Неправильный формат ввода");
            return requestHeight();
        }
    }

    public static Integer requestWeight() {
        try{
            Scanner scanner = new Scanner(System.in);
            OutputUtil.outputManager("Введите вес: ");
            Integer weight = Integer.valueOf(scanner.nextLine());
            if (weight == null || weight <= 0) {
                OutputUtil.outputManagerLiner("Некорректное значение веса");
                return requestWeight();
            } else {
                return weight;
            }
        } catch (Exception e) {
            OutputUtil.outputManagerLiner("Неправильный формат ввода");
            return requestWeight();
        }

    }

    public static String requestSubName() {
        Scanner scanner = new Scanner(System.in);
        OutputUtil.outputManager("Введите начало имени: ");
        String subName = scanner.nextLine();
        if (subName.isEmpty()) {
            OutputUtil.outputManagerLiner("Подстрока не может быть пустой");
            return requestSubName();
        }
        return subName;
    }

    public static String requestFileName() {
        try {
            Scanner scanner = new Scanner(System.in);
            OutputUtil.outputManager("Введите имя файла: ");
            String fileName = scanner.nextLine();
            if (fileName.isEmpty()) {
                OutputUtil.outputManagerLiner("Файл не может быть без имени");
                return requestFileName();
            }
            return fileName;
        } catch (Exception e) {
            OutputUtil.outputManagerLiner("Файла не существует");
            return requestFileName();
        }
    }

    public static String requestName() {
        Scanner scanner = new Scanner(System.in);
        OutputUtil.outputManager("Введите имя: ");
        String name = scanner.nextLine();
        if (name.isEmpty() || name == null) {
            OutputUtil.outputManagerLiner("Подстрока не может быть пустой");
            return requestName();
        }
        return name;
    }

    public static float requestX() {
        try {
            Scanner scanner = new Scanner(System.in);
            OutputUtil.outputManager("Введите координату x: ");
            float x = Float.parseFloat(scanner.nextLine());
            if (x <= -315) {
                OutputUtil.outputManagerLiner("Задано неверное значение x");
                return requestX();
            }
            return x;
        } catch (Exception e) {
            OutputUtil.outputManagerLiner("Неправильный формат ввода");
            return requestX();
        }
    }

    public static double requestY() {
        try {
            Scanner scanner = new Scanner(System.in);
            OutputUtil.outputManager("Введите координату y: ");
            double y = Double.parseDouble(scanner.nextLine());
            if (y <= -188) {
                OutputUtil.outputManagerLiner("Задано неверное значение y");
                return requestY();
            }
            return y;
        } catch (Exception e) {
            OutputUtil.outputManagerLiner("Неправильный формат ввода");
            return requestY();
        }
    }

    public static Country requestCountry() {
        try {
            Scanner scanner = new Scanner(System.in);
            OutputUtil.outputManager("Доступные варианты национальности: \n" +
                    "UNITED_STATES\n" +
                    "GERMANY\n"+
                    "ITALY\n" +
                    "NORTH_KOREA\n" +
                    "JAPAN\n" +
                    "Введите национальность: ");

            Country country = Country.valueOf(scanner.next().toUpperCase());

            return country;
        } catch (Exception e) {
            OutputUtil.outputManagerLiner("Неверные данные");
            return requestCountry();
        }
    }

    public static Color requestColor() {
        try {
            Scanner scanner = new Scanner(System.in);
            OutputUtil.outputManager("Доступные варианты цвета волос: \n" +
                    "RED\n" +
                    "BLUE\n"+
                    "YELLOW\n" +
                    "ORANGE\n" +
                    "WHITE\n" +
                    "Введите цвет волос: ");

            Color color = Color.valueOf(scanner.next().toUpperCase());

            return color;
        } catch (Exception e) {
            OutputUtil.outputManagerLiner("Неверные данные");
            return requestColor();
        }
    }

    public static int requestLX() {
        try{
            Scanner scanner = new Scanner(System.in);
            OutputUtil.outputManager("Введите координату x: ");
            int lx = Integer.parseInt(scanner.nextLine());
            return lx;
        } catch (Exception e) {
            OutputUtil.outputManagerLiner("Неправильный формат ввода");
            return requestLX();
        }

    }

    public static float requestLY() {
        try {
            Scanner scanner = new Scanner(System.in);
            OutputUtil.outputManager("Введите координату y: ");
            float y = Float.parseFloat(scanner.nextLine());
            return y;
        } catch (Exception e) {
            OutputUtil.outputManagerLiner("Неправильный формат ввода");
            return requestLY();
        }
    }

    public static float requestLZ() {
        try {
            Scanner scanner = new Scanner(System.in);
            OutputUtil.outputManager("Введите координату z: ");
            float z = Float.parseFloat(scanner.nextLine());
            return z;
        } catch (Exception e) {
            OutputUtil.outputManagerLiner("Неправильный формат ввода");
            return requestLZ();
        }
    }



}
