package commands;
import collection.*;
import util.CollectionManager;
import util.OutputUtil;

public class Show extends Command{
    public static CollectionManager collectionManager;
    public Show(CollectionManager collectionManager) {
        super("show", " : вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String s) {
        for (Integer i : collectionManager.getPersonCollection().keySet()) {
            OutputUtil.outputManagerLiner("Ключ: " + i + ", " + collectionManager.getPersonCollection().get(i).toString());
        }
    }
}
