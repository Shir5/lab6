package commands;

import util.CommandManager;

import java.util.*;

public class Help extends Command{
    public static CommandManager commandManager;
    public Help(CommandManager commandManager) {
        super("help", " : вывести справку по доступным командам");
        this.commandManager = commandManager;
    }

    @Override
    public void execute(String s) {

        for (String i : commandManager.getCommands().keySet())
            System.out.println(i +
                    commandManager.getCommands().get(i).getDescription().toString());



    }
}
