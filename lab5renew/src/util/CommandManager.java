package util;

import collection.PersonCollection;
import commands.*;

import java.util.*;

public class CommandManager {
    Map<String, Command> commands = new HashMap<>();
    List history;

    public CommandManager(CollectionManager collectionManager) {
        for (Command command : Arrays.asList(
                new Help(this),
                new History(this),
                new Insert(collectionManager),
                new Remove(collectionManager),
                new Update(collectionManager),
                new Info(collectionManager),
                new Save(collectionManager),
                new Show(collectionManager),
                new Clear(collectionManager),
                new FilterStartsWithName(collectionManager),
                new GroupCountingByNationality(collectionManager),
                new Exit(collectionManager)

        )) {
            commands.put(command.getName(), command);
        }
        history = new ArrayList();
    }

    public void commandDetermine(String input) {
        String[] commandParts = input.split(" ");
        String command = commandParts[0].toLowerCase(Locale.ROOT);
        if (commands.containsKey(command)) {
            commands.get(command).execute(commandParts.length == 2 ? commandParts[1] : "");
            history.add(commandParts[0]);
        } else {
            OutputUtil.outputManagerLiner("Неизвестная команда");
        }
    }

    public Map<String, Command> getCommands() {
        return commands;
    }

    public List getHistory() {
        return history;
    }
}
