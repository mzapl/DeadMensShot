package Service;

import Model.Line;
import Model.Point;

public class Line2LineService {
    Line firstLine;
    Line anotherLine;
    double x, y;
    double d1, d2;

    boolean collinear, intersect, meet;
    Point intersectionPoint;

    public Line2LineService(Line firstLine, Line anotherLine) {
        this.firstLine = firstLine;
        this.anotherLine = anotherLine;

        this.collinear = collinear();
        this.meet = meet();

//        System.out.println("---for the sake of debugging---");
//        System.out.println(toString());
//        System.out.println("First line: " + firstLine);
//        System.out.println("Another line: " + anotherLine);
    }

    boolean collinear(){
        return ((firstLine.getA() * anotherLine.getB()) - (anotherLine.getA() * firstLine.getB()) == 0.0);
    }

    public boolean intersect(Line firstLine, Line anotherLine){
        if ((firstLine.getD1(anotherLine) > 0) && (firstLine.getD2(anotherLine) > 0)){
            return false;
        }

        if ((firstLine.getD1(anotherLine) < 0) && (firstLine.getD2(anotherLine) < 0)){
            return false;
        }

        return !collinear;
    }

    public boolean meet(){
        return intersect(firstLine, anotherLine) && intersect(anotherLine, firstLine);
    }

    public Line getFirstLine() {
        return firstLine;
    }

    public void setFirstLine(Line firstLine) {
        this.firstLine = firstLine;
        recalculate();
    }

    public Line getAnotherLine() {
        return anotherLine;
    }

    public void setAnotherLine(Line anotherLine) {
        this.anotherLine = anotherLine;
        recalculate();
    }

    public void recalculate(){
        this.intersect = intersect(firstLine, anotherLine) || intersect(anotherLine, firstLine);
        this.collinear = collinear();
        this.meet = meet();
    }

    @Override
    public String toString() {
        return "\n-------------- Line2LineService --------------\n" +
                "firstLine id " + firstLine.getId() +
                " anotherLine id " + anotherLine.getId() +
                ", meet? = " + meet +
//                ", \nx=" + x +
//                ", y=" + y +
//                ", d1=" + d1 +
//                ", d2=" + d2 +
                ", \ncollinear=" + collinear +
                ", intersection=" + intersect +
                ", intersectionPoint=" + intersectionPoint+
                "\n-------------------- end ------------------------- ";
    }
}
