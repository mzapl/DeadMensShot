package Service;

import Model.Line;
import Model.Point;

public class RayService {
    Point outsidePoint = new Point(-1, -1);
    Point checkPoint;
    Line ray;

    public RayService(Point checkPoint) {
        this.checkPoint = checkPoint;
        this.ray = new Line(outsidePoint, checkPoint);
    }
}
