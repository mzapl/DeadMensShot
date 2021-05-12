package Model;

import java.util.ArrayList;

public class Polygon {
    private ArrayList<Line> lines;
    private ArrayList<Point> points;

    public Polygon(ArrayList<Point> points, ArrayList<Line> lines) {
        this.lines = lines;
        this.points = points;
    }

    public Polygon(ArrayList<Point> points) {
        this.points = points;
    }

    public ArrayList<Line> getLines() {
        return lines;
    }

    public void setLines(ArrayList<Line> lines) {
        this.lines = lines;
    }
}
