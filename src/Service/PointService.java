package Service;

import Model.Point;

import java.util.ArrayList;

public class PointService {
    static Point correctionPoint = new Point(0, 0);
    public PointService(){}

    public static Point incrementBelowZeros(ArrayList<Point> points){
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

        correctionPoint = new Point(incrementX, incrementY);

        return new Point(incrementX, incrementY);
    }

    static double minX(ArrayList<Point> points){
        double min = Integer.MAX_VALUE;
        for (Point point: points){
            if(point.getX() < min){
                min = point.getX();
            }
        }
        return min;
    }

    static double minY(ArrayList<Point> points){
        double min = Integer.MAX_VALUE;
        for (Point point: points){
            if(point.getX() < min){
                min = point.getY();
            }
        }
        return min;
    }

    public static Point getCorrectionPoint() {
        return correctionPoint;
    }

}
