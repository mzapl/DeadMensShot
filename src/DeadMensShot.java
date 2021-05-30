import Model.Line;
import Model.Point;
import Model.Polygon;
import Model.Ray;
import Other.TestCases;
import Service.DrawService;
import Service.PointService;
import Service.RayService;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DeadMensShot {
    public static void main(String []args) {

        TestCases.parsePoints(TestCases.getCase01());
        ArrayList<Point> points = TestCases.getPoints();
        ArrayList<Point> shots = TestCases.getShots();

        Polygon polygon = new Polygon(points);
        ArrayList<Line> lines = polygon.getLines();

        RayService rayService = new RayService(polygon);

        for(Point shot:shots){
            rayService.cast(shot);
        }

        ArrayList<Ray> rays = RayService.getRays();
        for(Ray ray:rays){
            System.out.println(ray);
        }

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
