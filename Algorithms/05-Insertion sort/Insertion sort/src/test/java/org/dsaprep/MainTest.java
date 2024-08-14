package org.dsaprep;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testInsertionSort_Test1(){
        int[] arr = {3,1,5,6,2,4};

        int[] ans = Main.insertionSort(arr);

        assertEquals(6, ans.length);
        assertEquals(1, ans[0]);
        assertEquals(2, ans[1]);
        assertEquals(3, ans[2]);
        assertEquals(4, ans[3]);
        assertEquals(5, ans[4]);
        assertEquals(6, ans[5]);
    }

    @Test
    public void testInsertionSort_Test2(){
        int[] arr = {};

        int[] ans = Main.insertionSort(arr);

        assertEquals(0, ans.length);
    }

    @Test
    public void testInsertionSort_Test3(){
        int[] arr = {3};

        int[] ans = Main.insertionSort(arr);

        assertEquals(1, ans.length);
        assertEquals(3, ans[0]);
    }

    @Test
    public void testInsertionSort_Test4(){
        int[] arr = {3,-1,5,-6,2,-4};

        int[] ans = Main.insertionSort(arr);

        assertEquals(6, ans.length);
        assertEquals(-6, ans[0]);
        assertEquals(-4, ans[1]);
        assertEquals(-1, ans[2]);
        assertEquals(2, ans[3]);
        assertEquals(3, ans[4]);
        assertEquals(5, ans[5]);
    }


    @Test
    public void testInsertionSort_Test5(){
        int[] arr = {3,1};

        int[] ans = Main.insertionSort(arr);

        assertEquals(2, ans.length);
        assertEquals(1, ans[0]);
        assertEquals(3, ans[1]);
    }

    @Test
    public void testInsertionSort_Test6(){
        int[] arr = {1,2,3,4,5,6};

        int[] ans = Main.insertionSort(arr);

        assertEquals(6, ans.length);
        assertEquals(1, ans[0]);
        assertEquals(2, ans[1]);
        assertEquals(3, ans[2]);
        assertEquals(4, ans[3]);
        assertEquals(5, ans[4]);
        assertEquals(6, ans[5]);
    }

    @Test
    public void testInsertionSort_Test7(){
        int[] arr = {6,5,4,3,2,1};

        int[] ans = Main.insertionSort(arr);

        assertEquals(6, ans.length);
        assertEquals(1, ans[0]);
        assertEquals(2, ans[1]);
        assertEquals(3, ans[2]);
        assertEquals(4, ans[3]);
        assertEquals(5, ans[4]);
        assertEquals(6, ans[5]);
    }

    @Test
    public void testInsertionSort_Test8(){
        int[] arr = {-3,-1,-5,-6,-2,-4};

        int[] ans = Main.insertionSort(arr);

        assertEquals(6, ans.length);
        assertEquals(-6, ans[0]);
        assertEquals(-5, ans[1]);
        assertEquals(-4, ans[2]);
        assertEquals(-3, ans[3]);
        assertEquals(-2, ans[4]);
        assertEquals(-1, ans[5]);
    }

}