package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testLargestAltitude_AllPositive(){
        int[] gain = {5,1,5,0,7};

        assertEquals(18, Main.largestAltitude(gain));
    }

    @Test
    public void testLargestAltitude_AllNegative(){
        int[] gain = {-1,-1,-5,-2,-7};

        assertEquals(0, Main.largestAltitude(gain));
    }

    @Test
    public void testLargestAltitude_FinalAltitudeNegative(){
        int[] gain = {-4,-3,-2,-1,4,3,2};

        assertEquals(0, Main.largestAltitude(gain));
    }

    @Test
    public void testLargestAltitude_AllZero(){
        int[] gain = {0,0,0,0,0,0};

        assertEquals(0, Main.largestAltitude(gain));
    }
}