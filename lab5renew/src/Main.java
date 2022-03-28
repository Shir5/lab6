import util.*;

import java.io.FileNotFoundException;

/**
 * Main class
 * @autors Погрибняк Иван, Демурчан Владимир
 */


public class Main {

    public static void main(String[] args) {

        CollectionManager collectionManager = new CollectionManager(args[0]);
        InputUtil inputUtil = new InputUtil(collectionManager);
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
