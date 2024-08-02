package org.dsaprep;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testCeilingNumber_AscendingLeft_Test1(){
        int[] arr = {1,2,3,6,8,9,12,16,19};
        int target = 6;

        assertEquals(3, Main.ceilingNumber(arr, target));
    }

    @Test
    public void testCeilingNumber_AscendingLeft_Test2(){
        int[] arr = {1,2,3,6,8,9,12,16,19};
        int target = 7;

        assertEquals(4, Main.ceilingNumber(arr, target));
    }

    @Test
    public void testCeilingNumber_AscendingFirst(){
        int[] arr = {1,2,3,6,8,9,12,16,19};
        int target = 1;

        assertEquals(0, Main.ceilingNumber(arr, target));
    }

    @Test
    public void testCeilingNumber_AscendingLast_Test1(){
        int[] arr = {1,2,3,6,8,9,12,16,19};
        int target = 19;

        assertEquals(8, Main.ceilingNumber(arr, target));
    }

    @Test
    public void testCeilingNumber_AscendingMid(){
        int[] arr = {1,2,3,6,8,9,12,16,19};
        int target = 8;

        assertEquals(4, Main.ceilingNumber(arr, target));
    }

    @Test
    public void testCeilingNumber_DescendingLeft_Test1(){
        int[] arr = {19,16,12,9,8,6,3,2,1};
        int target = 12;

        assertEquals(2, Main.ceilingNumber(arr, target));
    }

    @Test
    public void testCeilingNumber_DescendingLeft_Test2(){
        int[] arr = {19,16,12,9,8,6,3,2,1};
        int target = 14;

        assertEquals(1, Main.ceilingNumber(arr, target));
    }

    @Test
    public void testCeilingNumber_DescendingRight_Test1(){
        int[] arr = {19,16,12,9,8,6,3,2,1};
        int target = 4;

        assertEquals(5, Main.ceilingNumber(arr, target));
    }

    @Test
    public void testCeilingNumber_DescendingFirst(){
        int[] arr = {19,16,12,9,8,6,3,2,1};
        int target = 19;

        assertEquals(0, Main.ceilingNumber(arr, target));
    }

    @Test
    public void testCeilingNumber_DescendingLast(){
        int[] arr = {19,16,12,9,8,6,3,2,1};
        int target = 1;

        assertEquals(8, Main.ceilingNumber(arr, target));
    }

    @Test
    public void testCeilingNumber_DescendingMid(){
        int[] arr = {19,16,12,9,8,6,3,2,1};
        int target = 8;

        assertEquals(4, Main.ceilingNumber(arr, target));
    }
}