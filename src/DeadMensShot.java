import Model.Line;
import Model.Point;
import Model.Polygon;
import Other.TestCases;
import Service.DrawService;
import Service.PointService;
import Service.RayService;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DeadMensShot {
    public static void main(String []args) {

        TestCases.parsePoints(TestCases.getCase1());
        ArrayList<Point> points = TestCases.getPoints();
        ArrayList<Point> shots = TestCases.getShots();

        Polygon polygon = new Polygon(points);
        ArrayList<Line> lines = polygon.getLines();

        RayService rayService = new RayService(polygon, new Point(300,300));
        ArrayList<Line> rays = RayService.getRays();
        RayService rayService2 = new RayService(polygon, new Point(100, 100));
        System.out.println("Have i collected any rays???" + rays.size());

        myDrawer(rays, lines, points, shots);
    }

    public static void myDrawer(ArrayList<Line> rays, ArrayList<Line> lines, ArrayList<Point> points, ArrayList<Point> shots){
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
