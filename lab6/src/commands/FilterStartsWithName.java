package commands;


import util.OutputUtil;

public class FilterStartsWithName extends Command{


    public FilterStartsWithName() {
        super("filter_starts_with_name", " name : вывести элементы, значение поля name которых начинается с заданной подстроки");

    }

    @Override
    public void execute(String s) {
        for (Integer i : collectionManager.getPersonCollection().keySet()) {
            if (collectionManager.getPersonCollection().get(i).getName().startsWith(s))
                OutputUtil.outputManagerLiner(i.toString() + ", " + collectionManager.getPersonCollection().get(i));
        }
    }

}
