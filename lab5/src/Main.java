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
        Integer key;
        List history = new ArrayList();
        boolean erunda;
        String subName;
        Person person;
        long height;

        while (true) {

            command = scanner.nextLine().trim().toLowerCase(Locale.ROOT);

            erunda = false;

            switch (command) {
                case "insert null":

                    person = InputUtil.requestPerson();
                    personCollection.put(person.getId(), person);
                    break;

               /* case "info":
                    personCollection.printInfo();
                    break;
                    */
                case "exit":
                    //Выходим
                    System.exit(0);
                    break;

                case "remove_key null":
                    System.out.print("Введите ключ: ");
                    key = Integer.valueOf(scanner.nextLine());
                    personCollection.removeKey(key);
                    break;

                case "clear":
                    personCollection.clear();
                    break;

                case "remove_greater_key null":
                    System.out.print("Введите значение максимальный необходимый id: ");
                    key = Integer.valueOf(scanner.nextLine());
                    personCollection.removeGreaterKey(key);
                    break;

                case "show":
                    personCollection.show();
                    break;

                case "history":
                    history.stream()
                            .sorted(Comparator.reverseOrder())
                            .limit(15).forEach(System.out::println);
                    break;

                case "filter_starts_with_name":
                    System.out.print("Введите начало имени: ");
                    subName = scanner.nextLine();
                    personCollection.filterStartsWithName(subName);
                    break;

                case "replace_if_lowe null":
                    System.out.print("Введите ключ: ");
                    key = Integer.valueOf(scanner.nextLine());
                    personCollection.replaceIfLowe(key);
                    break;

                case "count_less_than_height":
                    System.out.print("Введите высоту: ");
                    height = Long.valueOf(scanner.nextLine());
                    personCollection.countLessThanHeight(height);
                    break;

                case "group_counting_by_nationality":
                    personCollection.groupCountingByNationality();
                    break;

                case "update id":
                    System.out.print("Введите ключ: ");
                    key = Integer.valueOf(scanner.nextLine());
                    personCollection.updateId(key);
                    break;

                default:
                    erunda = true;
                    System.out.println("Несуществующая, или неверно заданная команда! Проверьте корректность и повторите попытку.");
            }

            if (!erunda) {
                history.add(command);
            }

        }
    }
}
