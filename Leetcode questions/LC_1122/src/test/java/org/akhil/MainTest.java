package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testRelativeSortArray_Test1(){
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};

        int[] ans = Main.relativeSortArray(arr1, arr2);

        assertEquals(arr1.length, ans.length);
        assertEquals(arr2[0], ans[0]);
        assertEquals(arr2[0], ans[1]);
        assertEquals(arr2[0], ans[2]);
        assertEquals(arr2[1], ans[3]);
        assertEquals(arr2[2], ans[4]);
        assertEquals(arr2[3], ans[5]);
        assertEquals(arr2[3], ans[6]);
        assertEquals(arr2[4], ans[7]);
        assertEquals(arr2[5], ans[8]);
        assertEquals(7, ans[9]);
        assertEquals(19, ans[10]);
    }

    @Test
    public void testRelativeSortArray_Test2(){
        int[] arr1 = {28,6,22,8,44,17};
        int[] arr2 = {22,28,8,6};

        int[] ans = Main.relativeSortArray(arr1, arr2);

        assertEquals(arr1.length, ans.length);
        assertEquals(arr2[0], ans[0]);
        assertEquals(arr2[1], ans[1]);
        assertEquals(arr2[2], ans[2]);
        assertEquals(arr2[3], ans[3]);
        assertEquals(17, ans[4]);
        assertEquals(44, ans[5]);
    }

    @Test
    public void testRelativeSortArray_Test3(){
        int[] arr1 = {1,2,4,1,3,7,2,3,1,1,0};
        int[] arr2 = {1,2};

        int[] ans = Main.relativeSortArray(arr1, arr2);

        assertEquals(arr1.length, ans.length);
        assertEquals(arr2[0], ans[0]);
        assertEquals(arr2[0], ans[1]);
        assertEquals(arr2[0], ans[2]);
        assertEquals(arr2[0], ans[3]);
        assertEquals(arr2[1], ans[4]);
        assertEquals(arr2[1], ans[5]);
        assertEquals(0, ans[6]);
        assertEquals(3, ans[7]);
        assertEquals(3, ans[8]);
        assertEquals(4, ans[9]);
        assertEquals(7, ans[10]);
    }
}