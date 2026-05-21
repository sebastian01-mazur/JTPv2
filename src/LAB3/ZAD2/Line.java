package LAB3.ZAD2;

import java.util.Objects;

public class Line implements Figure {
    private Point p1, p2;

    public Line(Point p1, Point p2) {
        // Robimy głęboką kopię, aby modyfikacja zewnętrznego punktu nie psuła linii
        this.p1 = p1.clone();
        this.p2 = p2.clone();
    }

    @Override
    public void move(double dx, double dy) {
        p1.move(dx, dy);
        p2.move(dx, dy);
    }

    @Override
    public void flip() {
        p1.flip();
        p2.flip();
    }

    @Override
    public void rotate(double angle) {
        p1.rotate(angle);
        p2.rotate(angle);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Line)) return false;
        Line line = (Line) o;
        return Objects.equals(p1, line.p1) && Objects.equals(p2, line.p2);
    }

    @Override
    public String toString() {
        return "Line[" + p1 + ", " + p2 + "]";
    }

    @Override
    public Line clone() {
        try {
            Line cloned = (Line) super.clone();
            cloned.p1 = this.p1.clone();
            cloned.p2 = this.p2.clone();
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}