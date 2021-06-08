package Other;

import Model.Point;
import Service.PointService;

import java.util.ArrayList;
import java.util.Scanner;

public class TestCases {
    ArrayList<Point> points = new ArrayList<>();
    ArrayList<Point> shots = new ArrayList<>();
    PointService pointService;

    public TestCases(){
        this.pointService = new PointService();
    }

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

    public ArrayList<Point> getPoints() {
        return this.points;
    }

    public ArrayList<Point> getShots() {
        return this.shots;
    }

    //Polygon points parsing
    public void parsePoints(String input){
        Scanner in = new Scanner(input);
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
        pointService.setPoints(points);


        //Returning back the scanner
        parseShots(in);
    }

    //Shots (points) parsing
    public void parseShots(Scanner in){
        Point point;
        int M = in.nextInt();
        for (int i = 0; i < M; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            point = new Point( x + pointService.getPositivePoint().getX(), y + pointService.getPositivePoint().getY());
            point.add(pointService.getStartingPoint());
            shots.add(point);
        }
    }
}
