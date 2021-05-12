package Service;

import Model.Line;
import Model.Point;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class LineService extends JComponent {


    ArrayList<Line2D.Double> lines;
    ArrayList<Point2D.Double> points;

    public LineService(int width, int height) {
        super();
        setPreferredSize(new Dimension(width,height));
        lines = new ArrayList<Line2D.Double>();
        points = new ArrayList<Point2D.Double>();
    }

    public void addLine(Line line) {
        int width = (int)getPreferredSize().getWidth();
        int height = (int)getPreferredSize().getHeight();
        Line2D.Double line2d = new Line2D.Double(line.getStartingPoint().getX(), line.getStartingPoint().getY(), line.getEndingPoint().getX(), line.getEndingPoint().getY());
        lines.add(line2d);
        repaint();
    }

    public void addPoint(Point point) {
        Point2D.Double point2D = new Point2D.Double(point.getX(), point.getY());
        points.add(point2D);
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());
        Dimension d = getPreferredSize();
        g.setColor(Color.black);
        for (Line2D.Double line : lines) {
            g.drawLine(
                    (int)line.getX1(),
                    (int)line.getY1(),
                    (int)line.getX2(),
                    (int)line.getY2()
            );
        }

        for (Point2D.Double point : points){
            g.drawOval((int)point.getX(), (int)point.getY(), 5, 5);
        }
    }
}
