public class Line {
    static int startingId = 0;
    int id = 0;
    Point startingPoint;
    Point endingPoint;
    Point middlePoint;

    //equation is ax+b
    double a;
    double b;

    public Line(Point startingPoint, Point endingPoint) {
        this.id = startingId;
        startingId++;
        this.startingPoint = startingPoint;
        this.endingPoint = endingPoint;
        this.middlePoint = setMiddlePoint(startingPoint, endingPoint);
        a = (double)(endingPoint.getY()-startingPoint.getY()) / (endingPoint.getX() - startingPoint.getX());
        b = (startingPoint.getY()) - (a * startingPoint.getX());
    }

    @Override
    public String toString() {
        return "Line{" +
                "id=" + id +
                ", startingPoint=" + startingPoint +
                ", endingPoint=" + endingPoint +
                ", middlePoint=" + middlePoint +
                ", equation: y="+ a +"*x + "+ b+
                '}';
    }

    private Point setMiddlePoint(Point startingPoint, Point endingPoint){
        return new Point((startingPoint.getX() + endingPoint.getX()) / 2, (startingPoint.getY() + endingPoint.getY()) / 2);
    }

}
