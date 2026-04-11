package LAB2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

    public class SquareTest {

        @Test
        void testSquare0() {
            assertEquals(0, Square.square(0));
        }

        @Test
        void testSquare1() {
            assertEquals(1, Square.square(1));
        }

        @Test
        void testSquare2() {
            assertEquals(4, Square.square(2));
        }

        @Test
        void testSquare3() {
            assertEquals(9, Square.square(3));
        }
    }