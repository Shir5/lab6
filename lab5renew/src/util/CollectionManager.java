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
        FileReader data = new FileReader(fileName);
        Scanner scanner = new Scanner(data);

        while (scanner.hasNextLine()) {
            String[] personString = scanner.nextLine().split(", ");
            try {
                if (personString.length == 11) {
                    if (personString[0].isEmpty()) {
                        throw new ProgramException("Ключ введено не верно");
                    }
                    if (personString[1].isEmpty()) {
                        throw new ProgramException("Name введено не верно");
                    }
                    if (personString[2] == null || Float.parseFloat(personString[2]) <= -315) {
                        throw new ProgramException("Не верные данные координаты x");
                    }
                    if (personString[3] == null || Double.parseDouble(personString[3]) <= -188) {
                        throw new ProgramException("Не верные данные координаты y");
                    }
                    if (personString[4] == null || Long.parseLong(personString[4]) <= 0) {
                        throw new ProgramException("Не верные данные высоты");
                    }
                    if (personString[5] == null || Integer.parseInt(personString[5]) <= 0) {
                        throw new ProgramException("Не верные данные веса");
                    }


                    if (personString[8] == null) {
                        throw new ProgramException("Не верные данные координаты x");
                    }
                    if (personString[9] == null) {
                        throw new ProgramException("Не верные данные координаты y");
                    }
                    if (personString[10] == null) {
                        throw new ProgramException("Не верные данные координаты z");
                    }

                    Coordinates coordinates = new Coordinates(Float.parseFloat(personString[2]), Double.parseDouble(personString[3]));
                    Location location = new Location(Integer.parseInt(personString[8]), Float.parseFloat(personString[9]), Float.parseFloat(personString[10]));
                    ZonedDateTime creationDate = ZonedDateTime.now();

                    Person person = new Person(personString[1], coordinates, creationDate, Long.parseLong(personString[4]),
                            Integer.valueOf(personString[5]), Color.valueOf(personString[6].toUpperCase(Locale.ROOT)),
                            Country.valueOf(personString[7].toUpperCase(Locale.ROOT)), location);

                    personCollection.put(Integer.valueOf(personString[0]), person);
                } else {
                    OutputUtil.outputManagerLiner("Элемент не добавлен");
                }
            } catch (Exception e) {
                OutputUtil.outputManagerLiner("Элемент не добавлен");
            }
        }
        OutputUtil.outputManagerLiner("Коллекция успешно загружена из файла");
        return personCollection;
    }

    public void writer() throws FileNotFoundException {

        FileOutputStream data = new FileOutputStream(fileName);

        for (Integer i : personCollection.keySet()){
            try {
                String writer = i.toString() +", " + personCollection.get(i).toString1() + System.lineSeparator();
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
        OutputUtil.outputManagerLiner("Коллекция успешно сохранена");

    }
}
