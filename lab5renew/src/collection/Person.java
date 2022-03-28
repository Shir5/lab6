package collection;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Person implements Comparable<Person> {
    private Integer id = ++counter; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой

    @Override
    public String toString() {
        return
                "id: " + id +
                ", Имя: " + name +
                ", Координаты: " + coordinates +
                ", Дата и время: " + creationDate.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")) +
                ", Высота: " + height +
                ", Вес: " + weight +
                ", Цвет волос: " + hairColor +
                ", Национальность: " + nationality +
                ", Локация: " + location;
    }

    public String toString1() {
        return
                        name +
                        ", " + coordinates.toString1() +
                        ", " + height +
                        ", " + weight +
                        ", " + hairColor +
                        ", " + nationality +
                        ", " + location.toString1();
    }

    private Coordinates coordinates; //Поле не может быть null
    private ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Long height; //Поле может быть null, Значение поля должно быть больше 0
    private Integer weight; //Поле не может быть null, Значение поля должно быть больше 0
    private Color hairColor; //Поле может быть null
    private Country nationality; //Поле не может быть null
    private Location location; //Поле может быть null
    private static int counter = 0;

    public Integer getId() {return id;}

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(ZonedDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Long getHeight() {
        return height;
    }

    public void setHeight(Long height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Color getHairColor() {
        return hairColor;
    }

    public void setHairColor(Color hairColor) {
        this.hairColor = hairColor;
    }

    public Country getNationality() {
        return nationality;
    }

    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Person (String name, Coordinates coordinates,
                   ZonedDateTime creationDate, Long height, Integer weight, Color hairColor, Country nationality, Location location) {


        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.height = height;
        this.weight = weight;
        this.hairColor = hairColor;
        this.nationality = nationality;
        this.location = location;

    }



    @Override
    public int compareTo(Person p) {

        return Integer.compare(id, p.id);

    }
}

    

   


