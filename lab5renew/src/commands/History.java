package commands;

import util.CollectionManager;
import util.CommandManager;

import java.util.Comparator;

public class History extends Command{
    private static CommandManager commandManager;

    public History(CommandManager commandManager) {
        super("history", " : вывести последние 15 команд (без их аргументов)");
        this.commandManager = commandManager;
    }

    @Override
    public void execute(String s) {
        commandManager.getHistory().stream()
                .sorted(Comparator.reverseOrder()).limit(15)
                .forEach(System.out::println);
    }
}
