package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testFindInMountainArray_TargetInMiddle(){
        int[] arr = {1,3,4,6,8,7,5,};
        int target = 8;

        assertEquals(4, Main.findInMountainArray(arr, target));
    }

    @Test
    public void testFindInMountainArray_TargetAtStart(){
        int[] arr = {1,3,4,6,8,7,5,};
        int target = 1;

        assertEquals(0, Main.findInMountainArray(arr, target));
    }

    @Test
    public void testFindInMountainArray_TargetAtEnd(){
        int[] arr = {1,3,4,6,8,7,5,};
        int target = 5;

        assertEquals(6, Main.findInMountainArray(arr, target));
    }

    @Test
    public void testFindInMountainArray_TargetInAscendingSide(){
        int[] arr = {1,3,4,6,8,7,5,};
        int target = 4;

        assertEquals(2, Main.findInMountainArray(arr, target));
    }

    @Test
    public void testFindInMountainArray_TargetInDescendingSide(){
        int[] arr = {1,3,4,6,8,7,5,};
        int target = 7;

        assertEquals(5, Main.findInMountainArray(arr, target));
    }

    @Test
    public void testFindInMountainArray_TargetNotPresent(){
        int[] arr = {1,3,4,6,8,7,5,};
        int target = 10;

        assertEquals(-1, Main.findInMountainArray(arr, target));
    }

    @Test
    public void testFindInMountainArray_Negativetarget(){
        int[] arr = {1,3,4,6,8,7,5,};
        int target = -10;

        assertEquals(-1, Main.findInMountainArray(arr, target));
    }
}