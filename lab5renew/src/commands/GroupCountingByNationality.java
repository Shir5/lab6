package commands;

import collection.Country;
import collection.Person;
import util.CollectionManager;
import util.OutputUtil;

public class GroupCountingByNationality extends Command{
    public static CollectionManager collectionManager;

    public GroupCountingByNationality(CollectionManager collectionManager) {
        super("group_counting_by_nationality", " : сгруппировать" +
                " элементы коллекции по значению поля nationality, вывести количество элементов в каждой группе");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String s) {
        long uk = 0;
        long germany = 0;
        long italy = 0;
        long nk = 0;
        long japan = 0;

        OutputUtil.outputManagerLiner("Объединённое королевство:");
        for (Integer i : collectionManager.getPersonCollection().keySet()) {
            if (collectionManager.getPersonCollection().get(i).getNationality().equals(Country.UNITED_KINGDOM)){
                OutputUtil.outputManagerLiner(collectionManager.getPersonCollection().get(i).toString());
                uk++;
            }

        }
        OutputUtil.outputManagerLiner(uk + " элементов");
        OutputUtil.outputManagerLiner("");

        OutputUtil.outputManagerLiner("Германия:");
        for (Integer i : collectionManager.getPersonCollection().keySet()) {
            if (collectionManager.getPersonCollection().get(i).getNationality().equals(Country.GERMANY)){
                OutputUtil.outputManagerLiner(collectionManager.getPersonCollection().get(i).toString());
                germany++;
            }

        }
        OutputUtil.outputManagerLiner(germany + " элементов");
        OutputUtil.outputManagerLiner("");

        OutputUtil.outputManagerLiner("Италия");
        for (Integer i : collectionManager.getPersonCollection().keySet()) {
            if (collectionManager.getPersonCollection().get(i).getNationality().equals(Country.ITALY)){
                OutputUtil.outputManagerLiner(collectionManager.getPersonCollection().get(i).toString());
                italy++;
            }

        }
        OutputUtil.outputManagerLiner(italy + " элементов");
        OutputUtil.outputManagerLiner("");

        OutputUtil.outputManagerLiner("Северная корея:");
        for (Integer i : collectionManager.getPersonCollection().keySet()) {
            if (collectionManager.getPersonCollection().get(i).getNationality().equals(Country.NORTH_KOREA)){
                OutputUtil.outputManagerLiner(collectionManager.getPersonCollection().get(i).toString());
                nk++;
            }

        }
        OutputUtil.outputManagerLiner(nk + " элементов");
        OutputUtil.outputManagerLiner("");

        OutputUtil.outputManagerLiner("Япония:");
        for (Integer i : collectionManager.getPersonCollection().keySet()) {
            if (collectionManager.getPersonCollection().get(i).getNationality().equals(Country.JAPAN)){
                OutputUtil.outputManagerLiner(collectionManager.getPersonCollection().get(i).toString());
                japan++;
            }

        }
        OutputUtil.outputManagerLiner(japan + " элементов");
        OutputUtil.outputManagerLiner("");
    }
}
