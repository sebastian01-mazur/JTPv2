package LAB3.ZAD2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FigureTest {

    @Test
    public void testPointMoveAndFlip() {
        Point p = new Point(2, 3);
        p.move(1, -1);
        assertEquals(new Point(3, 2), p);

        p.flip();
        assertEquals(new Point(-3, -2), p);
    }

    @Test
    public void testPointRotate() {
        Point p = new Point(1, 0);
        p.rotate(Math.PI / 2); // obrót o 90 stopni w radianach
        assertEquals(new Point(0, 1), p);
    }

    @Test
    public void testLineCloneAndEquals() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(2, 2);
        Line l1 = new Line(p1, p2);

        Line l2 = l1.clone();
        assertEquals(l1, l2);
        assertNotSame(l1, l2); // Referencje muszą być inne (głęboka kopia)

        l2.move(1, 1);
        assertNotEquals(l1, l2); // l1 nie powinno się zmienić po przesunięciu l2
    }

    @Test
    public void testPolygon() {
        Polygon poly = new Polygon(new Point(0,0), new Point(1,1), new Point(1,0));
        poly.flip();
        Polygon expected = new Polygon(new Point(0,0), new Point(-1,-1), new Point(-1,0));
        assertEquals(expected, poly);

        assertNotNull(poly.toString());
    }

    @Test
    public void testGroupComposite() {
        Point p1 = new Point(1, 1);
        Line l1 = new Line(new Point(0,0), new Point(2,2));

        Group g = new Group();
        g.addFigure(p1.clone());
        g.addFigure(l1.clone());

        g.move(1, 1);

        // P1 zostało sklonowane do grupy, więc oryginalne P1 nie powinno zmienić współrzędnych
        assertEquals(new Point(1, 1), p1);
    }

    @Test
    public void testInterfaceGroupMethod() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(2, 2);
        Line l1 = new Line(p1, p2);

        Group myGroup = p1.group(p2, l1);

        assertNotNull(myGroup);
        myGroup.move(1, 1);

        // Ponieważ metoda group() klonuje obiekty, oryginał p1 się nie zmieni
        assertEquals(new Point(1, 1), p1);
    }
    @Test
    public void testEqualsAllBranches() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(1, 1);
        Point p3 = new Point(2, 2);

        // Ten sam obiekt (this == o)
        assertTrue(p1.equals(p1));
        // Ten sam stan, inny obiekt
        assertTrue(p1.equals(p2));
        // Inny stan
        assertFalse(p1.equals(p3));
        // Obiekt innej klasy i null (!(o instanceof...))
        assertFalse(p1.equals("String"));
        assertFalse(p1.equals(null));

        // To samo dla linii
        Line l1 = new Line(new Point(0,0), new Point(1,1));
        Line l2 = new Line(new Point(0,0), new Point(1,1));
        assertTrue(l1.equals(l2));
        assertFalse(l1.equals(null));
        assertFalse(l1.equals(p1));
    }

    @Test
    public void testToStringMethods() {
        Point p = new Point(1.5, -2.0);
        assertNotNull(p.toString());
        assertTrue(p.toString().contains("Point"));

        Line l = new Line(new Point(0,0), new Point(1,1));
        assertNotNull(l.toString());
        assertTrue(l.toString().contains("Line"));

        Polygon poly = new Polygon(new Point(0,0), new Point(1,1), new Point(2,0));
        assertNotNull(poly.toString());
        assertTrue(poly.toString().contains("Polygon"));

        Group g = new Group();
        g.addFigure(p);
        assertNotNull(g.toString());
        assertTrue(g.toString().contains("Group"));
    }

    @Test
    public void testGroupMethodsFully() {
        Group g = new Group();
        Point p = new Point(1, 1);
        g.addFigure(p);

        g.move(1, 1);
        assertEquals(new Point(2, 2), p);

        g.flip();
        assertEquals(new Point(-2, -2), p);

        g.rotate(Math.PI);
        // Po prostu sprawdzamy czy przechodzi bez rzucania wyjątków i uruchamia pętle
        assertNotNull(g);

        Group g2 = g.clone();
        assertTrue(g.equals(g2));
        assertFalse(g.equals(null));
    }
}