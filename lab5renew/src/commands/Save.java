package commands;

import collection.PersonCollection;
import util.CollectionManager;

import java.io.FileNotFoundException;

public class Save extends Command{
    public static CollectionManager collectionManager;

    public Save(CollectionManager collectionManager) {
        super("save", " : сохранить коллекцию в файл");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String s) {
        try {
            collectionManager.writer();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
