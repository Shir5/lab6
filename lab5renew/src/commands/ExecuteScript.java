package commands;

import util.CommandManager;
import util.InputUtil;
import util.OutputUtil;

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
            InputUtil scriptInput = new InputUtil(s);
            CommandManager scriptCommandManager = new CommandManager(collectionManager, scriptInput);
            scriptCommandManager.programStart();
        } catch (FileNotFoundException e) {
            OutputUtil.outputManagerLiner("Файл не существует");
        } catch (NoSuchElementException у) {
            OutputUtil.outputManagerLiner("Скрипт выполнен");
        } catch (Exception e) {
            OutputUtil.outputManagerLiner("Ошибка выполнения");
       }
    }
}
