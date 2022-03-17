package commands;

import util.CollectionManager;
import util.OutputUtil;

public class Info extends Command{
    public static CollectionManager collectionManager;

    public Info(CollectionManager collectionManager) {
        super("info", " : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String s) {
        OutputUtil.outputManagerLiner("Тип класса " + getClass().getSuperclass().toString() +
                "\nДата инициализации: " + collectionManager.getPersonCollection().getDate() +
                "\nКол-во элементов: " + collectionManager.getPersonCollection().size());
    }
}
