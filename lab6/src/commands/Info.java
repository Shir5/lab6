package commands;

import util.OutputUtil;

public class Info extends Command{


    public Info() {
        super("info", " : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");

    }

    @Override
    public void execute(String s) {
        OutputUtil.outputManagerLiner("Тип класса: " + collectionManager.getPersonCollection().getClass().getSuperclass().toString() +
                "\nДата инициализации: " + collectionManager.getFileDate() +
                "\nКол-во элементов: " + collectionManager.getPersonCollection().size());
    }
}
