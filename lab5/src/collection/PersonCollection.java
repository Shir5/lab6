package collection;
import sun.security.krb5.internal.ETypeInfo;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;


public class PersonCollection extends LinkedHashMap<Integer, Person> {
    public void printInfo(){

        System.out.println("Тип коллекции: LinkedHashMap");
        System.out.println("Колл-во эл: " + size());

    }
    
}
