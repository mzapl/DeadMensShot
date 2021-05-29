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

        //TARGET INPUT AND PROCESSING
        Scanner in = new Scanner(TestCases.getCase1());
        //do not forget to skip the polygon part when placing shots, since it has been moved outside

        Polygon polygon = new Polygon(TestCases.getCase1());
        ArrayList<Point> points = polygon.getPoints();
        ArrayList<Line> lines = polygon.getLines();
        RayService rayService = new RayService(polygon, new Point(250,250));
        System.out.println(rayService);

        //Repositioning whole polygon to the +x+y quarter in y-inverted cartesian plane.
        //Providing figurative point that will be used to correct the shots later
        Point correctionPoint = PointService.incrementBelowZeros(points);
        System.out.println(points);

        //SHOTS, INPUT AND PROCESSING
        ArrayList<Point> shots = new ArrayList<>();
        int M = in.nextInt();
        for (int i = 0; i < M; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            shots.add(new Point(x + correctionPoint.getX(), y + correctionPoint.getY()));
        }

//        System.out.println("Shots: " + shots);
//        myDrawer(lines, points, shots);
    }

    public static void myDrawer(ArrayList<Line> lines, ArrayList<Point> points, ArrayList<Point> shots){
        Runnable r = new Runnable() {
            public void run() {
                DrawService drawService = new DrawService(500,500);
                for(Line line:lines){
                    drawService.addLine(line);
                }

                for(Point point:points){
                    drawService.addPoint(point);
                }
                JOptionPane.showMessageDialog(null, drawService);
            }
        };

        SwingUtilities.invokeLater(r);
    }
}
