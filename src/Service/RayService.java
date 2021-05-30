package Service;

import Model.Line;
import Model.Point;
import Model.Polygon;

import java.util.ArrayList;

public class RayService {
    Point outsidePoint = new Point(-100, 20);
    Point testedPoint;
    static ArrayList<Line> rays = new ArrayList<Line>();
    Line ray;
    Polygon polygon;
    int intersections = 0;

    public RayService(Polygon polygon, Point testedPoint) {
        this.testedPoint = testedPoint;
        this.ray = new Line(outsidePoint, testedPoint);
        this.polygon = polygon;
        this.intersections = countIntersections();
        addRay(ray);
        toString();
    }

    public int countIntersections(){
        Line2LineService lineService = new Line2LineService(ray, ray);
        for (Line line : polygon.getLines()) {
            lineService.setAnotherLine(line);
            System.out.println(lineService);
            if(lineService.meet){
                intersections ++;
            }
        }
        return intersections;
    }

    private void addRay(Line ray){
        rays.add(ray);
    }

    public Line getRay() {
        return ray;
    }

    public static ArrayList<Line> getRays() {
        return rays;
    }

    @Override
    public String toString() {
        return "RayService{" +
                "outsidePoint=" + outsidePoint +
                ", testedPoint=" + testedPoint +
                ", ray=" + ray +
                ", intersections=" + intersections +
                '}';
    }
}
