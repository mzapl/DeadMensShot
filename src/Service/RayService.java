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

    //Old countintersections function, i will attempt to implement new one
//    public void countIntersections(Ray ray){
//        Line2LineService lineService = new Line2LineService(ray, ray);
//        System.out.println("---------------------Rayservice: ------------------------");
//        for (Line line : polygon.getLines()) {
//            lineService.setAnotherLine(line);
//            if(lineService.meet){
//                lineService.info();
//                ray.newIntersection();
//            }
//        }
//    }

    public void countIntersections(Ray ray){
        Line2LineService line2LineService = new Line2LineService(ray);
        for(Line line: polygon.getLines()){
            line2LineService.setAnotherLine(line);
            if(line2LineService.meet){
                ray.newIntersection();
            }
        }
    }

    public void cast(Point testedPoint) {
        this.testedPoint = testedPoint;
        castRay(testedPoint);
        countIntersections(ray);
        System.out.println("siema tutaj ray, mam tyle intersekcji" + ray.getIntersections());
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

    public static ArrayList<Ray> getRays() {
        return rays;
    }

    public static void staticString(){
        System.out.println(rays);
    }
}
