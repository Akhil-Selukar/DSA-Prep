package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testThirdMax_Test1(){
        int[] nums = {5, 3, 2, 1, 0, -3};

        assertEquals(2, Main.thirdMax(nums));
    }

    @Test
    public void testThirdMax_Test2(){
        int[] nums = {3, 2, 1, 0, -3};

        assertEquals(1, Main.thirdMax(nums));
    }

    @Test
    public void testThirdMax_Test3(){
        int[] nums = {2, 1, 1};

        assertEquals(2, Main.thirdMax(nums));
    }

    @Test
    public void testThirdMax_Test4(){
        int[] nums = {2, 2, 0, 1};

        assertEquals(0, Main.thirdMax(nums));
    }

    @Test
    public void testThirdMax_Test5(){
        int[] nums = {0};

        assertEquals(0, Main.thirdMax(nums));
    }

    @Test
    public void testThirdMax_Test6(){
        int[] nums = {-5,-2,-1,0, -3};

        assertEquals(-2, Main.thirdMax(nums));
    }
}
