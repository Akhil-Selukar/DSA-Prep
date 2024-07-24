package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testSmallerNumbersThanCurrent_Test1(){
        int[] arr = {8,1,2,2,3};
        int[] ans = Main.smallerNumbersThanCurrent(arr);

        assertEquals(5, ans.length);
        assertEquals(4, ans[0]);
        assertEquals(0, ans[1]);
        assertEquals(1, ans[2]);
        assertEquals(1, ans[3]);
        assertEquals(3, ans[4]);
    }

    @Test
    public void testSmallerNumbersThanCurrent_Test2(){
        int[] arr = {6,5,4,8};
        int[] ans = Main.smallerNumbersThanCurrent(arr);

        assertEquals(4, ans.length);
        assertEquals(2, ans[0]);
        assertEquals(1, ans[1]);
        assertEquals(0, ans[2]);
        assertEquals(3, ans[3]);
    }

    @Test
    public void testSmallerNumbersThanCurrent_Test3(){
        int[] arr = {7,7,7,7};
        int[] ans = Main.smallerNumbersThanCurrent(arr);

        assertEquals(4, ans.length);
        assertEquals(0, ans[0]);
        assertEquals(0, ans[1]);
        assertEquals(0, ans[2]);
        assertEquals(0, ans[3]);
    }

    @Test
    public void testSmallerNumbersThanCurrent_Test4(){
        int[] arr = {};
        int[] ans = Main.smallerNumbersThanCurrent(arr);

        assertEquals(0, ans.length);
    }
}