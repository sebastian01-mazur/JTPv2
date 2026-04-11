package LAB1;
public class Line {
    private Point p1, p2;


    Line(Point p1, Point p2) {
        this.p1 = new Point(p1.getX(), p1.getY() );
        this.p2 = new Point(p2.getX(), p2.getY() );
    }

    void move(double dx, double dy) {
        p1.move(dx, dy);
        p2.move(dx, dy);
    }

    void flip() {
        p1.flip();
        p2.flip();
    }

    public String toString() {
        return "Linia od " + p1 + " do " + p2;
    }
}
//public class Person {
//  private String name; // private = restricted access
//
//  // Getter
//  public String getName() {
//    return name;
//  }
//
//  // Setter
//  public void setName(String newName) {
//    this.name = newName;
//  }
//}

