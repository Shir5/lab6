package commands;

import collection.*;
import util.CollectionManager;
import util.InputUtil;
import util.OutputUtil;

import java.time.ZonedDateTime;

public class Update extends Command{

    public Update() {
        super("update", " key {element} : добавить новый элемент с заданным ключом");

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
                Integer key = inputUtil.requestKey();
                String name = inputUtil.requestName();
                Coordinates coordinates = new Coordinates(inputUtil.requestX(), inputUtil.requestY());
                long height = inputUtil.requestHeight();
                Integer weight = inputUtil.requestWeight();
                Color color = inputUtil.requestColor();
                Country country = inputUtil.requestCountry();
                Location location = new Location(inputUtil.requestLX(), inputUtil.requestLY(), inputUtil.requestLZ());
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
