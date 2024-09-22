package org.dsaprep;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testBsort_Test1(){
        int[] arr = {5,4,8,2,1,9,16,12,10,52,23,24,20};

        Main.bSort(arr);
        assertEquals(1, arr[0]);
        assertEquals(2, arr[1]);
        assertEquals(4, arr[2]);
        assertEquals(5, arr[3]);
        assertEquals(8, arr[4]);
        assertEquals(9, arr[5]);
        assertEquals(10, arr[6]);
        assertEquals(12, arr[7]);
        assertEquals(16, arr[8]);
        assertEquals(20, arr[9]);
        assertEquals(23, arr[10]);
        assertEquals(24, arr[11]);
        assertEquals(52, arr[12]);
    }

    @Test
    public void testBsort_Test2(){
        int[] arr = {5,4,8,2,1};

        Main.bSort(arr);
        assertEquals(1, arr[0]);
        assertEquals(2, arr[1]);
        assertEquals(4, arr[2]);
        assertEquals(5, arr[3]);
        assertEquals(8, arr[4]);
    }

    @Test
    public void testBsort_Test3(){
        int[] arr = {1};

        Main.bSort(arr);
        assertEquals(1, arr[0]);
    }

    @Test
    public void testBsort_Test4(){
        int[] arr = {1,2};

        Main.bSort(arr);
        assertEquals(1, arr[0]);
        assertEquals(2, arr[1]);
    }

    @Test
    public void testBsort_Test5(){
        int[] arr = {1};

        Main.bSort(arr);
        assertEquals(1, arr[0]);
    }

    @Test
    public void testBsort_Test6(){
        int[] arr = {2,1};

        Main.bSort(arr);
        assertEquals(1, arr[0]);
        assertEquals(2, arr[1]);
    }

    @Test
    public void testBsort_Test7(){
        int[] arr = {1,-1};

        Main.bSort(arr);
        assertEquals(-1, arr[0]);
        assertEquals(1, arr[1]);
    }

    @Test
    public void testBsort_Test8(){
        int[] arr = {1,-2};

        Main.bSort(arr);
        assertEquals(-2, arr[0]);
        assertEquals(1, arr[1]);
    }
}