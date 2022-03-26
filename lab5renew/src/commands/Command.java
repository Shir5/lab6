package commands;


import util.*;

public abstract class Command {
    String name;
    String description;
    InputUtil inputUtil;
    CollectionManager collectionManager;
    CommandManager commandManager;
    HistoryManager historyManager;
    ScriptManager scriptManager;

    public Command(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public abstract void execute(String s);

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setCommandManager(CommandManager commandManager) {this.commandManager = commandManager;}

    public void setInputUtil(InputUtil inputUtil) {this.inputUtil = inputUtil;}

    public void setCollectionManager(CollectionManager collectionManager) {this.collectionManager = collectionManager;}

    public void setHistoryManager(HistoryManager historyManager) {this.historyManager = historyManager;}

    public void setScriptManager(ScriptManager scriptManager) {this.scriptManager = scriptManager;}
}
