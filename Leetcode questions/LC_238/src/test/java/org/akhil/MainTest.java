package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testProductExceptSelf_Test1(){
        int[] nums = {1,2,3,4};

        int[] ans = Main.productExceptSelf(nums);

        assertEquals(4, ans.length);
        assertEquals(24, ans[0]);
        assertEquals(12, ans[1]);
        assertEquals(8, ans[2]);
        assertEquals(6, ans[3]);
    }

    @Test
    public void testProductExceptSelf_Test2(){
        int[] nums = {-1,1,0,-3,3};

        int[] ans = Main.productExceptSelf(nums);

        assertEquals(5, ans.length);
        assertEquals(0, ans[0]);
        assertEquals(0, ans[1]);
        assertEquals(9, ans[2]);
        assertEquals(0, ans[3]);
        assertEquals(0, ans[4]);
    }

    @Test
    public void testProductExceptSelf_Test3(){
        int[] nums = {-1,1,5,-3,3};

        int[] ans = Main.productExceptSelf(nums);

        assertEquals(5, ans.length);
        assertEquals(-45, ans[0]);
        assertEquals(45, ans[1]);
        assertEquals(9, ans[2]);
        assertEquals(-15, ans[3]);
        assertEquals(15, ans[4]);
    }

}