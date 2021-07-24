package Service;

import Model.Line;
import Model.Point;
import Model.Polygon;
import Model.Ray;

import java.util.ArrayList;

public class RayService {
    Point outsidePoint = new Point(-100, -1);
    Point testedPoint;

    Ray ray;
    Polygon polygon;
    static ArrayList<Ray> rays = new ArrayList<Ray>();

    public RayService(Polygon polygon) {
        this.polygon = polygon;
    }

    public void countIntersections(Ray ray){
        Line2LineService line2LineService = new Line2LineService(ray);
        for(Line line: polygon.getLines()){
            line2LineService.setline(line);
            if(line2LineService.meet){
                ray.newIntersection();
            }
        }
    }

    public void cast(ArrayList<Point> testedPoints){
        for (Point testedPoint :
                testedPoints) {
            cast(testedPoint);
        }
    }

    public void cast(Point testedPoint) {
        this.testedPoint = testedPoint;
        castRay(testedPoint);
        countIntersections(ray);
        if(ray.getIntersections() % 2 == 1){
            testedPoint.setInside();
        }
        addRay(ray);
    }

    public void castRay(Point newPoint) {
        ray = new Ray(outsidePoint, newPoint);
    }

    private void addRay(Ray ray){
        rays.add(ray);
    }

    public Line getRay() {
        return ray;
    }

    public ArrayList<Ray> getRays() {
        return rays;
    }

    public static void staticString(){
        System.out.println(rays);
    }
}
