package commands;

import util.CollectionManager;
import util.CommandManager;

import java.util.Comparator;

public class History extends Command{


    public History() {
        super("history", " : вывести последние 15 команд (без их аргументов)");

    }

    @Override
    public void execute(String s) {
        commandManager.getHistory().stream()
                .sorted(Comparator.reverseOrder()).limit(15)
                .forEach(System.out::println);
    }
}
