package Model;

import Other.TestCases;
import Service.PointService;

import java.util.ArrayList;

public class Polygon {
    private int edgeCount;
    private ArrayList<Line> lines;
    private ArrayList<Point> points;

    public Polygon(ArrayList<Point> points, ArrayList<Line> lines) {
        this.lines = lines;
        this.points = points;
        this.edgeCount = lines.size();

        debug();
    }

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
        debug();
    }

    public ArrayList<Line> getLines() {
        return lines;
    }

    public ArrayList<Point> getPoints() {
        return points;
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
