package commands;

import collection.*;
import util.CollectionManager;
import util.InputUtil;
import util.OutputUtil;

import java.time.ZonedDateTime;

public class ReplaceIfLower extends Command{

    public ReplaceIfLower() {
        super("replace_if_lower", " null {element} : заменить значение по ключу, если новое значение меньше старого");

    }

    @Override
    public void execute(String s) {
        try {
            if (collectionManager.getPersonCollection().containsKey(Integer.valueOf(s))) {
                String name = inputUtil.requestName();
                Coordinates coordinates = new Coordinates(inputUtil.requestX(), inputUtil.requestY());
                long height = inputUtil.requestHeight();
                Integer weight = inputUtil.requestWeight();
                Color color = inputUtil.requestColor();
                Country country = inputUtil.requestCountry();
                Location location = new Location(inputUtil.requestLX(), inputUtil.requestLY(), inputUtil.requestLZ());
                ZonedDateTime creationDate = ZonedDateTime.now();

                Person person = new Person(name, coordinates, creationDate, height, weight, color, country, location);

                if (person.getHeight() < collectionManager.getPersonCollection().get(Integer.valueOf(s)).getHeight()) {
                    collectionManager.getPersonCollection().replace(Integer.valueOf(s), person);
                    OutputUtil.outputManagerLiner("Элемент заменен успешно");
                } else {
                    OutputUtil.outputManagerLiner("Замена не проведена");
                }
            } else {
                OutputUtil.outputManagerLiner("Элемента с таким ключом не существует");
            }
        } catch (Exception e) {
            OutputUtil.outputManagerLiner("Значение ключа не верно");
        }
    }
}
