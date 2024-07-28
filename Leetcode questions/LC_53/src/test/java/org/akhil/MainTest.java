package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testMaxSubArray_Test1(){
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        assertEquals(6, Main.maxSubArray(nums));
    }

    @Test
    public void testMaxSubArray_Test2(){
        int[] nums = {1};

        assertEquals(1, Main.maxSubArray(nums));
    }

    @Test
    public void testMaxSubArray_Test3(){
        int[] nums = {-2};

        assertEquals(-2, Main.maxSubArray(nums));
    }

    @Test
    public void testMaxSubArray_Test4(){
        int[] nums = {5,4,-1,7,8};

        assertEquals(23, Main.maxSubArray(nums));
    }
}