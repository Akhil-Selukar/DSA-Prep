package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class MainTest {

    @Test
    public void testContainsDuplicate_Test1(){
        int[] nums = {1,2,3,1};

        assertTrue(Main.containsDuplicate(nums));
    }

    @Test
    public void testContainsDuplicate_Test2(){
        int[] nums = {1,2,3,4};

        assertFalse(Main.containsDuplicate(nums));
    }

    @Test
    public void testContainsDuplicate_Test3(){
        int[] nums = {1,1,1,3,3,4,3,2,4,2};

        assertTrue(Main.containsDuplicate(nums));
    }

    @Test
    public void testContainsDuplicate_Test4(){
        int[] nums = {1,1};

        assertTrue(Main.containsDuplicate(nums));
    }

    @Test
    public void testContainsDuplicate_Test5(){
        int[] nums = {1,2};

        assertFalse(Main.containsDuplicate(nums));
    }
}