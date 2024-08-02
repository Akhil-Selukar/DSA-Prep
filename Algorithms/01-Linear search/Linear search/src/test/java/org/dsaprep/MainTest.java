package org.dsaprep;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testLinearSearch_TargetInMiddle_1(){
        int[] arr = {1,6,5,3,8,9,16,75,2,19};
        int target = 5;

        assertEquals(2,Main.linearSearch(arr, target));
    }

    @Test
    public void testLinearSearch_TargetInMiddle_2(){
        int[] arr = {1,6,5,3,8,9,16,75,2,19};
        int target = 75;

        assertEquals(7,Main.linearSearch(arr, target));
    }

    @Test
    public void testLinearSearch_TargetAsFirstElement(){
        int[] arr = {1,6,5,3,8,9,16,75,2,19};
        int target = 1;

        assertEquals(0,Main.linearSearch(arr, target));
    }

    @Test
    public void testLinearSearch_TargetAsLastElement(){
        int[] arr = {1,6,5,3,8,9,16,75,2,19};
        int target = 19;

        assertEquals(9,Main.linearSearch(arr, target));
    }

    @Test
    public void testLinearSearch_TargetNotPresent(){
        int[] arr = {1,6,5,3,8,9,16,75,2,19};
        int target = 20;

        assertEquals(-1,Main.linearSearch(arr, target));
    }
}