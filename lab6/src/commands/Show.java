package commands;
import collection.*;
import util.CollectionManager;
import util.OutputUtil;

public class Show extends Command{
    public Show() {
        super("show", " : вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
    }

    @Override
    public void execute(String s) {
        for (Integer i : collectionManager.getPersonCollection().keySet()) {
            OutputUtil.outputManagerLiner("Ключ: " + i + "\n" + collectionManager.getPersonCollection().get(i).personOutput() +"\n");
        }
    }
}
