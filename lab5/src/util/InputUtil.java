package util;

import Exceptions.ProgramException;

import collection.*;

import java.time.ZonedDateTime;
import java.util.Scanner;

public class InputUtil {
    public static Person requestPerson(){
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите имя: ");
            String name = scanner.nextLine();
            if (name.isEmpty()){
                throw new ProgramException("Name введено не верно");
            }
            System.out.println("Введите координаты");
            System.out.print("Координата x: ");
            Float x = scanner.nextFloat();
            if (x == null || x <= -315){
                throw new ProgramException("Не верные данные координаты x");
            }
            System.out.print("Координата y: ");
            Double y = scanner.nextDouble();
            if (y == null || y <= -188){
                throw new ProgramException("Не верные данные координаты y");
            }
            System.out.print("Введите высоту: ");
            Long height = scanner.nextLong();
            if (height == null | height <= 0){
                throw new ProgramException("Не верные данные высоты");
            }
            System.out.print("Введите вес: ");
            Integer weight = scanner.nextInt();
            if (weight == null | weight <= 0){
                throw new ProgramException("Не верные данные веса");
            }
            System.out.print("Введите цвет волос: ");
            Color hairColor = Color.valueOf(scanner.next().toUpperCase());
            if (hairColor == null){
                throw new ProgramException("Не верные данные цвета волос");
            }
            System.out.print("Введите национальность: ");
            Country nationality = Country.valueOf(scanner.next().toUpperCase());
            if (nationality == null){
                throw new ProgramException("Не верные данные нацианальности");
            }
            System.out.println("Введите локацию");
            System.out.print("Координата x: ");
            Integer x1 = scanner.nextInt();
            if (x1 == null){
                throw new ProgramException("Не верные данные координаты x1");
            }
            System.out.print("Координата y: ");
            Float y1 = scanner.nextFloat();
            if (y1 == null){
                throw new ProgramException("Не верные данные координаты y1");
            }
            System.out.print("Координата z: ");
            Float z1 = scanner.nextFloat();
            if (z1 == null){
                throw new ProgramException("Не верные данные координаты z1");
            }
            ZonedDateTime creationDate = ZonedDateTime.now();
            if (creationDate == null){
                throw new ProgramException("Не верные данные времени");
            }
            Coordinates coordinates = new Coordinates(x, y);
            if (coordinates == null){
                throw new ProgramException("Не верные данные координат");
            }
            Location location = new Location(x1, y1, z1);
            Person person = new Person(name, coordinates, creationDate, height, weight, hairColor, nationality, location);
            return person;
        }catch (Exception e){
            System.out.println("Неправильный формат ввода");
            return requestPerson();
        }
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

    public static String requestSubName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите начало имени: ");
        String subName= scanner.nextLine();
        if (subName.isEmpty()) {
            System.out.println("Подстрока не может быть пустой");
            return requestSubName();
        }
        return subName;
    }

}
