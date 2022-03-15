package util;
import Exceptions.ProgramException;
import collection.*;

import java.io.*;
import java.time.ZonedDateTime;
import java.util.Locale;
import java.util.Scanner;


public class CollectionManager {
    PersonCollection personCollection;
    String fileName;

    public CollectionManager(String fileName) {
        this.fileName = fileName;
        personCollection = new PersonCollection();
    }

    public PersonCollection getPersonCollection() {
        return personCollection;
    }

    public PersonCollection reader() throws FileNotFoundException {
        String separator = "\\";
        FileReader data = new FileReader(fileName);
        Scanner scanner = new Scanner(data);

        while (scanner.hasNextLine()) {
            String[] personString = scanner.nextLine().split(", ");
            try {
                if (personString.length == 10) {
                    if (personString[0].isEmpty()) {
                        throw new ProgramException("Name введено не верно");
                    }
                    if (personString[1] == null || Float.parseFloat(personString[1]) <= -315) {
                        throw new ProgramException("Не верные данные координаты x");
                    }
                    if (personString[2] == null || Double.parseDouble(personString[2]) <= -188) {
                        throw new ProgramException("Не верные данные координаты y");
                    }
                    if (personString[3] == null | Long.parseLong(personString[3]) <= 0) {
                        throw new ProgramException("Не верные данные высоты");
                    }
                    if (personString[4] == null | Integer.valueOf(personString[4]) <= 0) {
                        throw new ProgramException("Не верные данные веса");
                    }


                    if (personString[7] == null) {
                        throw new ProgramException("Не верные данные координаты x1");
                    }
                    if (personString[8] == null) {
                        throw new ProgramException("Не верные данные координаты y1");
                    }
                    if (personString[9] == null) {
                        throw new ProgramException("Не верные данные координаты z1");
                    }

                    Coordinates coordinates = new Coordinates(Float.parseFloat(personString[1]), Double.parseDouble(personString[2]));
                    Location location = new Location(Integer.parseInt(personString[7]), Float.parseFloat(personString[8]), Float.parseFloat(personString[9]));
                    ZonedDateTime creationDate = ZonedDateTime.now();

                    if (creationDate == null) {
                        throw new ProgramException("Не верные данные времени");
                    }
                    if (coordinates == null) {
                        throw new ProgramException("Не верные данные координат");
                    }
                    if (location == null) {
                        throw new ProgramException("Не верные данные координат");
                    }

                    Person person = new Person(personString[0], coordinates, creationDate, Long.parseLong(personString[3]),
                            Integer.valueOf(personString[4]), Color.valueOf(personString[5].toUpperCase(Locale.ROOT)),
                            Country.valueOf(personString[6].toUpperCase(Locale.ROOT)), location);

                    personCollection.put(person.getId(), person);
                } else {
                    System.out.println("Элемент не добавлен");
                }
            } catch (Exception e) {
                System.out.println("Элемент не добавлен");
            }
        }
        return personCollection;
    }

    public void writer() throws FileNotFoundException {

        FileOutputStream data = new FileOutputStream(fileName);

        for (Person i : personCollection.values()){
            try {
                String writer = i.toString1() + System.lineSeparator();
                byte[] bytes = writer.getBytes();
                data.write(bytes);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            data.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
