package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testSplitArray_Test1(){
        int[] arr = {3,2,5,8,1,6};
        int k = 2;

        assertEquals(15, Main.splitArray(arr, k));
    }

    @Test
    public void testSplitArray_Test2(){
        int[] arr = {7,2,5,10,8};
        int k = 2;

        assertEquals(18, Main.splitArray(arr, k));
    }

    @Test
    public void testSplitArray_Test3(){
        int[] arr = {1,2,3,4,5};
        int k = 2;

        assertEquals(9, Main.splitArray(arr, k));
    }

    @Test
    public void testSplitArray_Test4(){
        int[] arr = {1,2,3,4,5};
        int k = 1;

        assertEquals(15, Main.splitArray(arr, k));
    }

    @Test
    public void testSplitArray_Test5(){
        int[] arr = {1,2,3,4,5};
        int k = 5;

        assertEquals(5, Main.splitArray(arr, k));
    }

    @Test
    public void testSplitArray_Test6(){
        int[] arr = {1,2,3,4,5};
        int k = 3;

        assertEquals(6, Main.splitArray(arr, k));
    }
}