public class Line {
    static int startingId = 0;
    int id = 0;
    Point startingPoint;
    Point endingPoint;

    //equation is ax+b
    double a;
    double b;

    public Line(Point startingPoint, Point endingPoint) {
        this.id = startingId;
        startingId++;
        this.startingPoint = startingPoint;
        this.endingPoint = endingPoint;
        a = (double)(endingPoint.getY()-startingPoint.getY()) / (endingPoint.getX() - startingPoint.getX());
        b = (startingPoint.getY()) - (a * startingPoint.getX());
        System.out.println("New line! equation y="+ a +"*x + "+ b);
    }

    @Override
    public String toString() {
        return "Line "+ id + "{" +
                "startingPoint=" + startingPoint +
                ", endingPoint=" + endingPoint +
                '}';
    }
}
