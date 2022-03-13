package collection;

public class Location {
    private int x;
    private float y;

    @Override
    public String toString() {
        return "{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    private float z;
    public Location(int x, float y, float z){
        this.x = x;
        this.y = y;
        this.z = z;

    }
}
