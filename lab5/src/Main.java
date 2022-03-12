import collection.Person;
import collection.PersonCollection;
import util.InputUtil;

import java.util.*;

public class Main {
    PersonCollection personCollection = new PersonCollection();
    public static void main(String[] args) throws Exception{

        Scanner scanner = new Scanner(System.in);
        PersonCollection personCollection = new PersonCollection();
        String command = "";


        while (!command.equals("exit")) {

            command = scanner.nextLine().trim().toLowerCase(Locale.ROOT);

            switch(command){
                case "insert null":
                    Person person = InputUtil.requestPerson();
                    personCollection.put(person.getId(),person);
                    break;

                case "info":
                    personCollection.printInfo();
                    break;
                case "exit":
                    //Выходим
                    break;
                case "remove_key null":
                    System.out.print("Введите ключ: ");
                    Integer key = Integer.valueOf(scanner.nextLine());
                    if (personCollection.containsKey(key)) {
                        personCollection.remove(key);
                    } else {
                        System.out.println("Несуществующий id элемента!");
                    }
                    break;

                default:
                    System.out.println("Несуществующая, или неверно заданная команда! Проверьте корректность и повторите попытку.");
            }




        }

    }

}
