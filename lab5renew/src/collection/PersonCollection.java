package collection;

import java.util.*;


public class PersonCollection extends LinkedHashMap<Integer, Person> {
    Date date = new Date();

    public Date getDate() {
        return date;
    }
}

