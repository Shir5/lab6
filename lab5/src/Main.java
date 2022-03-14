import collection.Person;
import collection.PersonCollection;
import util.InputUtil;
import java.util.*;


public class Main {

    public static void main(String[] args) throws Exception{

        Scanner scanner = new Scanner(System.in);
        PersonCollection personCollection = new PersonCollection();
        String command = "";
        List history = new ArrayList();
        boolean erunda;

        while (true) {

            command = scanner.nextLine().trim().toLowerCase(Locale.ROOT);

            erunda = false;

            switch (command) {
                case "help":
                    PersonCollection.help();
                    break;
                case "insert null":
                    personCollection.insertNull();
                    break;

               case "info":
                    personCollection.printInfo();
                    break;

                case "exit":
                    System.exit(0);
                    break;

                case "remove_key null":
                    personCollection.removeKey(InputUtil.requestKey());
                    break;

                case "clear":
                    personCollection.clear();
                    break;

                case "remove_greater_key null":
                    personCollection.removeGreaterKey(InputUtil.requestKey());
                    break;

                case "show":
                    personCollection.show();
                    break;

                case "history":
                    history.stream().sorted(Comparator.reverseOrder()).limit(15).forEach(System.out::println);
                    break;

                case "filter_starts_with_name":
                    personCollection.filterStartsWithName(InputUtil.requestSubName());
                    break;

                case "replace_if_lowe null":
                    personCollection.replaceIfLowe(InputUtil.requestKey());
                    break;

                case "count_less_than_height":
                    personCollection.countLessThanHeight(InputUtil.requestHeight());
                    break;

                case "group_counting_by_nationality":
                    personCollection.groupCountingByNationality();
                    break;

                case "update id":
                    personCollection.updateId(InputUtil.requestKey());
                    break;

                default:
                    erunda = true;
                    System.out.println("Несуществующая, или неверно заданная команда! Проверьте корректность и повторите попытку");
            }

            if (!erunda) {
                history.add(command);
            }

        }
    }
}
