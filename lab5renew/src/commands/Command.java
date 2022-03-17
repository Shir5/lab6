package commands;


public abstract class Command {
    String name;
    String description;

    public Command(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public abstract void execute(String s);

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
