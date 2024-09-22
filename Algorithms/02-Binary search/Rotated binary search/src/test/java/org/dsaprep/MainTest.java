package org.dsaprep;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testRbSearch_Test1(){
        int[] arr = {5, 6, 8, 9, 12, 13, 15, 1, 2, 3};
        int target = 5;

        assertEquals(0, Main.rbSearch(arr, target, 0, arr.length-1));
    }

    @Test
    public void testRbSearch_Test2(){
        int[] arr = {5, 6, 8, 9, 12, 13, 15, 1, 2, 3};
        int target = 6;

        assertEquals(1, Main.rbSearch(arr, target, 0, arr.length-1));
    }

    @Test
    public void testRbSearch_Test3(){
        int[] arr = {5, 6, 8, 9, 12, 13, 15, 1, 2, 3};
        int target = 8;

        assertEquals(2, Main.rbSearch(arr, target, 0, arr.length-1));
    }

    @Test
    public void testRbSearch_Test4(){
        int[] arr = {5, 6, 8, 9, 12, 13, 15, 1, 2, 3};
        int target = 9;

        assertEquals(3, Main.rbSearch(arr, target, 0, arr.length-1));
    }

    @Test
    public void testRbSearch_Test5(){
        int[] arr = {5, 6, 8, 9, 12, 13, 15, 1, 2, 3};
        int target = 12;

        assertEquals(4, Main.rbSearch(arr, target, 0, arr.length-1));
    }

    @Test
    public void testRbSearch_Test6(){
        int[] arr = {5, 6, 8, 9, 12, 13, 15, 1, 2, 3};
        int target = 13;

        assertEquals(5, Main.rbSearch(arr, target, 0, arr.length-1));
    }

    @Test
    public void testRbSearch_Test7(){
        int[] arr = {5, 6, 8, 9, 12, 13, 15, 1, 2, 3};
        int target = 15;

        assertEquals(6, Main.rbSearch(arr, target, 0, arr.length-1));
    }

    @Test
    public void testRbSearch_Test8(){
        int[] arr = {5, 6, 8, 9, 12, 13, 15, 1, 2, 3};
        int target = 1;

        assertEquals(7, Main.rbSearch(arr, target, 0, arr.length-1));
    }

    @Test
    public void testRbSearch_Test9(){
        int[] arr = {5, 6, 8, 9, 12, 13, 15, 1, 2, 3};
        int target = 2;

        assertEquals(8, Main.rbSearch(arr, target, 0, arr.length-1));
    }

    @Test
    public void testRbSearch_Test10(){
        int[] arr = {5, 6, 8, 9, 12, 13, 15, 1, 2, 3};
        int target = 3;

        assertEquals(9, Main.rbSearch(arr, target, 0, arr.length-1));
    }

    @Test
    public void testRbSearch_Test11(){
        int[] arr = {5, 6, 8, 9, 12, 13, 15, 1, 2, 3};
        int target = 4;

        assertEquals(-1, Main.rbSearch(arr, target, 0, arr.length-1));
    }

    @Test
    public void testRbSearch_Test12(){
        int[] arr = {5, 6, 8, 9, 12, 13, 15, 1, 2, 3};
        int target = 7;

        assertEquals(-1, Main.rbSearch(arr, target, 0, arr.length-1));
    }

}