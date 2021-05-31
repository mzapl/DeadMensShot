package Service;

import Model.Line;
import Model.Point;
import Model.Ray;

public class Line2LineService {
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
        System.out.println("---------Are the lines meeting??---------");
        System.out.print("line" + ray.getId()+" and line" + line.getId()+"          ");
        System.out.println(intersect(ray, line) && intersect(line, ray));
        System.out.println("specifically??            " + intersect(ray, line)+" and "+ intersect(line, ray));
        return (intersect(ray, line) && intersect(line, ray));
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
