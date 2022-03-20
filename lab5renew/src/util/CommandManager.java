package util;

import commands.*;

import java.util.*;

public class CommandManager {
    Map<String, Command> commands = new HashMap<>();
    List history;
    InputUtil inputUtil;
    CollectionManager collectionManager;

    public CommandManager(CollectionManager collectionManager, InputUtil inputUtil) {
        this.inputUtil = inputUtil;
        this.collectionManager = collectionManager;
        for (Command command : Arrays.asList(
                new Help(),
                new History(),
                new Insert(),
                new Remove(),
                new Update(),
                new Info(),
                new Save(),
                new Show(),
                new Clear(),
                new FilterStartsWithName(),
                new GroupCountingByNationality(),
                new CountLessThanHeight(),
                new ReplaceIfLower(),
                new RemoveGreaterKey(),
                new ExecuteScript(),
                new Exit()

        )) {
            commands.put(command.getName(), command);
            command.setCommandManager(this);
            command.setInputUtil(this.inputUtil);
            command.setCollectionManager(this.collectionManager);
        }
        history = new ArrayList();
    }


    public void programStart() {
        while (true) {
            commandDetermine(inputUtil.requestCommand());
        }
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
