package util;

import commands.*;

import java.util.*;

/**
 * Класс, обрабатывающий команды
 */

public class CommandManager {
    Map<String, Command> commands = new HashMap<>();
    InputUtil inputUtil;
    CollectionManager collectionManager;
    HistoryManager historyManager;
    ScriptManager scriptManager;

    public CommandManager(CollectionManager collectionManager, InputUtil inputUtil,
                          HistoryManager historyManager, ScriptManager scriptManager) {
        this.inputUtil = inputUtil;
        this.collectionManager = collectionManager;
        this.historyManager = historyManager;
        this.scriptManager = scriptManager;
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
            command.setHistoryManager(this.historyManager);
            command.setScriptManager(this.scriptManager);
        }
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
            historyManager.getHistory().add(commandParts[0]);
            commands.get(command).execute(commandParts.length == 2 ? commandParts[1] : "");
        } else {
            OutputUtil.outputManagerLiner("Неизвестная команда");
        }
    }



    public Map<String, Command> getCommands() {
        return commands;
    }




}
