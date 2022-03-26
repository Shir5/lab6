package commands;


import util.CollectionManager;
import util.OutputUtil;

public class Exit extends Command{
    public Exit() {
        super("exit", " : завершить программу (без сохранения в файл)");
    }



    @Override
    public void execute(String args) {
        OutputUtil.outputManager("Выход из программы");
        System.exit(0);
    }

}
