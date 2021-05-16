package Service;

import Model.Line;
import Model.Point;

public class Line2LineService {
    Line firstLine;
    Line anotherLine;
    double det;
    double x, y;

//    d1 = (a1 * v2x1) + (b1 * v2y1) + c1;
//    d2 = (a1 * v2x2) + (b1 * v2y2) + c1;
    double d1, d2;

    boolean areParallel;
    Point intersectionPoint;

    public Line2LineService(Line firstLine, Line anotherLine) {
        this.firstLine = firstLine;
        this.anotherLine = anotherLine;
        det = (firstLine.getA() * anotherLine.getB()) - (anotherLine.getA() * firstLine.getB());

        areParallel = parallel();
        intersectionPoint = intersection();
        d1 = getD1();
        d2 = getD2();
    }

    boolean parallel(){
        return this.det == 0;
    }

    Point intersection(){
        x = ((anotherLine.getB()) - (firstLine.getB()) / det);
        y = ((firstLine.getA()) - (anotherLine.getA())) / det;
        return new Point(x, y);
    }

    double getD1(){
//        (a1 * v2x1) + (b1 * v2y1) + c1;
        return (firstLine.getA() * anotherLine.getStartingPoint().getX()) + (firstLine.getB() * anotherLine.getStartingPoint().getY()) + firstLine.getC();
    }

    double getD2(){
//        (d2 = (a1 * v2x2) + (b1 * v2y2) + c1;
        return (firstLine.getA() * anotherLine.getEndingPoint().getX()) + (firstLine.getB() * anotherLine.getEndingPoint().getY()) + firstLine.getC();
    }

    @Override
    public String toString() {
        return "Line2LineService{" +
                "det=" + det +
                ", x=" + x +
                ", y=" + y +
                ", d1=" + d1 +
                ", d2=" + d2 +
                ", areParallel=" + areParallel +
                ", intersectionPoint=" + intersectionPoint +
                '}';
    }
}
