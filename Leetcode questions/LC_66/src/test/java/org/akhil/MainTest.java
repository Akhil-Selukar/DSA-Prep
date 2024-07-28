package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testPlusOne_Test1(){
        int[] digits = {1,2,3};
        int[] ans = Main.plusOne(digits);

        assertEquals(3, ans.length);
        assertEquals(1, ans[0]);
        assertEquals(2, ans[1]);
        assertEquals(4, ans[2]);
    }

    @Test
    public void testPlusOne_Test2(){
        int[] digits = {1,2,9};
        int[] ans = Main.plusOne(digits);

        assertEquals(3, ans.length);
        assertEquals(1, ans[0]);
        assertEquals(3, ans[1]);
        assertEquals(0, ans[2]);
    }

    @Test
    public void testPlusOne_Test3(){
        int[] digits = {9,9,9};
        int[] ans = Main.plusOne(digits);

        assertEquals(4, ans.length);
        assertEquals(1, ans[0]);
        assertEquals(0, ans[1]);
        assertEquals(0, ans[2]);
        assertEquals(0, ans[3]);
    }

    @Test
    public void testPlusOne_Test4(){
        int[] digits = {0};
        int[] ans = Main.plusOne(digits);

        assertEquals(1, ans.length);
        assertEquals(1, ans[0]);
    }
}