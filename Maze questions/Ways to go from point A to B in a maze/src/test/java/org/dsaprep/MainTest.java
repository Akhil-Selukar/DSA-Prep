package org.dsaprep;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testTravelTheMaze_Test1(){
        int rows = 3;
        int columns = 3;

        assertEquals(6, Main.travelTheMaze(rows, columns));
    }

    @Test
    public void testTravelTheMaze_Test2(){
        int rows = 2;
        int columns = 2;

        assertEquals(2, Main.travelTheMaze(rows, columns));
    }

    @Test
    public void testTravelTheMaze_Test3(){
        int rows = 4;
        int columns = 4;

        assertEquals(20, Main.travelTheMaze(rows, columns));
    }

    @Test
    public void testTravelTheMaze_Test4(){
        int rows = 5;
        int columns = 2;

        assertEquals(5, Main.travelTheMaze(rows, columns));
    }

    @Test
    public void testTravelTheMaze_Test5(){
        int rows = 3;
        int columns = 4;

        assertEquals(10, Main.travelTheMaze(rows, columns));
    }
}