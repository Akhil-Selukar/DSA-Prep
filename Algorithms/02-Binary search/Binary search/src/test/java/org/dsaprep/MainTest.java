package org.dsaprep;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

//    Ascending sorted array
    @Test
    public void testBinarySearchAscending_TargetToTheLeft(){
        int[] arr = {1,3,5,6,7,9,12,13,16,18,19};
        int target = 5;

        assertEquals(2, Main.binarySearchAscending(arr, target));
    }

    @Test
    public void testBinarySearchAscending_TargetToTheRight(){
        int[] arr = {0,2,3,4,6,8,9,10,16,19,26,28,29};
        int target = 28;

        assertEquals(11, Main.binarySearchAscending(arr, target));
    }

    @Test
    public void testBinarySearchAscending_TargetInTheMiddle(){
        int[] arr = {0,2,3,4,6,8,9,10,16,19,26,28,29};
        int target = 9;

        assertEquals(6, Main.binarySearchAscending(arr, target));
    }

    @Test
    public void testBinarySearchAscending_TargetNotPresent(){
        int[] arr = {0,2,3,4,6,8,9,10,16,19,26,28,29};
        int target = 11;

        assertEquals(-1, Main.binarySearchAscending(arr, target));
    }

    @Test
    public void testBinarySearchAscending_TargetAsFirstElement(){
        int[] arr = {0,2,3,4,6,8,9,10,16,19,26,28,29};
        int target = 0;

        assertEquals(0, Main.binarySearchAscending(arr, target));
    }

    @Test
    public void testBinarySearchAscending_TargetAsLastElement(){
        int[] arr = {0,2,3,4,6,8,9,10,16,19,26,28,29};
        int target = 29;

        assertEquals(12, Main.binarySearchAscending(arr, target));
    }

//    Descending sorted array
    @Test
    public void testBinarySearchDescending_TargetToTheLeft(){
        int[] arr = {19,18,16,13,12,9,7,6,5,3,1};
        int target = 16;

        assertEquals(2, Main.binarySearchDescending(arr, target));
    }

    @Test
    public void testBinarySearchDescending_TargetToTheRight(){
        int[] arr = {19,18,16,13,12,9,7,6,5,3,1};
        int target = 5;

        assertEquals(8, Main.binarySearchDescending(arr, target));
    }

    @Test
    public void testBinarySearchDescending_TargetInTheMiddle(){
        int[] arr = {19,18,16,13,12,9,7,6,5,3,1};
        int target = 9;

        assertEquals(5, Main.binarySearchDescending(arr, target));
    }

    @Test
    public void testBinarySearchDescending_TargetNotPresent(){
        int[] arr = {19,18,16,13,12,9,7,6,5,3,1};
        int target = 11;

        assertEquals(-1, Main.binarySearchDescending(arr, target));
    }

    @Test
    public void testBinarySearchDescending_TargetAsFirstElement(){
        int[] arr = {19,18,16,13,12,9,7,6,5,3,1};
        int target = 19;

        assertEquals(0, Main.binarySearchDescending(arr, target));
    }

    @Test
    public void testBinarySearchDescending_TargetAsLastElement(){
        int[] arr = {19,18,16,13,12,9,7,6,5,3,1};
        int target = 1;

        assertEquals(10, Main.binarySearchDescending(arr, target));
    }

//    Order agnostic binary search
@Test
    public void testBinarySearchOrderAgnostic_TargetToTheLeft(){
        int[] arr = {1,3,5,6,7,9,12,13,16,18,19};
        int target = 5;

        assertEquals(2, Main.binarySearchOrderAgnostic(arr, target));
    }

    @Test
    public void testBinarySearchOrderAgnostic_TargetToTheRight(){
        int[] arr = {0,2,3,4,6,8,9,10,16,19,26,28,29};
        int target = 28;

        assertEquals(11, Main.binarySearchOrderAgnostic(arr, target));
    }

    @Test
    public void testBinarySearchOrderAgnostic_TargetInTheMiddle(){
        int[] arr = {0,2,3,4,6,8,9,10,16,19,26,28,29};
        int target = 9;

        assertEquals(6, Main.binarySearchOrderAgnostic(arr, target));
    }

    @Test
    public void testBinarySearchOrderAgnostic_TargetNotPresent(){
        int[] arr = {0,2,3,4,6,8,9,10,16,19,26,28,29};
        int target = 11;

        assertEquals(-1, Main.binarySearchOrderAgnostic(arr, target));
    }

    @Test
    public void testBinarySearchOrderAgnostic_TargetAsFirstElement(){
        int[] arr = {0,2,3,4,6,8,9,10,16,19,26,28,29};
        int target = 0;

        assertEquals(0, Main.binarySearchOrderAgnostic(arr, target));
    }

    @Test
    public void testBinarySearchOrderAgnostic_TargetAsLastElement(){
        int[] arr = {0,2,3,4,6,8,9,10,16,19,26,28,29};
        int target = 29;

        assertEquals(12, Main.binarySearchOrderAgnostic(arr, target));
    }
}