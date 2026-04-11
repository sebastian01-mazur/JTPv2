package LAB1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LineTest {

    @Test
    public void testConstructorDefensiveCopy() {
        Point p1 = new Point(0.0, 0.0);
        Point p2 = new Point(1.0, 1.0);
        Line line = new Line(p1, p2);

        // Symulujemy zmianę oryginalnych punktów PO stworzeniu linii
        p1.move(5.0, 5.0);

        // Jeśli konstruktor użył `new Point(...)`, linia nie powinna się zmienić
        assertEquals("Linia od (0.0, 0.0) do (1.0, 1.0)", line.toString(),
                "Linia powinna korzystać z niezależnych kopii punktów ");
    }

    @Test
    public void testMoveLine() {
        Point p1 = new Point(1.0, 1.0);
        Point p2 = new Point(2.0, 2.0);
        Line line = new Line(p1, p2);

        // Przesuwamy całą linię (oba punkty)
        line.move(2.0, -1.0);

        assertEquals("Linia od (3.0, 0.0) do (4.0, 1.0)", line.toString(),
                "Oba punkty linii powinny zostać poprawnie przesunięte");
    }

    @Test
    public void testFlipLine() {
        Point p1 = new Point(1.0, 2.0);
        Point p2 = new Point(-3.0, 4.0);
        Line line = new Line(p1, p2);

        // Odwracamy całą linię (oba punkty)
        line.flip();

        assertEquals("Linia od (-1.0, -2.0) do (3.0, -4.0)", line.toString(),
                "Współrzędne obu punktów linii powinny zostać odwrócone");
    }
}