package commands;

import collection.*;
import util.CollectionManager;
import util.InputUtil;
import util.OutputUtil;

import java.time.ZonedDateTime;

public class Update extends Command{
    public static CollectionManager collectionManager;

    public Update(CollectionManager collectionManager) {
        super("update", " key {element} : добавить новый элемент с заданным ключом");
        this.collectionManager = collectionManager;

    }

    @Override
    public void execute(String s) {
        try {
            boolean consist = false;
            for (Integer i : collectionManager.getPersonCollection().keySet()) {
                if (collectionManager.getPersonCollection().get(i).getId().equals(Integer.valueOf(s))) {
                    consist = true;
                    Integer id = collectionManager.getPersonCollection().get(i).getId();
                    Integer oldKey = i;
                    collectionManager.getPersonCollection().remove(i);
                    break;
                }
            }
            if (consist) {
                Integer key = InputUtil.requestKey();
                String name = InputUtil.requestName();
                Coordinates coordinates = new Coordinates(InputUtil.requestX(), InputUtil.requestY());
                long height = InputUtil.requestHeight();
                Integer weight = InputUtil.requestWeight();
                Color color = InputUtil.requestColor();
                Country country = InputUtil.requestCountry();
                Location location = new Location(InputUtil.requestLX(), InputUtil.requestLY(), InputUtil.requestLZ());
                ZonedDateTime creationDate = ZonedDateTime.now();

                Person person = new Person(name, coordinates, creationDate, height, weight, color, country, location);
                person.setId(Integer.valueOf(s));
                collectionManager.getPersonCollection().put(key, person);
            } else {
                OutputUtil.outputManagerLiner("Элемент с заданным id не существует");
            }
        } catch (Exception e) {
            OutputUtil.outputManagerLiner("Неверный формат ввода id");
        }
    }
}
