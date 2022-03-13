package collection;

import util.InputUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;


public class PersonCollection extends LinkedHashMap<Integer, Person> {
    public void printInfo(){

        System.out.println("Тип коллекции: LinkedHashMap");
        System.out.println("Колл-во эл: " + size());

    }

    public void removeGreaterKey (Integer id){

        int keys [] = Arrays.stream(keySet().toArray()).mapToInt(i-> (int) i).toArray();
        for (int i : keys) {
            if (id < i) {
                remove(i);
            }
        }
    }

    public void show() {
        for (Person i : values()) {
            System.out.println(i);
        }
    }

    public void filterStartsWithName(String subName) {
        for (Person i : values()) {
            if (i.getName().startsWith(subName))
                System.out.println(i);
        }
    }

    public void replaceIfLowe(Integer key) {
        if (containsKey(key)){
            Person person = InputUtil.requestPerson();
            if (person.getHeight()>get(key).getHeight()) {
                person.setId(key);
                put(key,person);
                System.out.println("Элемент заменен успешно");
            } else{
                System.out.println("Новый элемент не обладает достаточной высотой для замены");
            }
        } else {
            System.out.println("Ключ неверный");
        }
    }

    public void removeKey(Integer key) {
        if (containsKey(key)) {
            remove(key);
        } else {
            System.out.println("Несуществующий id элемента!");
        }

    }

    public void countLessThanHeight(long height) {
        long q = 0;
        for (Person i : values()) {
            if (i.getHeight() < height)
                q++;
        }
        System.out.println("Насчитано " + q + " элемента, высота которых меньше заданной");
    }

    public void updateId(Integer key) {
        if (containsKey(key)){
            Person person = InputUtil.requestPerson();
            person.setId(key);
            put(key, person);
        } else {
            System.out.println("Ключ неверный");
        }
    }

    public void groupCountingByNationality() {
        long uk = 0;
        long germany = 0;
        long italy = 0;
        long nk = 0;
        long japan = 0;

        System.out.println("Объединённое королевство:");
        for (Person i : values()) {
            if (i.getNationality().equals(Country.UNITED_KINGDOM)){
                System.out.println(i.toString());
                uk++;
            }

        }
        System.out.println(uk + " элементов");
        System.out.println();

        System.out.println("Германия:");
        for (Person i : values()) {
            if (i.getNationality().equals(Country.GERMANY)){
                System.out.println(i.toString());
                germany++;
            }

        }
        System.out.println(germany + " элементов");
        System.out.println();

        System.out.println("Италия");
        for (Person i : values()) {
            if (i.getNationality().equals(Country.ITALY)){
                System.out.println(i.toString());
                italy++;
            }

        }
        System.out.println(italy + " элементов");
        System.out.println();

        System.out.println("Северная корея:");
        for (Person i : values()) {
            if (i.getNationality().equals(Country.NORTH_KOREA)){
                System.out.println(i.toString());
                nk++;
            }

        }
        System.out.println(nk + " элементов");
        System.out.println();

        System.out.println("Япония:");
        for (Person i : values()) {
            if (i.getNationality().equals(Country.JAPAN)){
                System.out.println(i.toString());
                japan++;
            }

        }
        System.out.println(japan + " элементов");
        System.out.println();
    }


}
