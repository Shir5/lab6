package util;


import collection.*;
import commands.Command;
import java.util.Scanner;

public class InputUtil {

    public static String requestCommand() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите команду: ");
        String command = scanner.nextLine();
        if (command.isEmpty()) {
            System.out.println("Команда не может быть пустой");
            return requestCommand();
        }
        return command;
    }



    public static Integer requestKey() {
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите ключ: ");
            Integer key = Integer.valueOf(scanner.nextLine());
            return key;
        } catch (Exception e) {
            System.out.println("Неправильный формат ввода");
            return requestKey();
        }

    }

    public static Integer requestId() {
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите ключ: ");
            Integer id = Integer.valueOf(scanner.nextLine());
            return id;
        } catch (Exception e) {
            System.out.println("Неправильный формат ввода");
            return requestId();
        }

    }

    public static long requestHeight() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите высоту: ");
            long height = Long.parseLong(scanner.nextLine());
            return height;
        } catch (Exception e) {
            System.out.println("Неправильный формат ввода");
            return requestHeight();
        }
    }

    public static Integer requestWeight() {
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите вес: ");
            Integer weight = Integer.valueOf(scanner.nextLine());
            return weight;
        } catch (Exception e) {
            System.out.println("Неправильный формат ввода");
            return requestWeight();
        }

    }

    public static String requestSubName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите начало имени: ");
        String subName = scanner.nextLine();
        if (subName.isEmpty()) {
            System.out.println("Подстрока не может быть пустой");
            return requestSubName();
        }
        return subName;
    }

    public static String requestFileName() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите имя файла: ");
            String fileName = scanner.nextLine();
            if (fileName.isEmpty()) {
                System.out.println("Файл не может быть без имени");
                return requestFileName();
            }
            return fileName;
        } catch (Exception e) {
            System.out.println("Файла не существует");
            return requestFileName();
        }
    }

    public static String requestName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        if (name.isEmpty()) {
            System.out.println("Подстрока не может быть пустой");
            return requestName();
        }
        return name;
    }

    public static float requestX() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите координату x: ");
            float x = Float.parseFloat(scanner.nextLine());
            if (x <= -315) {
                System.out.println("Задано неверное значение x");
                return requestX();
            }
            return x;
        } catch (Exception e) {
            System.out.println("Неправильный формат ввода");
            return requestX();
        }
    }

    public static double requestY() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите координату y: ");
            double y = Double.parseDouble(scanner.nextLine());
            if (y <= -188) {
                System.out.println("Задано неверное значение y");
                return requestX();
            }
            return y;
        } catch (Exception e) {
            System.out.println("Неправильный формат ввода");
            return requestY();
        }
    }

    public static Country requestCountry() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Доступные варианты национальности: \n" +
                    "UNITED_STATES\n" +
                    "GERMANY\n"+
                    "ITALY\n" +
                    "NORTH_KOREA\n" +
                    "JAPAN");

            Country country = Country.valueOf(scanner.next().toUpperCase());

            return country;
        } catch (Exception e) {
            System.out.println("Неверные данные");
            return requestCountry();
        }
    }

    public static Color requestColor() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Доступные варианты цвета волос: \n" +
                    "RED\n" +
                    "BLUE\n"+
                    "YELLOW\n" +
                    "ORANGE\n" +
                    "WHITE");

            Color color = Color.valueOf(scanner.next().toUpperCase());

            return color;
        } catch (Exception e) {
            System.out.println("Неверные данные");
            return requestColor();
        }
    }

    public static int requestLX() {
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите координату x: ");
            int lx = Integer.valueOf(scanner.nextLine());
            return lx;
        } catch (Exception e) {
            System.out.println("Неправильный формат ввода");
            return requestLX();
        }

    }

    public static float requestLY() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите координату y: ");
            float y = Float.parseFloat(scanner.nextLine());
            return y;
        } catch (Exception e) {
            System.out.println("Неправильный формат ввода");
            return requestLY();
        }
    }

    public static float requestLZ() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите координату z: ");
            float z = Float.parseFloat(scanner.nextLine());
            return z;
        } catch (Exception e) {
            System.out.println("Неправильный формат ввода");
            return requestLZ();
        }
    }



}
