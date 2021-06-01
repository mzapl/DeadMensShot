package Model;

public class Line {
    static int startingId = 0;
    int id;
    Point startingPoint;
    Point endingPoint;

    //equation standard form: A*x + B*y + C = 0
    double a;
    double b;
    double c;

    String equation;

    public Line(Point startingPoint, Point endingPoint) {
        this.id = startingId;
        startingId++;
        this.startingPoint = startingPoint;
        this.endingPoint = endingPoint;
        this.a = endingPoint.getY() - startingPoint.getY();
        this.b = startingPoint.getX() - endingPoint.getX();
        this.c = (endingPoint.getX() * startingPoint.getY()) - (startingPoint.getX() * endingPoint.getY());
        this.equation = a +"x +" + b +"y +" + c +" = 0";
    }

    public int getId() {
        return id;
    }

    public Point getStartingPoint() {
        return startingPoint;
    }

    public Point getEndingPoint() {
        return endingPoint;
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
        double D1 = (a * anotherLine.getStartingPoint().getX()) + (b * anotherLine.getStartingPoint().getY()) + c;
        return D1;
    }

    public double getD2(Line anotherLine) {
        double D2 = (a * anotherLine.getEndingPoint().getX()) + (b * anotherLine.getEndingPoint().getY()) + c;
        return D2;
    }

    public String getEquation() {
        return equation;
    }

    @Override
    public String toString() {
        return "Line"+ id + "{" +
                "startingPoint=" + startingPoint +
                ", endingPoint=" + endingPoint +
                ", equation: " + a +"x +" + b +"y +" + c +" = 0"+
                '}';
    }
}
