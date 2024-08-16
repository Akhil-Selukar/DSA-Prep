package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testFirstMissingPositive_Test1(){
        int[] nums = {3,4,-1,1};

        assertEquals(2, Main.firstMissingPositive(nums));
    }


    @Test
    public void testFirstMissingPositive_Test2(){
        int[] nums = {3,4,-1,1,2};

        assertEquals(5, Main.firstMissingPositive(nums));
    }

    @Test
    public void testFirstMissingPositive_Test3(){
        int[] nums = {0,1,2,4,5,6};

        assertEquals(3, Main.firstMissingPositive(nums));
    }

    @Test
    public void testFirstMissingPositive_Test4(){
        int[] nums = {1,2,0};

        assertEquals(3, Main.firstMissingPositive(nums));
    }

    @Test
    public void testFirstMissingPositive_Test5(){
        int[] nums = {7,8,9,11,12};

        assertEquals(1, Main.firstMissingPositive(nums));
    }

    @Test
    public void testFirstMissingPositive_Test6(){
        int[] nums = {7,8,9,11,1,12};

        assertEquals(2, Main.firstMissingPositive(nums));
    }
}