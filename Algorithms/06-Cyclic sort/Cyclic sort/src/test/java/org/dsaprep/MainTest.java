package org.dsaprep;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testCyclicSort_Test1(){
        int[] arr = {3,1,5,6,2,4};

        Main.cyclicSort(arr);

        assertEquals(6, arr.length);
        assertEquals(1, arr[0]);
        assertEquals(2, arr[1]);
        assertEquals(3, arr[2]);
        assertEquals(4, arr[3]);
        assertEquals(5, arr[4]);
        assertEquals(6, arr[5]);
    }

    @Test
    public void testCyclicSort_Test2(){
        int[] arr = {};

        Main.cyclicSort(arr);

        assertEquals(0, arr.length);
    }

    @Test
    public void testCyclicSort_Test3(){
        int[] arr = {1};

        Main.cyclicSort(arr);

        assertEquals(1, arr.length);
        assertEquals(1, arr[0]);
    }

    @Test
    public void testCyclicSort_Test4(){
        int[] arr = {1,2,3,4,5,6};

        Main.cyclicSort(arr);

        assertEquals(6, arr.length);
        assertEquals(1, arr[0]);
        assertEquals(2, arr[1]);
        assertEquals(3, arr[2]);
        assertEquals(4, arr[3]);
        assertEquals(5, arr[4]);
        assertEquals(6, arr[5]);
    }


    @Test
    public void testCyclicSort_Test5(){
        int[] arr = {2,1};

        Main.cyclicSort(arr);

        assertEquals(2, arr.length);
        assertEquals(1, arr[0]);
        assertEquals(2, arr[1]);
    }

    @Test
    public void testCyclicSort_Test7(){
        int[] arr = {6,5,4,3,2,1};

        Main.cyclicSort(arr);

        assertEquals(6, arr.length);
        assertEquals(1, arr[0]);
        assertEquals(2, arr[1]);
        assertEquals(3, arr[2]);
        assertEquals(4, arr[3]);
        assertEquals(5, arr[4]);
        assertEquals(6, arr[5]);
    }

}