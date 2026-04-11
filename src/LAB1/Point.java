package LAB1;

public class Point {
    private double x, y;
    public  double getX() {
        return x;
    }
    public double getY() {
        return y;
    }

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    void move(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    void flip() {
        this.x = -this.x;
        this.y = -this.y;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

