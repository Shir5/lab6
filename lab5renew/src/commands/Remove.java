package commands;

import util.CollectionManager;
import util.OutputUtil;

public class Remove extends Command{
    public static CollectionManager collectionManager;

    public Remove(CollectionManager collectionManager) {
        super("remove_key", " key : удалить элемент из коллекции по его ключу");
    }

    @Override
    public void execute(String s) {

        if (collectionManager.getPersonCollection().containsKey(Integer.valueOf(s))) {
            collectionManager.getPersonCollection().remove(Integer.valueOf(s));
            OutputUtil.outputManagerLiner("Элемент удалён успешно");
        } else
            OutputUtil.outputManagerLiner("Элемента с таким ключом не существует");

    }

}
