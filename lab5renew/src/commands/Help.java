package commands;

import util.CommandManager;
import util.OutputUtil;

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
            OutputUtil.outputManagerLiner(i +
                    commandManager.getCommands().get(i).getDescription().toString());



    }
}
