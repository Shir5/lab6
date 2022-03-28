package commands;

import collection.Country;
import collection.Person;
import util.CollectionManager;
import util.OutputUtil;

public class CountLessThanHeight extends Command{


    public CountLessThanHeight() {
        super("count_less_than_height", " height : вывести количество элементов, значение поля height которых меньше заданного");

    }

    @Override
    public void execute(String s) {
        try {
            long q = 0;
            for (Integer i : collectionManager.getPersonCollection().keySet()) {
                if (collectionManager.getPersonCollection().get(i).getHeight() < Long.parseLong(s))
                    q++;
            }
            OutputUtil.outputManagerLiner("Насчитано " + q + " элемента, высота которых меньше заданной");
        } catch (Exception e) {
            OutputUtil.outputManagerLiner("Высота задана неверно");
        }
    }
}
