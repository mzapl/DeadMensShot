import Model.Line;
import Model.Point;

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
        det = (firstLine.getA() * anotherLine.getB()) - (anotherLine.getA() * firstLine.getB());

        areParallel = parallel();
        intersectionPoint = intersection();
    }

    boolean parallel(){
        return this.det == 0;
    }

    Point intersection(){
        x = ((anotherLine.getB()) - (firstLine.getB()) / det);
        y = ((firstLine.getA()) - (anotherLine.getA())) / det;
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
