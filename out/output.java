//Version Wed Jun 02 21:23:06 CEST 2021
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import javax.swing.*;



class TestCases {
    static ArrayList<Point> points = new ArrayList<>();
    static ArrayList<Point> shots = new ArrayList<>();

    private static final String case0 = "2\n" +
            "100 100\n" +
            "100 -100\n" +
            "3\n" +
            "200 200\n" +
            "50 50\n" +
            "200 50";


    private static final String case01 = "4\n" +
            "-100 -100\n" +
            "100 -100\n" +
            "100 100\n" +
            "-100 100\n" +
            "1\n" +
            "50 50\n";

    private static final String case1 = "4\n" +
            "-100 -100\n" +
            "100 -100\n" +
            "100 100\n" +
            "-100 100\n" +
            "5\n" +
            "0 0\n" +
            "99 99\n" +
            "101 101\n" +
            "80 -101\n" +
            "0 -100";


    private static final String case2 = "3\n" +
            "0 0\n" +
            "400 0\n" +
            "200 200\n" +
            "5\n" +
            "200 100\n" +
            "-34 23\n" +
            "75 5\n" +
            "175 174\n" +
            "175 176";

    private static final String case3 = "5\n" +
            "0 0\n" +
            "100 0\n" +
            "150 50\n" +
            "100 100\n" +
            "0 100\n" +
            "5\n" +
            "100 50\n" +
            "20 80\n" +
            "150 0\n" +
            "99 99\n" +
            "125 76";

    private static final String case4 = "6\n" +
            "0 0\n" +
            "100 -1000\n" +
            "500 0\n" +
            "500 100\n" +
            "400 1000\n" +
            "0 100\n" +
            "5\n" +
            "300 100\n" +
            "5 -666\n" +
            "100 -666\n" +
            "250 250\n" +
            "400 -400";

    private static final String case5 = "10\n" +
            "0 0\n" +
            "100 0\n" +
            "150 25\n" +
            "200 75\n" +
            "150 100\n" +
            "100 125\n" +
            "50 125\n" +
            "-50 100\n" +
            "-60 50\n" +
            "-50 25\n" +
            "6\n" +
            "50 80\n" +
            "100 100\n" +
            "-100 80\n" +
            "0 120\n" +
            "200 100\n" +
            "175 60";

    public static String getCase0() {
        return case0;
    }

    public static String getCase01() {
        return case01;
    }

    public static String getCase1() {
        return case1;
    }

    public static String getCase2() {
        return case2;
    }

    public static String getCase3() {
        return case3;
    }

    public static String getCase4() {
        return case4;
    }

    public static String getCase5() {
        return case5;
    }

    public static ArrayList<Point> getPoints() {
        return points;
    }

    public static ArrayList<Point> getShots() {
        return shots;
    }

    //Polygon points parsing
    public static void parsePoints(Scanner in){
        int N = in.nextInt();

        //Read point coords
        for (int i = 0; i < N; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            Point point = new Point(x, y);
            points.add(point);
        }

        //Repositioning whole polygon to the +x+y quarter in y-inverted cartesian plane.
        //Providing figurative point that will be used to correct the shots later
        PointService.incrementBelowZeros(points);

        //Returning back the scanner
        parseShots(in);
    }

    //Shots (points) parsing
    public static void parseShots(Scanner in){
        int M = in.nextInt();
        for (int i = 0; i < M; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            shots.add(new Point(
                    x + PointService.getCorrectionPoint().getX(),
                    y + PointService.getCorrectionPoint().getY()));
        }
    }
}



class DrawService extends JComponent {

    ArrayList<Line2D.Double> rays;
    ArrayList<Line2D.Double> lines;
    ArrayList<Point2D.Double> points;
    ArrayList<Point2D.Double> shots;

