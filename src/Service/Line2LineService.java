package Service;

import Model.Line;
import Model.Point;

public class Line2LineService {
    Line firstLine;
    Line anotherLine;
    double x, y;
    double d1, d2;

    boolean collinear, oneintersection, meet;
    Point intersectionPoint;

    public Line2LineService(Line firstLine, Line anotherLine) {
        this.firstLine = firstLine;
        this.anotherLine = anotherLine;

        this.collinear = collinear();
        this.meet = meet();
    }

    boolean collinear(){
        return ((firstLine.getA() * anotherLine.getB()) - (anotherLine.getA() * firstLine.getB()) == 0.0);
    }

    public boolean oneIntersectionPoint(Line firstLine, Line anotherLine){
        if ((firstLine.getD1(anotherLine) > 0) && (firstLine.getD2(anotherLine) > 0)){
            return false;
        }

        if ((firstLine.getD1(anotherLine) < 0) && (firstLine.getD2(anotherLine) < 0)){
            return false;
        }

        return !collinear;
    }

    public boolean meet(){
        return oneIntersectionPoint(firstLine, anotherLine) && oneIntersectionPoint(anotherLine, firstLine);
    }

    public Line getFirstLine() {
        return firstLine;
    }

    public void setFirstLine(Line firstLine) {
        this.firstLine = firstLine;
    }

    public Line getAnotherLine() {
        return anotherLine;
    }

    public void setAnotherLine(Line anotherLine) {
        this.anotherLine = anotherLine;
    }

    @Override
    public String toString() {
        return "Line2LineService : " +
                "firstLine id " + firstLine.getId() +
                " anotherLine id " + anotherLine.getId() +
                ", meet? = " + meet +
                ", \nx=" + x +
                ", y=" + y +
                ", d1=" + d1 +
                ", d2=" + d2 +
                ", collinear=" + collinear +
                ", oneintersection=" + oneintersection +
                ", intersectionPoint=" + intersectionPoint;
    }
}
