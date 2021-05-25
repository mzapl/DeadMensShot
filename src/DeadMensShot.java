import Model.Line;
import Model.Point;
import Model.Polygon;
import Other.TestCases;
import Service.DrawService;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DeadMensShot {
    public static void main(String []args) {

        //TARGET INPUT AND PROCESSING
        ArrayList<Point> points = new ArrayList<>();
        ArrayList<Line> lines = new ArrayList<>();

        Scanner in = new Scanner(TestCases.getCase1());
        //do not forget to skip the polygon part when placing shots, since it has been moved outside

        Polygon polygon = new Polygon(TestCases.getCase1());

        Point shotsCorrection = incrementBelowZeros(points);

        //SHOTS, INPUT AND PROCESSING
        ArrayList<Point> shots = new ArrayList<>();
        int M = in.nextInt();
        for (int i = 0; i < M; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            shots.add(new Point(x + shotsCorrection.getX(), y + shotsCorrection.getY()));
        }

        System.out.println("Shots: " + shots);
        myDrawer(lines, points, shots);
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

    static Point incrementBelowZeros(ArrayList<Point> points){
        double minX = minX(points);
        double incrementX = 0;

        double minY = minY(points);
        double incrementY = 0;

        if(minX < 0){
            incrementX = -minX;
        }

        if(minY < 0){
            incrementY = -minY;
        }

        for(Point point: points){
            point.setX(point.getX() + incrementX);
            point.setY(point.getY() + incrementY);
        }

        return new Point(incrementX, incrementY);
    }

    static double minX(ArrayList<Point> points){
        double min = Integer.MAX_VALUE;
        for (Point point: points){
            if(point.getX() < min){
                min = point.getX();
            }
        }
        return min;
    }

    static double minY(ArrayList<Point> points){
        double min = Integer.MAX_VALUE;
        for (Point point: points){
            if(point.getX() < min){
                min = point.getY();
            }
        }
        return min;
    }

}
