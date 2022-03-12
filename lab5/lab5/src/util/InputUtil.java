package util;

import Exceptions.IdException;
import collection.*;

import java.time.ZonedDateTime;
import java.util.Scanner;

public class InputUtil {
    public static Person requestPerson(){
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите ключ (id): ");
            Integer id = Integer.valueOf(scanner.nextLine());
            if (id == null){
                throw new IdException("Id введено не верно");
            }
            System.out.print("Введите имя: ");
            String name = scanner.nextLine();
            System.out.println("Введите координаты");
            System.out.print("Координата x: ");
            Float x = scanner.nextFloat();
            System.out.print("Координата y: ");
            Double y = scanner.nextDouble();
            System.out.print("Введите высоту: ");
            Long height = scanner.nextLong();
            System.out.print("Введите вес: ");
            Integer weight = scanner.nextInt();
            System.out.print("Введите цвет волос: ");
            Color hairColor = Color.valueOf(scanner.next().toUpperCase());
            System.out.print("Введите национальность: ");
            Country nationality = Country.valueOf(scanner.next().toUpperCase());
            System.out.println("Введите локацию");
            System.out.print("Координата x: ");
            Integer x1 = scanner.nextInt();
            System.out.print("Координата y: ");
            Float y1 = scanner.nextFloat();
            System.out.print("Координата z: ");
            Float z1 = scanner.nextFloat();
            ZonedDateTime creationDate = ZonedDateTime.now();
            Coordinates coordinates = new Coordinates(x, y);
            Location location = new Location(x1, y1, z1);
            Person person = new Person(id, name, coordinates, creationDate, height, weight, hairColor, nationality, location);
            return person;
        }catch (Exception e){
            System.out.println("Неправильный формат ввода");
            return requestPerson();
        }
    }
}
