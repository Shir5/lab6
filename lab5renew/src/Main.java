import collection.PersonCollection;
import util.CommandManager;
import util.CollectionManager;
import util.InputUtil;

import java.io.FileNotFoundException;


public class Main {

    public static void main(String[] args) {

        CollectionManager collectionManager = new CollectionManager("src\\Data.csv");
        CommandManager commandManager = new CommandManager(collectionManager);

        try {
            collectionManager.reader();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        while (true) {
            commandManager.commandDetermine(InputUtil.requestCommand());
        }


    }
}
