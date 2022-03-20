import util.CollectionManager;
import util.CommandManager;
import util.InputUtil;
import util.OutputUtil;

import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        CollectionManager collectionManager = new CollectionManager("src\\Data.csv");
        InputUtil inputUtil = new InputUtil();
        CommandManager commandManager = new CommandManager(collectionManager, inputUtil);

        try {
            collectionManager.reader();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        commandManager.programStart();
    }
}
