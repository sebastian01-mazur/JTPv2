package LAB3.ZAD2;

import java.util.ArrayList;
import java.util.List;

public class Polygon implements Figure {
    private List<Point> points = new ArrayList<>();

    public Polygon(Point... pts) {
        for (Point p : pts) {
            this.points.add(p.clone());
        }
    }

    @Override
    public void move(double dx, double dy) {
        for (Point p : points) p.move(dx, dy);
    }

    @Override
    public void flip() {
        for (Point p : points) p.flip();
    }

    @Override
    public void rotate(double angle) {
        for (Point p : points) p.rotate(angle);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Polygon)) return false;
        Polygon polygon = (Polygon) o;
        return points.equals(polygon.points);
    }

    @Override
    public String toString() {
        return "Polygon" + points.toString();
    }

    @Override
    public Polygon clone() {
        try {
            Polygon cloned = (Polygon) super.clone();
            cloned.points = new ArrayList<>();
            for (Point p : this.points) {
                cloned.points.add(p.clone());
            }
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}