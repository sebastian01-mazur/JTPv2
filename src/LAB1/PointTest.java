package LAB1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PointTest {

    @Test
    public void testConstructorAndGetters() {
        Point p = new Point(2.5, 3.5);
        assertEquals(2.5, p.getX(), "Współrzędna X powinna wynosić 2.5");
        assertEquals(3.5, p.getY(), "Współrzędna Y powinna wynosić 3.5");
    }

    @Test
    public void testMove() {
        Point p = new Point(1.0, 1.0);
        p.move(2.0, -3.0);

        // 1.0 + 2.0 = 3.0
        assertEquals(3.0, p.getX(), "Po przesunięciu X powinno wynosić 3.0");
        // 1.0 + (-3.0) = -2.0
        assertEquals(-2.0, p.getY(), "Po przesunięciu Y powinno wynosić -2.0");
    }

    @Test
    public void testFlip() {
        Point p = new Point(4.0, -5.0);
        p.flip();

        assertEquals(-4.0, p.getX(), "Po obróceniu X powinno wynosić -4.0");
        assertEquals(5.0, p.getY(), "Po obróceniu Y powinno wynosić 5.0");
    }


}