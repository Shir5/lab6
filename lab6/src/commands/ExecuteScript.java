package commands;

import util.CommandManager;
import util.InputUtil;
import util.OutputUtil;
import util.ScriptManager;

import java.io.FileNotFoundException;
import java.util.*;



public class ExecuteScript extends Command{

    public ExecuteScript() {
        super("execute_script"," file_name : считать и исполнить скрипт из указанного файла." +
                " В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном");
    }


    @Override
    public void execute(String s) {
        try {
            if (!scriptManager.getScriptManager().contains(s)) {
                InputUtil scriptInput = new InputUtil(s, collectionManager);
                CommandManager scriptCommandManager = new CommandManager(collectionManager, scriptInput, historyManager, scriptManager);
                scriptManager.getScriptManager().add(s);
                scriptCommandManager.programStart();
                scriptManager.getScriptManager().remove(scriptManager.getScriptManager().size()-1);
            } else {
                OutputUtil.outputManagerLiner("Скрипт уже выполняется");
            }
        } catch (FileNotFoundException e) {
            OutputUtil.outputManagerLiner("Файл не существует");
        } catch (NoSuchElementException e) {
            OutputUtil.outputManagerLiner("Скрипт выполнен");
        } catch (Exception e) {
            OutputUtil.outputManagerLiner("Ошибка выполнения");
       }
    }
}
