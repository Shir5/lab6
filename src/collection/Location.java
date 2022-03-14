package collection;

public class Location {
    private int x;
    private float y;
    private float z;
    public Location(int x, float y, float z){
        this.x = x;
        this.y = y;
        this.z = z;

    }
    @Override
    public String toString() {
        return "{" + "x=" + x + ", y=" + y + ", z=" + z + '}';
    }

}
