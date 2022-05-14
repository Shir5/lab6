package common;

import packages.CommandPackage;

import java.util.ArrayList;
import java.util.List;


public class CommandPacker {

    public static CommandPackage pack(String input) {
        List<Object> args = new ArrayList<Object>();
        String[] commandParts = input.trim().split(" ");
        if (commandParts.length == 0)
            return new CommandPackage("Error", args);
        if (commandParts.length == 1)
            return new CommandPackage(input, args);
        args.add(commandParts[1]);

        return new CommandPackage(commandParts[0], args);
    }
}
