import util.*;

import java.io.FileNotFoundException;



public class Main {

    public static void main(String[] args) {

        CollectionManager collectionManager = new CollectionManager("src\\Data.csv");
        InputUtil inputUtil = new InputUtil();
        HistoryManager historyManager = new HistoryManager();
        ScriptManager scriptManager = new ScriptManager();
        CommandManager commandManager = new CommandManager(collectionManager, inputUtil, historyManager, scriptManager);

        try {
            collectionManager.reader();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        commandManager.programStart();
    }
}
