package Model;

public class Line {
    static int startingId = 0;
    int id;
    Point startingPoint;
    Point endingPoint;
    Point middlePoint;

    //equation standard form: A*x + B*y + C = 0
    double a;
    double b;
    double c;

    public Line(Point startingPoint, Point endingPoint) {
        this.id = startingId;
        startingId++;
        this.startingPoint = startingPoint;
        this.endingPoint = endingPoint;
        this.a = endingPoint.getY() - startingPoint.getY();
        this.b = startingPoint.getX() - endingPoint.getX();
        this.c = (endingPoint.getX() * startingPoint.getY()) - (startingPoint.getX() * endingPoint.getY());
    }

    public Point getStartingPoint() {
        return startingPoint;
    }

    public Point getEndingPoint() {
        return endingPoint;
    }

    public Point getMiddlePoint() {
        return middlePoint;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getD1(Line anotherLine) {
        return (a * anotherLine.getStartingPoint().getX()) + (b * anotherLine.getStartingPoint().getY());
    }

    public double getD2(Line anotherLine) {
        return (a * anotherLine.getEndingPoint().getX()) + (b * anotherLine.getEndingPoint().getY());
    }

    @Override
    public String toString() {
        return "Line{" +
                "startingPoint=" + startingPoint +
                ", endingPoint=" + endingPoint +
                ", equation: " + a +"x +" + b +"y +" + c +" = 0"+
                '}';
    }
}
