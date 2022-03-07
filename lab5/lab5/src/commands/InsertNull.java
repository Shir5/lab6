package commands;

import java.time.ZonedDateTime;
import java.util.Scanner;


import Exceptions.*;
import collection.*;


public class InsertNull {

    public static void insertNull()  throws ProgramExceptions {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите ключ (id): ");
            Integer id = Integer.valueOf(scanner.nextInt());
            if (id == null){
                throw new ProgramExceptions("Id введено не верно");
            }
            System.out.print("Введите имя: ");
            String name = scanner.nextLine();
            if (name.isEmpty()){
                throw new ProgramExceptions("Name введено не верно");
            }
            System.out.println("Введите координаты");
            System.out.print("Координата x: ");
            Float x = scanner.nextFloat();
            if (x > 315){
                throw new ProgramExceptions("Не верные данные координат");
            }
            System.out.print("Координата y: ");
            Double y = scanner.nextDouble();
            if (y > 188){
                throw new ProgramExceptions("Не верные данные координат");
            }
            System.out.print("Введите высоту: ");
            Long height = scanner.nextLong();
            if ((height == null) || (height <= 0)){
                throw new ProgramExceptions("Height введено не верно");
            }
            System.out.print("Введите вес: ");
            Integer weight = scanner.nextInt();
            if ((weight == null) || (weight <= 0)){
                throw new ProgramExceptions ("Weight введено не верно");
            }
            System.out.print("Введите цвет волос: ");
            Color hairColor = Color.valueOf(scanner.next().toUpperCase());
            if (hairColor == null){
                throw new ProgramExceptions("Collor введено не верно");
            }
            System.out.print("Введите национальность: ");
            Country nationality = Country.valueOf(scanner.next().toUpperCase());
            if (nationality == null){
                throw new ProgramExceptions("Nationality введено не верно");
            }
            System.out.println("Введите локацию");
            System.out.print("Координата x: ");
            Integer x1 = scanner.nextInt();
            System.out.print("Координата y: ");
            Float y1 = scanner.nextFloat();
            System.out.print("Координата z: ");
            Float z1 = scanner.nextFloat();
            ZonedDateTime creationDate = ZonedDateTime.now();
            if (creationDate == null){
                throw new ProgramExceptions("Не верные данные координат");
            }
            Coordinates coordinates = new Coordinates(x, y);
            if (coordinates == null){
                throw new ProgramExceptions("Не верные данные координат");
            }
            Location location = new Location(x1, y1, z1);
            if (location == null){
                throw new ProgramExceptions("Location введено не верно");
            }
            Person person = new Person(id, name, coordinates, creationDate, height, weight, hairColor, nationality, location);
        }catch (Exception e){
            System.out.println("Неправильный формат ввода");
            insertNull();
        }
    }

}
