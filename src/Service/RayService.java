package Service;

import Model.Line;
import Model.Point;
import Model.Polygon;

public class RayService {
    Point outsidePoint = new Point(-100, 40);
    Point testedPoint;
    Line ray;
    Polygon polygon;
    int intersections = 0;

    public RayService(Polygon polygon, Point testedPoint) {
        this.testedPoint = testedPoint;
        this.ray = new Line(outsidePoint, testedPoint);
        this.polygon = polygon;
        this.intersections = countIntersections();
        toString();
    }

    public int countIntersections(){
        Line2LineService lineService = new Line2LineService(ray, ray);
        for (Line line : polygon.getLines()) {
            lineService.setAnotherLine(line);
            System.out.println(lineService);
            if(lineService.meet){
                System.out.println("HUGE SUCCESS!");
                intersections ++;
            }
        }
        return intersections;
    }

    public Line getRay() {
        return ray;
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
