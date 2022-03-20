package commands;

import collection.*;
import util.CollectionManager;
import util.CommandManager;
import util.InputUtil;
import util.OutputUtil;

import java.time.ZonedDateTime;

public class Insert extends Command{



    public Insert() {
        super("insert"," key {element} : добавить новый элемент с заданным ключом");

    }

    @Override
    public void execute(String s) {
        try {
            if (!collectionManager.getPersonCollection().containsKey(Integer.valueOf(s))) {
                String name = inputUtil.requestName();
                Coordinates coordinates = new Coordinates(inputUtil.requestX(), inputUtil.requestY());
                long height = inputUtil.requestHeight();
                Integer weight = inputUtil.requestWeight();
                Color color = inputUtil.requestColor();
                Country country = inputUtil.requestCountry();
                Location location = new Location(inputUtil.requestLX(), inputUtil.requestLY(), inputUtil.requestLZ());
                ZonedDateTime creationDate = ZonedDateTime.now();

                Person person = new Person(name, coordinates, creationDate, height, weight, color, country, location);
                collectionManager.getPersonCollection().put(Integer.valueOf(s), person);
                OutputUtil.outputManagerLiner("Элемент успешно добавлен в коллекцию");
            } else {
                OutputUtil.outputManagerLiner("Элемент с таким ключом уже существует");
            }
        } catch (NumberFormatException e) {
            OutputUtil.outputManagerLiner("Неправильный формат ввода ключа");
        }
    }
}
