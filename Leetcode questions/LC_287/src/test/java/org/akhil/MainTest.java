package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testFindDuplicate_Test1(){
        int[] nums = {1,3,4,2,2};

        assertEquals(2, Main.findDuplicate(nums));
    }

    @Test
    public void testFindDuplicate_Test2(){
        int[] nums = {2,2};

        assertEquals(2, Main.findDuplicate(nums));
    }

    @Test
    public void testFindDuplicate_Test3(){
        int[] nums = {3,1,3,4,2};

        assertEquals(3, Main.findDuplicate(nums));
    }

    @Test
    public void testFindDuplicate_Test4(){
        int[] nums = {3,1,5,4,2};

        assertEquals(-1, Main.findDuplicate(nums));
    }

    @Test
    public void testFindDuplicate_Test5(){
        int[] nums = {3,3,3,3,3};

        assertEquals(3, Main.findDuplicate(nums));
    }
}