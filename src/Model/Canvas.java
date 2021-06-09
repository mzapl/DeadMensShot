package Model;

public class Canvas {
    static double width;
    static double height;
    static Point startingPoint;

    //Canvas size is set based on polygon
    public static void setSize(Polygon polygon){
        setWidth(polygon.getWidth()*2);
        setHeight(polygon.getHeight()*2);
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
