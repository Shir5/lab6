package commands;

import util.CollectionManager;
import util.OutputUtil;

public class Remove extends Command{


    public Remove() {
        super("remove_key", " key : удалить элемент из коллекции по его ключу");

    }

    @Override
    public void execute(String s) {
        try {
            Integer key = Integer.valueOf(s);


            if (collectionManager.getPersonCollection().containsKey(Integer.valueOf(s))) {
                collectionManager.getPersonCollection().remove(Integer.valueOf(s));
                OutputUtil.outputManagerLiner("Элемент удалён успешно");
            } else
                OutputUtil.outputManagerLiner("Элемента с таким ключом не существует");
        } catch (Exception e) {
            OutputUtil.outputManagerLiner("Неправильный формат ключа");
        }

    }

}
