package Service;

import Model.Line;
import Model.Point;
import Model.Ray;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class DrawService extends JComponent {

    ArrayList<Line2D.Double> rays;
    ArrayList<Line2D.Double> lines;
    ArrayList<Point2D.Double> points;
    ArrayList<Point2D.Double> shotsIn;
    ArrayList<Point2D.Double> shotsOut;

    public DrawService(int width, int height) {
        super();
        setPreferredSize(new Dimension(width,height));
        rays = new ArrayList<Line2D.Double>();
        lines = new ArrayList<Line2D.Double>();
        points = new ArrayList<Point2D.Double>();
        shotsIn = new ArrayList<Point2D.Double>();
        shotsOut = new ArrayList<Point2D.Double>();
    }

    public void addRay(Line ray) {
        Line2D.Double line2d = new Line2D.Double(ray.getStartingPoint().getX(), ray.getStartingPoint().getY(), ray.getEndingPoint().getX(), ray.getEndingPoint().getY());
        rays.add(line2d);
        repaint();
    }

    public void addRays(ArrayList<Ray> rays){
        for(Ray ray:rays){
            addRay(ray);
        }
    }

    public void addLine(Line line) {
        int width = (int)getPreferredSize().getWidth();
        int height = (int)getPreferredSize().getHeight();
        Line2D.Double line2d = new Line2D.Double(line.getStartingPoint().getX(), line.getStartingPoint().getY(), line.getEndingPoint().getX(), line.getEndingPoint().getY());
        lines.add(line2d);
        repaint();
    }

    public void addLines(ArrayList<Line> lines){
        for(Line line:lines){
            addLine(line);
        }
    }

    public void addPoint(Point point) {
        Point2D.Double point2D = new Point2D.Double(point.getX(), point.getY());
        points.add(point2D);
        repaint();
    }

    public void addPoints(ArrayList<Point> points){
        for(Point point:points){
            addPoint(point);
        }
    }

    public void addShot(Point point) {
        Point2D.Double point2D = new Point2D.Double(point.getX(), point.getY());
        if(point.isInside()){
            shotsIn.add(point2D);
        }else {
            shotsOut.add(point2D);
        }
        repaint();
    }

    public void addShots(ArrayList<Point> shots){
        for(Point shot:shots){
            addShot(shot);
        }
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());
        Dimension d = getPreferredSize();
        g.setColor(Color.black);

        //Draw sides of given polygon
        for (Line2D.Double line : lines) {
            g.drawLine(
                    (int)line.getX1(),
                    (int)line.getY1(),
                    (int)line.getX2(),
                    (int)line.getY2()
            );
        }

        //Draw points (connecting edges of the polygon) UNUSED
//        for (Point2D.Double point : points){
//            g.drawOval((int)point.getX(), (int)point.getY(), 1, 1);
//        }

        //Draw all of the rays
        for (Line2D.Double ray : rays) {
            g.drawLine(
                    (int)ray.getX1(),
                    (int)ray.getY1(),
                    (int)ray.getX2(),
                    (int)ray.getY2()
            );
        }

        g.setColor(Color.green);
        for (Point2D.Double shot : shotsIn){
            g.fillOval((int)shot.getX(), (int)shot.getY(), 5, 5);
        }

        g.setColor(Color.red);
        for (Point2D.Double shot : shotsOut){
            g.drawOval((int)shot.getX(), (int)shot.getY(), 3, 3);
        }
    }
}
