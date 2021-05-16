package Model;

public class Point {
    static int startingId = 0;
    private int id;
    private double x;
    private double y;

    public Point(double x, double y) {
        this.id = startingId;
        startingId++;
        this.x = x;
        this.y = y;
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
