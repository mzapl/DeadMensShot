package Model;

import java.util.ArrayList;

public class Canvas {
    static double width;
    static double height;
    static Point startingPoint;
    static double scale = 1;

    public static void setScale(Polygon polygon){
        //we are aiming for 250-500px sized canvas
        System.out.println(polygon.getWidth() + " " + polygon.getHeight());
        if(polygon.getHeight() > 400 || polygon.getWidth() > 400){
            scale = 1 / (Double.max(polygon.getHeight(), polygon.getWidth()) / 400);
        }

        else if(polygon.getHeight() < 150 || polygon.getWidth() < 150){
            scale = 1 / (Double.min(polygon.getHeight(), polygon.getWidth()) / 150);
        }

//        System.out.println("Canvas scale set:"+scale);
        setWidth(polygon.getWidth()*2 * scale);
        setHeight(polygon.getHeight()*2 * scale);
    }

    public static void rescale(Polygon polygon){
        for (Point point : polygon.getPoints()) {
            rescale(point);
        }
    }

    public static void rescale(ArrayList<Point> points){
        for (Point point : points) {
            rescale(point);
        }
    }

    public static void rescale(Point point){
        point.setX(point.getX() * scale);
        point.setY(point.getY() * scale);
    }

    public static double getWidth() {
        return width;
    }

    public static void setWidth(double width) {
        Canvas.width = width;
    }

    public static double getHeight() {
        return height;
    }

    public static void setHeight(double height) {
        Canvas.height = height;
    }

    public static Point getStartingPoint() {
        return startingPoint;
    }

}
