package LAB3.ZAD2;


public class Point implements Figure {
    private double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void move(double dx, double dy) {
        x += dx;
        y += dy;
    }

    @Override
    public void flip() {
        x = -x;
        y = -y;
    }

    @Override
    public void rotate(double angle) {
        double newX = x * Math.cos(angle) - y * Math.sin(angle);
        double newY = x * Math.sin(angle) + y * Math.cos(angle);
        this.x = newX;
        this.y = newY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        // Używamy tolerancji błędu dla zmiennoprzecinkowych (double)
        return Math.abs(point.x - x) < 1e-9 && Math.abs(point.y - y) < 1e-9;
    }

    @Override
    public String toString() {
        return String.format("Point(%.2f, %.2f)", x, y);
    }

    @Override
    public Point clone() {
        try {
            return (Point) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Klonowanie nie powiodło się");
        }
    }
}
