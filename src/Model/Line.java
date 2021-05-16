package Model;

public class Line {
    static int startingId = 0;
    int id;
    Point startingPoint;
    Point endingPoint;
    Point middlePoint;

    //equation is ax+b
    double a;
    double b;
    double c;
    double d;

    public Line(Point startingPoint, Point endingPoint) {
        this.id = startingId;
        startingId++;
        this.startingPoint = startingPoint;
        this.endingPoint = endingPoint;
        this.middlePoint = setMiddlePoint(startingPoint, endingPoint);
        this.a = endingPoint.getY() - startingPoint.getY();
        this.b = startingPoint.getX() - endingPoint.getX();
        this.c = (endingPoint.getX() * startingPoint.getY()) - (startingPoint.getX() * endingPoint.getY());
        this.d = (a * startingPoint.getX()) + (b * startingPoint.getY()) + c;
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

    public double getD() {
        return d;
    }

    @Override
    public String toString() {
        return "Line{" +
                "startingPoint=" + startingPoint +
                ", endingPoint=" + endingPoint +
                ", equation: " + a +"x +" + b +"y +" + c +" = 0"+
                ", d=" + d +
                '}';
    }

    private Point setMiddlePoint(Point startingPoint, Point endingPoint){
        return new Point((startingPoint.getX() + endingPoint.getX()) / 2, (startingPoint.getY() + endingPoint.getY()) / 2);
    }

}
