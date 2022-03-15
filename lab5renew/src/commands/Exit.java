package commands;


import util.CollectionManager;

public class Exit extends Command{
    public Exit(CollectionManager collectionManager) {
        super("exit", " : завершить программу (без сохранения в файл)");
    }



    @Override
    public void execute(String args) {
        System.out.println("Выход из программы");
        System.exit(0);
    }

}
