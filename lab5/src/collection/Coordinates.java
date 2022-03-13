package collection;

public class Coordinates {
    private float x; //Значение поля должно быть больше -315
    private double y; //Значение поля должно быть больше -188

    @Override
    public String toString() {
        return "{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public Coordinates(float x, double y){
        this.x = x;
        this.y = y;

    }
}


