import Model.Line;
import Model.Point;
import Model.Polygon;
import Other.TestCases;
import Service.Line2LineService;
import Service.PolygonService;
import Service.RayService;

public class LinesCheckup {
    public static void main(String[] args) {

////        //Two lines crossing at (-0.5, 0.5)
//        System.out.println("--------Lines crossing---------");
//        Line line1 = new Line(new Point(-2,0 ), new Point(4, 2));
//        Line line2 = new Line(new Point(-2, 2), new Point(2, -2));
//
//        Line2LineService lineService = new Line2LineService(line1, line2);
//        System.out.println(lineService);
////        //---------------------------------
//
//        //Two lines crossing, but they do not meet as vectors
//        System.out.println("--------Lines crossing, but vectors do not--------");
//        line1 = new Line(new Point(-5,-5 ), new Point(-4, -9));
//        line2 = new Line(new Point(-2, 2), new Point(2, -2));
//
//        lineService = new Line2LineService(line1, line2);
//        System.out.println(lineService);
//        //---------------------------------
//
//        //Two collinear lines
//        System.out.println("--------Lines collinear---------");
//        Line line3 = new Line(new Point(-1,0 ), new Point(1,0));
//        Line line4 = new Line(new Point(-2,0), new Point(-4, 0));
//
//        lineService = new Line2LineService(line3, line4);
//        System.out.println(lineService);
//        //---------------------------------


        System.out.println("-------------single ray check-------------");
        Point out = new Point(-1, -1);
        Point in = new Point(200, 200);
        Line ray = new Line(out, in);
        System.out.println(ray.getEquation());


        Point edgeOne = new Point(100, -100);
        Point edgeTwo = new Point(100, 100);
        Line line = new Line(edgeOne, edgeTwo);
        System.out.println(line.getEquation());

        Line2LineService lineService = new Line2LineService(ray, line);
        System.out.println(lineService);

        System.out.println("---=----------=-----");
        Polygon polygon = new Polygon(TestCases.getCase1());
        RayService rayService = new RayService(polygon, in);
        System.out.println(rayService.countIntersections());



    }
}
