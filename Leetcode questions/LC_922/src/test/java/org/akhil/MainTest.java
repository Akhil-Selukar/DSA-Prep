package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testSortArrayByParityII_Test1(){
        int[] nums = {4,2,5,7};

        int[] ans = Main.sortArrayByParityII(nums);

        assertEquals(4, ans.length);
        assertEquals(4, ans[0]);
        assertEquals(5, ans[1]);
        assertEquals(2, ans[2]);
        assertEquals(7, ans[3]);
    }

    @Test
    public void testSortArrayByParityII_Test2(){
        int[] nums = {3,4};

        int[] ans = Main.sortArrayByParityII(nums);

        assertEquals(2, ans.length);
        assertEquals(4, ans[0]);
        assertEquals(3, ans[1]);
    }

    @Test
    public void testSortArrayByParityII_Test3(){
        int[] nums = {3,1,4,2};

        int[] ans = Main.sortArrayByParityII(nums);

        assertEquals(4, ans.length);
        assertEquals(2, ans[0]);
        assertEquals(1, ans[1]);
        assertEquals(4, ans[2]);
        assertEquals(3, ans[3]);
    }
}