    public DrawService(int width, int height) {
        super();
        setPreferredSize(new Dimension(width,height));
        rays = new ArrayList<Line2D.Double>();
        lines = new ArrayList<Line2D.Double>();
        points = new ArrayList<Point2D.Double>();
        shots = new ArrayList<Point2D.Double>();
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
        shots.add(point2D);
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

        //Draw points (connecting edges of the polygon) for further removal
        for (Point2D.Double point : points){
            g.drawOval((int)point.getX(), (int)point.getY(), 1, 1);
        }

        //Draw all of the rays
        for (Line2D.Double ray : rays) {
            g.drawLine(
                    (int)ray.getX1(),
                    (int)ray.getY1(),
                    (int)ray.getX2(),
                    (int)ray.getY2()
            );
        }

        g.setColor(Color.red);
        for (Point2D.Double shot : shots){
            g.drawOval((int)shot.getX(), (int)shot.getY(), 5, 5);
        }
    }
}


class PolygonService {
    private Polygon polygon;

    public PolygonService(Polygon polygon) {
        this.polygon = polygon;
    }
}


class Polygon {
    private final int edgeCount;
    private final ArrayList<Line> lines;
    private final ArrayList<Point> points;
    private double height = 0;
    private double width = 0;

    public Polygon(ArrayList<Point> points) {
        ArrayList<Line> inputLines = new ArrayList<>();

        //Join points into pairs, create lines
        for(Point point1:points){
            for(Point point2:points){
                if(point2.getId() == point1.getId() + 1){
                    Line line = new Line(point1, point2);
                    inputLines.add(line);
                }
            }
        }inputLines.add(new Line(points.get(points.size()-1), points.get(0)));
        this.points = points;
        this.lines = inputLines;
        this.edgeCount = points.size();
    }

    public ArrayList<Line> getLines() {
        return lines;
    }

    public ArrayList<Point> getPoints() {
        return points;
    }

    public void getSize(){
        double minx = points.stream().min(Comparator.comparingDouble(point -> point.getX())).get().getX();
        double maxx = points.stream().max(Comparator.comparingDouble(point -> point.getX())).get().getX();
        double miny = points.stream().min(Comparator.comparingDouble(point -> point.getY())).get().getY();
        double maxy = points.stream().max(Comparator.comparingDouble(point -> point.getY())).get().getY();
        System.out.println("The size would be:" + (maxx-minx) + " x " + (maxy-miny));
        width = (maxx - minx);
        height = (maxy - miny);
    }

    @Override
    public String toString() {
        return "Polygon{" +
                "edgeCount=" + edgeCount +
                ", lines=" + lines +
                '}';
    }
}

class Ray extends Line{
    private int intersections;

    public Ray(Point startingPoint, Point endingPoint) {
        super(startingPoint, endingPoint);
        intersections = 0;
    }

    public int getIntersections() {
        return intersections;
    }

    public void setIntersections(int intersections) {
        this.intersections = intersections;
    }

    public void newIntersection(){
        intersections ++;
    }

    @Override
    public String toString() {
        return "Ray{" +
                "id=" + id +
                ", startingPoint=" + startingPoint +
                ", endingPoint=" + endingPoint +
                ", intersections=" + intersections +
                '}';
    }
}



class PointService {
    static Point correctionPoint = new Point(0, 0);
    public PointService(){}

    public static void incrementBelowZeros(ArrayList<Point> points){
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

        correctionPoint = new Point(incrementX, incrementY);
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

    public static Point getCorrectionPoint() {
        return correctionPoint;
    }

}

class Line {
    static int startingId = 0;
    int id;
    Point startingPoint;
    Point endingPoint;

    //equation standard form: A*x + B*y + C = 0
    double a;
    double b;
    double c;

    String equation;

    public Line(Point startingPoint, Point endingPoint) {
        this.id = startingId;
        startingId++;
        this.startingPoint = startingPoint;
        this.endingPoint = endingPoint;
        this.a = endingPoint.getY() - startingPoint.getY();
        this.b = startingPoint.getX() - endingPoint.getX();
        this.c = (endingPoint.getX() * startingPoint.getY()) - (startingPoint.getX() * endingPoint.getY());
        this.equation = a +"x +" + b +"y +" + c +" = 0";
    }

    public int getId() {
        return id;
    }

    public Point getStartingPoint() {
        return startingPoint;
    }

