import Model.Line;
import Model.Point;
import Service.Line2LineService;

public class LinesCheckup {
    public static void main(String[] args) {
        Line line1 = new Line(new Point(-2,0 ), new Point(4, 2));
        Line line2 = new Line(new Point(-2, 2), new Point(2, -2));

        Line2LineService lineService = new Line2LineService(line1, line2);
        System.out.println(lineService);
    }
}
