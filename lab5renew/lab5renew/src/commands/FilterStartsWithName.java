package commands;

import collection.Person;
import util.CollectionManager;
import util.OutputUtil;

public class FilterStartsWithName extends Command{
    private static CollectionManager collectionManager;

    public FilterStartsWithName(CollectionManager collectionManager) {
        super("filter_starts_with_name", " name : вывести элементы, значение поля name которых начинается с заданной подстроки");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String s) {
        for (Integer i : collectionManager.getPersonCollection().keySet()) {
            if (collectionManager.getPersonCollection().get(i).getName().startsWith(s))
                OutputUtil.outputManagerLiner(i.toString() + ", " + collectionManager.getPersonCollection().get(i));
        }
    }

}
