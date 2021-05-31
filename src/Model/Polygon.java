package Model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;

public class Polygon {
    private final int edgeCount;
    private final ArrayList<Line> lines;
    private final ArrayList<Point> points;
//    private final int width;
//    private final int height;

    public Polygon(ArrayList<Point> points) {
        ArrayList<Line> inputLines = new ArrayList<>();

        //Join points into pairs, create lines
        for(Point point1:points){
            for(Point point2:points){
                if(point2.getId() == point1.getId() + 1){
                    Line line = new Line(point1, point2);
                    inputLines.add(line);
                }
            }
        }inputLines.add(new Line(points.get(points.size()-1), points.get(0)));
        this.points = points;
        this.lines = inputLines;
        this.edgeCount = points.size();
//        debug();
    }

    public ArrayList<Line> getLines() {
        return lines;
    }

    public ArrayList<Point> getPoints() {
        return points;
    }

    public Double getSize(){
        double minx = points.stream().min(Comparator.comparingDouble(point -> point.getX())).get().getX();
        double maxx = points.stream().max(Comparator.comparingDouble(point -> point.getX())).get().getX();
        double miny = points.stream().min(Comparator.comparingDouble(point -> point.getY())).get().getY();
        double maxy = points.stream().max(Comparator.comparingDouble(point -> point.getY())).get().getY();
        System.out.println("The size would be:" + (maxx-minx) + " x " + (maxy-miny));
        return 1d;
    }

    public void debug() {
        System.out.println("-----debugging the polygon-----");
        System.out.println("lines:" + lines);
        System.out.println("points" + points);
    }

    @Override
    public String toString() {
        return "Polygon{" +
                "edgeCount=" + edgeCount +
                ", lines=" + lines +
                '}';
    }
}
