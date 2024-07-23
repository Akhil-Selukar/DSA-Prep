package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testNumIdenticalPairs_Test1(){
        int[] nums = {1,2,3,1,1,3};
        assertEquals(4, Main.numIdenticalPairs(nums));
    }

    @Test
    public void testNumIdenticalPairs_NoGoodPairs(){
        int[] nums = {1,2,3,4,5};
        assertEquals(0, Main.numIdenticalPairs(nums));
    }

    @Test
    public void testNumIdenticalPairs_AllSameElements(){
        int[] nums = {1,1,1,1};
        assertEquals(6, Main.numIdenticalPairs(nums));
    }

    @Test
    public void testNumIdenticalPairs_EmptyArray(){
        int[] nums = {};
        assertEquals(0, Main.numIdenticalPairs(nums));
    }
}