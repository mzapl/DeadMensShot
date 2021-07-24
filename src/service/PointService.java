package Service;

import Model.Point;
import Model.Polygon;

import java.util.ArrayList;

public class PointService {
    //Moves the polygon and shots in a +x +y field of coordinates
    Point positivePoint = new Point(0, 0);

    //Sets the drawing point in a place, where polygon should be centered on canvas
    Point startingPoint = new Point(0, 0);

    Polygon polygon;
    ArrayList<Point> points;
    public PointService(){}

    public PointService(ArrayList<Point> points){
        this(new Polygon(points));
    }

    public PointService(Polygon polygon){
        this.polygon = polygon;
        this.points = polygon.getPoints();
        incrementBelowZeros();
        setStartingPoint();
    }

    public void incrementBelowZeros(){
        double minX = minX(points);
        double incrementX = 0;

        double minY = minY(points);
        double incrementY = 0;

        if(minX < 0){
            incrementX = -minX;
        }

        if(minY < 0){
            incrementY = -minY;
        }

        for(Point point: points){
            point.setX(point.getX() + incrementX);
            point.setY(point.getY() + incrementY);
        }

        positivePoint = new Point(incrementX, incrementY);
    }

    double minX(ArrayList<Point> points){
        double min = Integer.MAX_VALUE;
        for (Point point: points){
            if(point.getX() < min){
                min = point.getX();
            }
        }
        return min;
    }

    double minY(ArrayList<Point> points){
        double min = Integer.MAX_VALUE;
        for (Point point: points){
            if(point.getX() < min){
                min = point.getY();
            }
        }
        return min;
    }

    public Point getPositivePoint() {
        return positivePoint;
    }

    public Point getStartingPoint() {
        return startingPoint;
    }

    public void setStartingPoint() {
        this.startingPoint = new Point(polygon.getWidth()/2, polygon.getHeight()/2);
    }

    public Polygon getPolygon() {
        return polygon;
    }

    public void setPolygon(Polygon polygon) {
        this.polygon = polygon;
    }

    public ArrayList<Point> getPoints() {
        return points;
    }

    public void applyForEach(Point correctionPoint){
        for (Point point :
                points) {
            point.add(correctionPoint);
        }
    }

    public void setPoints(ArrayList<Point> points) {
        this.points = points;
        this.polygon = new Polygon(points);
        incrementBelowZeros();
        setStartingPoint();
        applyForEach(startingPoint);
        polygon.setPoints(points);
    }
}
