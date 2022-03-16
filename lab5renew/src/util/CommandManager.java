package util;

import collection.PersonCollection;
import commands.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class CommandManager {
    Map<String, Command> commands = new HashMap<>();

    public CommandManager(CollectionManager collectionManager) {
        for (Command command : Arrays.asList(
                new Help(this),
                new Insert(collectionManager),
                new Remove(collectionManager),
                new Update(collectionManager),
                new Info(collectionManager),
                new Save(collectionManager),
                new Show(collectionManager),
                new GroupCountingByNationality(collectionManager),
                new Exit(collectionManager)

        )) {
            commands.put(command.getName(), command);
        }
    }

    public void commandDetermine(String input) {
        String[] commandParts = input.split(" ");
        String command = commandParts[0].toLowerCase(Locale.ROOT);
        if (commands.containsKey(command)) {
            commands.get(command).execute(commandParts.length == 2 ? commandParts[1] : "");
        } else {
            OutputUtil.outputManagerLiner("Неизвестная команда");
        }
    }

    public Map<String, Command> getCommands() {
        return commands;
    }
}
