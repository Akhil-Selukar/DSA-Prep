package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testFindKthPositive_Test1(){
        int[] arr = {2,3,4,7,11};
        int k = 5;

        assertEquals(9, Main.findKthPositive(arr, k));
    }

    @Test
    public void testFindKthPositive_Test2(){
        int[] arr = {1,2,3,4,5};
        int k = 3;

        assertEquals(8, Main.findKthPositive(arr, k));
    }

    @Test
    public void testFindKthPositive_Test3(){
        int[] arr = {2,3,5,8,11};
        int k = 1;

        assertEquals(1, Main.findKthPositive(arr, k));
    }

    @Test
    public void testFindKthPositive_Test4(){
        int[] arr = {1,3,5,7,9,11,13,15,17};
        int k = 8;

        assertEquals(16, Main.findKthPositive(arr, k));
    }

    @Test
    public void testFindKthPositive_Test5(){
        int[] arr = {1,3,5,7,9,11,13,15,17};
        int k = 9;

        assertEquals(18, Main.findKthPositive(arr, k));
    }

    @Test
    public void testFindKthPositive_Test6(){
        int[] arr = {1};
        int k = 100;

        assertEquals(101, Main.findKthPositive(arr, k));
    }
}