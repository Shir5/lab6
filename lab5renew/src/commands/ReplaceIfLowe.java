package commands;

import collection.*;
import util.CollectionManager;
import util.InputUtil;
import util.OutputUtil;

import java.time.ZonedDateTime;

public class ReplaceIfLowe extends Command{
    private CollectionManager collectionManager;

    public ReplaceIfLowe(CollectionManager collectionManager) {
        super("replace_if_lowe", " null {element} : заменить значение по ключу, если новое значение меньше старого");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String s) {
        try {
            if (collectionManager.getPersonCollection().containsKey(Integer.valueOf(s))) {
                String name = InputUtil.requestName();
                Coordinates coordinates = new Coordinates(InputUtil.requestX(), InputUtil.requestY());
                long height = InputUtil.requestHeight();
                Integer weight = InputUtil.requestWeight();
                Color color = InputUtil.requestColor();
                Country country = InputUtil.requestCountry();
                Location location = new Location(InputUtil.requestLX(), InputUtil.requestLY(), InputUtil.requestLZ());
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
