package Service;

import Model.Line;
import Model.Point;
import Model.Polygon;

public class PolygonService {
    private final Point outsidePoint = new Point(-1, -1);
    private Polygon polygon;
    private Line ray;

    public PolygonService(Polygon polygon) {
        this.polygon = polygon;
    }

    void setRay(Point point){
        this.ray = new Line(outsidePoint, point);
    }

    Integer getIntersections(){
        for (Line line:polygon.getLines()) {
            areIntersecting(line);
        }
        return 0;
    }

    String areIntersecting(Line side){
        return "nope";
    }


}
