import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DeadMensShot {
    public static void main(String args[]) {

        //TARGET INPUT AND PROCESSING
        ArrayList<Point> points = new ArrayList<>();
        ArrayList<Line> lines = new ArrayList<>();

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        //Read point coords
        for (int i = 0; i < N; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            Point point = new Point(x, y);
            points.add(point);
        }

        //Join points into pairs, create lines
        for(Point point1:points){
            for(Point point2:points){
                if(point2.id == point1.id + 1){
                    Line line = new Line(point1, point2);
                    lines.add(line);
                }
            }
        }lines.add(new Line(points.get(0), points.get(points.size()-1)));

        Polygon polygon = new Polygon(lines);

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
                LineComponent lineComponent = new LineComponent(500,500);
                for(Line line:lines){
                    lineComponent.addLine(line);
                }

                for(Point point:points){
                    lineComponent.addPoint(point);
                }
                JOptionPane.showMessageDialog(null, lineComponent);
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
        double min = Integer.MAX_VALUE;;
        for (Point point: points){
            if(point.getX() < min){
                min = point.getX();
            }
        }
        return min;
    }

    static double minY(ArrayList<Point> points){
        double min = Integer.MAX_VALUE;;
        for (Point point: points){
            if(point.getX() < min){
                min = point.getY();
            }
        }
        return min;
    }

}
