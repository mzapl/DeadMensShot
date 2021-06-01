import Model.Line;
import Model.Point;
import Model.Polygon;
import Model.Ray;
import Other.TestCases;
import Service.DrawService;
import Service.RayService;

import javax.swing.*;
import java.util.ArrayList;

public class DeadMensShot {
    public static void main(String []args) {

        TestCases.parsePoints(TestCases.getCase5());
        ArrayList<Point> points = TestCases.getPoints();
        ArrayList<Point> shots = TestCases.getShots();

        Polygon polygon = new Polygon(points);
        ArrayList<Line> lines = polygon.getLines();

        RayService rayService = new RayService(polygon);

        for(Point shot:shots){
            rayService.cast(shot);
        }

        //printing the hit or miss for each shot
        ArrayList<Ray> rays = rayService.getRays();
        for(Ray ray:rays){
            if(ray.getIntersections() % 2 == 1){
                System.out.println("hit");
            }else {
                System.out.println("miss");
            }
        }

//        System.out.println(polygon.getSize());
        myDrawer(rays, lines, points, shots);
    }

    public static void myDrawer(ArrayList<Ray> rays, ArrayList<Line> lines, ArrayList<Point> points, ArrayList<Point> shots){
        Runnable r = new Runnable() {
            public void run() {
                DrawService drawService = new DrawService(500,500);
                drawService.addRays(rays);
                drawService.addLines(lines);
                drawService.addPoints(points);
                drawService.addShots(shots);

                JOptionPane.showMessageDialog(null, drawService);
            }
        };

        SwingUtilities.invokeLater(r);
    }
}
