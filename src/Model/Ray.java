package Model;

public class Ray extends Line{
    private int intersections;

    public Ray(Point startingPoint, Point endingPoint) {
        super(startingPoint, endingPoint);
        intersections = 0;
    }

    public int getIntersections() {
        return intersections;
    }

    public void setIntersections(int intersections) {
        this.intersections = intersections;
    }

    public void newIntersection(){
        intersections ++;
    }

    @Override
    public String toString() {
        return "Ray{" +
                "id=" + id +
                ", startingPoint=" + startingPoint +
                ", endingPoint=" + endingPoint +
                ", intersections=" + intersections +
                '}';
    }
}
