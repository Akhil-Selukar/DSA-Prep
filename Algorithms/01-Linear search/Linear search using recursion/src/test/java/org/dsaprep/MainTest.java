package org.dsaprep;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testLSearch_Test1(){
        int[] arr = {1,3,2,9,16,19,15,4};
        int target = 9;

        assertEquals(3, Main.lSearch(arr, target));
    }

    @Test
    public void testLSearch_Test2(){
        int[] arr = {1,3,2,9,16,19,15,4};
        int target = 1;

        assertEquals(0, Main.lSearch(arr, target));
    }

    @Test
    public void testLSearch_Test3(){
        int[] arr = {1,3,2,9,16,19,15,4};
        int target = 19;

        assertEquals(5, Main.lSearch(arr, target));
    }

    @Test
    public void testLSearch_Test4(){
        int[] arr = {1,3,2,9,16,19,15,4};
        int target = 4;

        assertEquals(7, Main.lSearch(arr, target));
    }

    @Test
    public void testLSearch_Test5(){
        int[] arr = {1,3,2,9,16,19,15,4};
        int target = 25;

        assertEquals(-1, Main.lSearch(arr, target));
    }

}