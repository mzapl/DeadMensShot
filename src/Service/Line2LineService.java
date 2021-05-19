package Service;

import Model.Line;
import Model.Point;

public class Line2LineService {
    Line firstLine;
    Line anotherLine;
    double det;
    double x, y;
    double d1, d2;

    boolean parallel, collinear, oneintersection;
    Point intersectionPoint;

    public Line2LineService(Line firstLine, Line anotherLine) {
        this.firstLine = firstLine;
        this.anotherLine = anotherLine;
        det = (firstLine.getA() * anotherLine.getB()) - (anotherLine.getA() * firstLine.getB());

        parallel = parallel();
        collinear = collinear();

        oneintersection = oneIntersectionPoint();
        if(oneintersection){
            intersectionPoint = intersection();
        }
    }

    boolean parallel(){
        return this.det == 0;
    }

    boolean collinear(){
        return ((firstLine.getA() * anotherLine.getB()) - (anotherLine.getA() * firstLine.getB()) == 0.0);
    }

    boolean oneIntersectionPoint(){
        if ((firstLine.getD1(anotherLine) > 0) && (firstLine.getD2(anotherLine) > 0)){
            return false;
        }

        if ((firstLine.getD1(anotherLine) < 0) && (firstLine.getD2(anotherLine) < 0)){
            return false;
        }

        return !collinear;
    }

    Point intersection(){
        x = ((anotherLine.getB()) - (firstLine.getB()) / det);
        y = ((firstLine.getA()) - (anotherLine.getA())) / det;
        return new Point(x, y);
    }

    @Override
    public String toString() {
        return "Line2LineService{" +
                "\nfirstLine=" + firstLine +
                ", \nanotherLine=" + anotherLine +
                ", \ndet=" + det +
                ", x=" + x +
                ", y=" + y +
                ", d1=" + d1 +
                ", d2=" + d2 +
                ", \nparallel=" + parallel +
                ", collinear=" + collinear +
                ", oneintersection=" + oneintersection +
                ", intersectionPoint=" + intersectionPoint +
                "\n}";
    }
}
