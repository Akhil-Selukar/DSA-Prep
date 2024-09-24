package org.akhil;

import org.junit.Test;
import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void testGicco_Test1(){
        String input = "1 3 2 4";

        assertEquals(6, Main.gicco(input));
    }

    @Test
    public void testGicco_Test2(){
        String input = "1 3 2 5";

        assertEquals(11, Main.gicco(input));
    }

    @Test
    public void testGicco_Test3(){
        String input = "1 3 2 6";

        assertEquals(19, Main.gicco(input));
    }

    @Test
    public void testGicco_Test4(){
        String input = "1 2 2 4";

        assertEquals(5, Main.gicco(input));
    }

    @Test
    public void testGicco_Test5(){
        String input = "1 1 1 8";

        assertEquals(31, Main.gicco(input));
    }
}