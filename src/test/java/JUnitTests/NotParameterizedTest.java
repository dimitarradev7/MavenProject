package JUnitTests;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by dimitarrad
 * on 1/31/2021
 */
public class NotParameterizedTest {
    @Test
    public void calculateSum() {
        assertEquals("10 + 10 = 20",20, 10+10);
        assertEquals("10 + 20 = 30",30, 10+20);
        assertEquals("10 + 30 = 40",40, 10+30);
        assertEquals("10 + 40 = 50",50, 10+40);
    }
}
