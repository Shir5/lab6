import collection.Person;
import collection.PersonCollection;
import commands.*;
import util.InputUtil;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Scanner;
import java.io.FileOutputStream;

public class Main {
    PersonCollection personCollection = new PersonCollection();
    public static void main(String[] args) throws Exception{

        Scanner scanner = new Scanner(System.in);
        PersonCollection personCollection = new PersonCollection();

        while (true) {

            String command = scanner.nextLine().trim().toLowerCase(Locale.ROOT);

            if (command.equals("insert null")) {


                Person person = InputUtil.requestPerson();
                personCollection.put(person.getId(),person);
            }
            if (command.equals("info")) {
                personCollection.printInfo();
            }
        }

    }

}
