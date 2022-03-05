package collection;
import java.lang.reflect.ParameterizedType;
import java.util.LinkedHashMap;


public class PersonCollection extends LinkedHashMap<Integer, Person> {
    public void printInfo(){
        System.out.println("Колл-во элементов:" + size() + " Тип коллекции" );
    }
}
