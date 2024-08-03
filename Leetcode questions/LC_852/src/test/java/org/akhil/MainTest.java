package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testPeakIndexInMountainArray_Test1(){
        int[] arr = {0,1,2,5,6,8,7,6,4,3,1};

        assertEquals(5, Main.peakIndexInMountainArray(arr));
    }

    @Test
    public void testPeakIndexInMountainArray_Test2(){
        int[] arr = {0,1,0};

        assertEquals(1, Main.peakIndexInMountainArray(arr));
    }

    @Test
    public void testPeakIndexInMountainArray_Test3(){
        int[] arr = {0,2,1,0};

        assertEquals(1, Main.peakIndexInMountainArray(arr));
    }

    @Test
    public void testPeakIndexInMountainArray_Test4(){
        int[] arr = {0,1,2,0};

        assertEquals(2, Main.peakIndexInMountainArray(arr));
    }

    @Test
    public void testPeakIndexInMountainArray_Test5(){
        int[] arr = {0,10,5,2};

        assertEquals(1, Main.peakIndexInMountainArray(arr));
    }

    @Test
    public void testPeakIndexInMountainArray_Test6(){
        int[] arr = {0,10,11,12};

        assertEquals(3, Main.peakIndexInMountainArray(arr));
    }

    @Test
    public void testPeakIndexInMountainArray_Test7(){
        int[] arr = {8,5,2,1};

        assertEquals(0, Main.peakIndexInMountainArray(arr));
    }
}