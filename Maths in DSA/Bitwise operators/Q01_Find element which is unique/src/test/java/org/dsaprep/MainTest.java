package org.dsaprep;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testFindUnique_Test1(){
        int[] nums = {1,1,2,2,3,4,4,5,5,6,6};

        assertEquals(3, Main.findUnique(nums));
    }

    @Test
    public void testFindUnique_Test2(){
        int[] nums = {1,1,2,2,3,3,4,4,5,5,6};

        assertEquals(6, Main.findUnique(nums));
    }

    @Test
    public void testFindUnique_Test3(){
        int[] nums = {1,2,2,3,3,4,4,5,5,6,6};

        assertEquals(1, Main.findUnique(nums));
    }
}