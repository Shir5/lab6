package commands;

import util.CollectionManager;

public class Clear extends Command{
    public static CollectionManager collectionManager;

    public Clear(CollectionManager collectionManager) {
        super("clear", " : очистить коллекцию");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String s) {
        collectionManager.getPersonCollection().clear();
    }
}
