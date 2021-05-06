import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitTest {
    @Test
    void unit(){
        Unit u1 = new Unit(1002.0, 1000);
        System.out.println(u1.l.toString() + " " + u1.unit);
        assertEquals(1.002, u1.l);
        assertEquals("KB", u1.unit);

        Unit u2 = new Unit(1114112.0, 1024);
        System.out.println(u2.l.toString() + " " + u2.unit);
        assertEquals(1.0625, u2.l);
        assertEquals("MB", u2.unit);
    }
}