package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testFindErrorNums_Test1(){
        int[] nums = {1,2,2,4};

        int[] ans = Main.findErrorNums(nums);

        assertEquals(2, ans.length);
        assertEquals(2, ans[0]);
        assertEquals(3, ans[1]);
    }

    @Test
    public void testFindErrorNums_Test2(){
        int[] nums = {1,1};

        int[] ans = Main.findErrorNums(nums);

        assertEquals(2, ans.length);
        assertEquals(1, ans[0]);
        assertEquals(2, ans[1]);
    }

        @Test
        public void testFindErrorNums_Test3(){
            int[] nums = {4,2,3,1,6,2};

            int[] ans = Main.findErrorNums(nums);

            assertEquals(2, ans.length);
            assertEquals(2, ans[0]);
            assertEquals(5, ans[1]);
    }
}