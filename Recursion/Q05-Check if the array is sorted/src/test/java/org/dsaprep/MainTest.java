package org.dsaprep;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class MainTest {

    @Test
    public void testIsSorted_Test1(){
        int[] arr = {1,2,6,9,12,13};

        assertTrue(Main.isSorted(arr));
    }

    @Test
    public void testIsSorted_Test2(){
        int[] arr = {1,2};

        assertTrue(Main.isSorted(arr));
    }

    @Test
    public void testIsSorted_Test3(){
        int[] arr = {1,1,2,2,6,6,9,9,12,12,13};

        assertTrue(Main.isSorted(arr));
    }

    @Test
    public void testIsSorted_Test4(){
        int[] arr = {1,1,1,1,1};

        assertTrue(Main.isSorted(arr));
    }

    @Test
    public void testIsSorted_Test5(){
        int[] arr = {1};

        assertTrue(Main.isSorted(arr));
    }

    @Test
    public void testIsSorted_Test6(){
        int[] arr = {1,2,6,5,9,12,13};

        assertFalse(Main.isSorted(arr));
    }

    @Test
    public void testIsSorted_Test7(){
        int[] arr = {2,1};

        assertFalse(Main.isSorted(arr));
    }

    @Test
    public void testIsSorted_Test8(){
        int[] arr = {1,2,6,5,9,12,1};

        assertFalse(Main.isSorted(arr));
    }
}