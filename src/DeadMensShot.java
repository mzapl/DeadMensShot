import Model.*;
import Other.TestCases;
import Service.DrawService;
import Service.PointService;
import Service.RayService;

import javax.swing.*;
import java.util.ArrayList;

public class DeadMensShot {
    public static void main(String []args) {
        TestCases testCases = new TestCases();
        testCases.parsePoints(TestCases.getCase6());

        ArrayList<Point> points = testCases.getPoints();
        ArrayList<Point> shots = testCases.getShots();

        PointService pointService = new PointService(points);
        Polygon polygon = pointService.getPolygon();
        ArrayList<Line> lines = polygon.getLines();

        RayService rayService = new RayService(polygon);
        rayService.cast(shots);

        ArrayList<Ray> rays = rayService.getRays();

        Canvas.setScale(polygon);
        Canvas.rescale(shots);
        Canvas.rescale(polygon);
        myDrawer(rays, lines, points, shots);
    }

    public static void myDrawer(ArrayList<Ray> rays, ArrayList<Line> lines, ArrayList<Point> points, ArrayList<Point> shots){
        Runnable r = new Runnable() {
            public void run() {
                DrawService drawService = new DrawService((int) Canvas.getWidth(), (int) Canvas.getHeight());
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
