public class Line2Line {
    Line firstLine;
    Line anotherLine;
    double det;
    double x;
    double y;

    boolean areParallel;
    Point intersectionPoint;

    public Line2Line(Line firstLine, Line anotherLine) {
        this.firstLine = firstLine;
        this.anotherLine = anotherLine;
        det = (firstLine.a * anotherLine.b) - (anotherLine.a * firstLine.b);

        areParallel = parallel();
        intersectionPoint = intersection();
    }

    boolean parallel(){
        return this.det == 0;
    }

    Point intersection(){
        x = ((anotherLine.b) - (firstLine.b)) / det;
        y = ((firstLine.a) - (anotherLine.a)) / det;
        return new Point(x, y);
    }

    @Override
    public String toString() {
        return "Line2Line{" +
                "firstLine=" + firstLine +
                ", anotherLine=" + anotherLine +
                ", det=" + det +
                ", x=" + x +
                ", y=" + y +
                ", areParallel=" + areParallel +
                ", intersectionPoint=" + intersectionPoint +
                '}';
    }
}
