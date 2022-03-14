package collection;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;
import sun.security.krb5.internal.ETypeInfo;
import util.InputUtil;

import java.util.*;

import sun.security.krb5.internal.ETypeInfo;

import javax.crypto.spec.PSource;


public class PersonCollection extends LinkedHashMap<Integer, Person> {
    Date date = new Date();

    public void printInfo(){
        System.out.println( "Тип класса " + getClass().getSuperclass().toString() +
                "\nДата инициализации: " + date +
                "\nКол-во элементов: " + size());
    }

    public void insertNull(){
        Person person = InputUtil.requestPerson();
        put(person.getId(), person);
    }

    public static void help() {
        System.out.println("Доступные команды : \nClear - очистить" +
                " коллекцию \ninsert null: добавить новый элемент с заданным" +
                " ключом \ninfo : вывести в стандартный поток вывода информацию о коллекции" +
                " (тип, количество элементов и т.д.) \nshow : вывести в стандартный поток вывода " +
                "все элементы коллекции в строковом представлении \nupdate id {element} : обновить" +
                " значение элемента коллекции, id которого равен заданному \nremove_key null : удалить" +
                " элемент из коллекции по его ключу \nsave : сохранить коллекцию в файл \nexecute_script" +
                " file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды" +
                " в таком же виде, в котором их вводит пользователь в интерактивном режиме. \nhistory : " +
                "вывести последние 15 команд (без их аргументов) \nreplace_if_lowe null {element} : заменить" +
                " значение по ключу, если новое значение меньше старого \nremove_greater_key null : удалить" +
                " из коллекции все элементы, ключ которых превышает заданный \ngroup_counting_by_nationality" +
                " : сгруппировать элементы коллекции по значению поля nationality, вывести количество элементов" +
                " в каждой группе \ncount_less_than_height height : вывести количество элементов, значение поля" +
                " height которых меньше заданного \nfilter_starts_with_name name : вывести элементы, значение поля name " +
                "которых начинается с заданной подстроки \nexit : завершить программу (без сохранения в файл)" );

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

