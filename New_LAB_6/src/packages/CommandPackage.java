package packages;

import interfaces.IServer;
import interfaces.packages.ICommandPackage;

import java.util.List;

public class CommandPackage implements ICommandPackage {
    String commandName;
    List<Object> args;

    public CommandPackage(String commandName, List<Object> args) {
        this.commandName = commandName;
        this.args = args;
    }

    public String getCommandName() {
        return commandName;
    }

    public List<Object> getArgs() {
        return args;
    }
}
