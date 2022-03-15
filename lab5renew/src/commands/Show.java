package commands;
import collection.*;
import util.CollectionManager;

public class Show extends Command{
    public static CollectionManager collectionManager;
    public Show(CollectionManager collectionManager) {
        super("show", " : вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String s) {
        for (Person i : collectionManager.getPersonCollection().values()) {
            System.out.println(i);
        }
    }
}
