package Model;

public class Point {
    static int startingId = 0;
    private int id;
    private double x;
    private double y;
    boolean inside;

    public Point(double x, double y) {
        this.id = startingId;
        startingId++;
        this.x = x;
        this.y = y;
    }

    public void add(Point anotherPoint){
        x = x + anotherPoint.getX();
        y = y + anotherPoint.getY();
    }

    public int getId() {
        return id;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public boolean isInside() {
        return inside;
    }

    public void setInside() {
        this.inside = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public String toString() {
        return "Model.Point "+ id +"{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
