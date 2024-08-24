package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testLargestPerimeter_Test1(){
        int[] nums = {2,1,2};

        assertEquals(5, Main.largestPerimeter(nums));
    }

    @Test
    public void testLargestPerimeter_Test2(){
        int[] nums = {1,2,1,10};

        assertEquals(0, Main.largestPerimeter(nums));
    }

    @Test
    public void testLargestPerimeter_Test3(){
        int[] nums = {6,3,5,10};

        assertEquals(21, Main.largestPerimeter(nums));
    }
}