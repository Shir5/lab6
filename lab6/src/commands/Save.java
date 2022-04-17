package commands;

import collection.PersonCollection;
import util.CollectionManager;
import util.OutputUtil;

import java.io.FileNotFoundException;

public class Save extends Command{


    public Save() {
        super("save", " : сохранить коллекцию в файл");

    }

    @Override
    public void execute(String s) {
        try {
            collectionManager.writer();
            OutputUtil.outputManagerLiner("Коллекция сохранена успешно");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