    public Point getEndingPoint() {
        return endingPoint;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getD1(Line anotherLine) {
        double D1 = (a * anotherLine.getStartingPoint().getX()) + (b * anotherLine.getStartingPoint().getY()) + c;
        return D1;
    }

    public double getD2(Line anotherLine) {
        double D2 = (a * anotherLine.getEndingPoint().getX()) + (b * anotherLine.getEndingPoint().getY()) + c;
        return D2;
    }

    public String getEquation() {
        return equation;
    }

    @Override
    public String toString() {
        return "Line"+ id + "{" +
                "startingPoint=" + startingPoint +
                ", endingPoint=" + endingPoint +
                ", equation: " + a +"x +" + b +"y +" + c +" = 0"+
                '}';
    }
}


class DeadMensShot {
    public static void main(String []args) {
        Scanner input = new Scanner(System.in);
        TestCases.parsePoints(input);
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


class Line2LineService {
    Ray ray;
    Line line;

    boolean collinear, intersect, meet;
    Point intersectionPoint;

    public Line2LineService(Ray ray){
        this.ray = ray;
    }

    boolean collinear(){
        return ((ray.getA() * line.getB()) - (line.getA() * ray.getB()) == 0.0);
    }

    public boolean intersect(Line ray, Line line){
        if ((ray.getD1(line) > 0) && (ray.getD2(line) > 0)){
            return false;
        }

        if ((ray.getD1(line) < 0) && (ray.getD2(line) < 0)){
            return false;
        }

        return !collinear;
    }

    public boolean meet(){
        return (intersect(ray, line) && intersect(line, ray));
    }

    public void meetPrints(){
        System.out.println("---------Are the lines meeting??---------");
        System.out.print("line" + ray.getId()+" and line" + line.getId()+"          ");
        System.out.println(intersect(ray, line) && intersect(line, ray));
        System.out.println("specifically??            " + intersect(ray, line)+" and "+ intersect(line, ray));
    }

    public Line getray() {
        return ray;
    }

    public void setray(Ray ray) {
        this.ray = ray;
        recalculate();
    }

    public Line getline() {
        return line;
    }

    public void setline(Line line) {
        this.line = line;
        recalculate();
    }

    public void recalculate(){
        this.intersect = intersect(ray, line) || intersect(line, ray);
        this.collinear = collinear();
        this.meet = meet();
    }

    public void info(){
        System.out.println(ray.getId());
        System.out.println(line.getId());
    }

    @Override
    public String toString() {
        return "\n-- Line2LineService --\n" +
                "ray id " + ray.getId() +
                " line id " + line.getId() +
                ", meet? = " + meet +
                ", \ncollinear=" + collinear +
                ", intersection=" + intersect +
                ", intersectionPoint=" + intersectionPoint+
                "\n-- end -- ";
    }
}



class RayService {
    Point outsidePoint = new Point(-100, -1);
    Point testedPoint;

    Ray ray;
    Polygon polygon;
    static ArrayList<Ray> rays = new ArrayList<Ray>();

    public RayService(Polygon polygon) {
        this.polygon = polygon;
    }

    public void countIntersections(Ray ray){
        Line2LineService line2LineService = new Line2LineService(ray);
        for(Line line: polygon.getLines()){
            line2LineService.setline(line);
            if(line2LineService.meet){
                ray.newIntersection();
            }
        }
    }

    public void cast(Point testedPoint) {
        this.testedPoint = testedPoint;
        castRay(testedPoint);
        countIntersections(ray);
        addRay(ray);
    }

    public void castRay(Point newPoint) {
        ray = new Ray(outsidePoint, newPoint);
    }

    private void addRay(Ray ray){
        rays.add(ray);
    }

    public Line getRay() {
        return ray;
    }

    public ArrayList<Ray> getRays() {
        return rays;
    }

    public static void staticString(){
        System.out.println(rays);
    }
}
class LinesCheckup {
    public static void main(String[] args) {

    }
}

class Point {
    static int startingId = 0;
    private int id;
    private double x;
    private double y;
    boolean inside;

    public Point(double x, double y) {
        this.id = startingId;
        startingId++;
        this.x = x;
        this.y = y;
    }

    public int getId() {
        return id;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public boolean isInside() {
        return inside;
    }

    public void setInside(boolean inside) {
        this.inside = inside;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public String toString() {
        return "Model.Point "+ id +"{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
