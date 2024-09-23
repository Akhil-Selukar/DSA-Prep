package org.akhil;

import org.junit.Test;
import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void testPrintMin_Test1(){
        int[] arr = {1, 4, 3, -5, -4, 8, 6};

        assertEquals(-5, Main.printMin(arr, arr.length-1));
    }

    @Test
    public void testPrintMin_Test2(){
        int[] arr = {1, 4, 3, -5, -5, -4, 8, 6};

        assertEquals(-5, Main.printMin(arr, arr.length-1));
    }

    @Test
    public void testPrintMin_Test3(){
        int[] arr = {-5, 1, 4, 3, -4, 8, 6};

        assertEquals(-5, Main.printMin(arr, arr.length-1));
    }

    @Test
    public void testPrintMin_Test4(){
        int[] arr = {1, 1};

        assertEquals(1, Main.printMin(arr, arr.length-1));
    }

    @Test
    public void testPrintMin_Test5(){
        int[] arr = {2};

        assertEquals(2, Main.printMin(arr, arr.length-1));
    }

    @Test
    public void testPrintMin_Test6(){
        int[] arr = {5, 1, 4, 3, 4, 8, 6};

        assertEquals(1, Main.printMin(arr, arr.length-1));
    }

    @Test
    public void testPrintMin_Test7(){
        int[] arr = {-5, -1, -4, -3, -4, -8, -6};

        assertEquals(-8, Main.printMin(arr, arr.length-1));
    }

    @Test
    public void testPrintMax_Test1(){
        int[] arr = {1, 4, 3, -5, -4, 8, 6};

        assertEquals(8, Main.printMax(arr, arr.length-1));
    }

    @Test
    public void testPrintMax_Test2(){
        int[] arr = {1, 4, 3, 8, -5, -4, 8, 6};

        assertEquals(8, Main.printMax(arr, arr.length-1));
    }

    @Test
    public void testPrintMax_Test3(){
        int[] arr = {-5, 1, 4, 3, -4, 6, 8};

        assertEquals(8, Main.printMax(arr, arr.length-1));
    }

    @Test
    public void testPrintMax_Test4(){
        int[] arr = {1, 1};

        assertEquals(1, Main.printMax(arr, arr.length-1));
    }

    @Test
    public void testPrintMax_Test5(){
        int[] arr = {2};

        assertEquals(2, Main.printMax(arr, arr.length-1));
    }

    @Test
    public void testPrintMax_Test6(){
        int[] arr = {5, 1, 4, 3, 4, 8, 6};

        assertEquals(8, Main.printMax(arr, arr.length-1));
    }

    @Test
    public void testPrintMax_Test7(){
        int[] arr = {-5, -1, -4, -3, -4, -8, -6};

        assertEquals(-1, Main.printMax(arr, arr.length-1));
    }

    @Test
    public void testPrintMax_Test8(){
        int[] arr = {-5, -1, -4, 0, -4, -8, -6};

        assertEquals(0, Main.printMax(arr, arr.length-1));
    }
}