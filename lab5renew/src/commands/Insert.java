package commands;

import collection.*;
import util.CollectionManager;
import util.InputUtil;

import java.time.ZonedDateTime;

public class Insert extends Command{
    public static CollectionManager collectionManager;

    public Insert(CollectionManager collectionManager) {
        super("insert"," key {element} : добавить новый элемент с заданным ключом");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String s) {
        if (!collectionManager.getPersonCollection().containsKey(Integer.valueOf(s))) {
            String name = InputUtil.requestName();
            Coordinates coordinates = new Coordinates(InputUtil.requestX(), InputUtil.requestY());
            long height = InputUtil.requestHeight();
            Integer weight = InputUtil.requestWeight();
            Color color = InputUtil.requestColor();
            Country country = InputUtil.requestCountry();
            Location location = new Location(InputUtil.requestLX(), InputUtil.requestLY(), InputUtil.requestLZ());
            ZonedDateTime creationDate = ZonedDateTime.now();

            Person person = new Person(name, coordinates, creationDate, height, weight, color, country, location);
            collectionManager.getPersonCollection().put(Integer.valueOf(s), person);
        }   else {
            System.out.println("Элемент с таким ключом уже существует");
        }
    }
}
