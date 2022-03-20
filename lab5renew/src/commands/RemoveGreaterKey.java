package commands;

import util.CollectionManager;
import util.OutputUtil;

import java.util.Arrays;

public class RemoveGreaterKey extends Command{


    public RemoveGreaterKey() {
        super("remove_greater_key", " key : удалить из коллекции все элементы, ключ которых превышает заданный");

    }

    @Override
    public void execute(String s) {

        try {
            int keys[] = Arrays.stream(collectionManager.getPersonCollection().keySet().toArray()).mapToInt(i -> (int) i).toArray();
            long q = 0;
            for (int i : keys) {
                if (Integer.parseInt(s) < i) {
                    collectionManager.getPersonCollection().remove(i);
                    q++;
                }

            }
            OutputUtil.outputManagerLiner("Из коллекции удалено " + q + " элементов, превышающих заданный ключ");
        } catch (Exception e) {
            OutputUtil.outputManagerLiner("Неверный формат ключа");
        }
    }

}
