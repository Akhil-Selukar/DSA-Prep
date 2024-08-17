package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testMajorityElement_Test1(){
        int[] nums = {2,2,1,1,1,2,2};

        assertEquals(2, Main.majorityElement(nums));
    }

    @Test
    public void testMajorityElement_Test2(){
        int[] nums = {1,5,6,3,5,4,5,5};

        assertEquals(5, Main.majorityElement(nums));
    }

    @Test
    public void testMajorityElement_Test3(){
        int[] nums = {3,2,3};

        assertEquals(3, Main.majorityElement(nums));
    }

    @Test
    public void testMajorityElement_Test4(){
        int[] nums = {1};

        assertEquals(1, Main.majorityElement(nums));
    }

    @Test
    public void testMajorityElement_Test(){
        int[] nums = {3,3,4};

        assertEquals(3, Main.majorityElement(nums));
    }

}