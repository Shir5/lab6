package commands;

import util.CollectionManager;

public class Clear extends Command{


    public Clear() {
        super("clear", " : очистить коллекцию");

    }

    @Override
    public void execute(String s) {
        collectionManager.getPersonCollection().clear();
    }
}
