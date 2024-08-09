package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testTwoSum_Test1(){
        int[] numbers = {2,7,11,15};
        int target = 9;

        int[] ans = Main.twoSum(numbers, target);

        assertEquals(1, ans[0]);
        assertEquals(2, ans[1]);
    }

    @Test
    public void testTwoSum_Test2(){
        int[] numbers = {2,7,11,15};
        int target = 17;

        int[] ans = Main.twoSum(numbers, target);

        assertEquals(1, ans[0]);
        assertEquals(4, ans[1]);
    }

    @Test
    public void testTwoSum_Test3(){
        int[] numbers = {2,7,11,15};
        int target = 18;

        int[] ans = Main.twoSum(numbers, target);

        assertEquals(2, ans[0]);
        assertEquals(3, ans[1]);
    }

    @Test
    public void testTwoSum_Test4(){
        int[] numbers = {2,7,11,15};
        int target = 26;

        int[] ans = Main.twoSum(numbers, target);

        assertEquals(3, ans[0]);
        assertEquals(4, ans[1]);
    }

    @Test
    public void testTwoSum_Test5(){
        int[] numbers = {-2,-1,0,1,2,3,4};
        int target = 4;

        int[] ans = Main.twoSum(numbers, target);

        assertEquals(3, ans[0]);
        assertEquals(7, ans[1]);
    }

    @Test
    public void testTwoSum_Test6(){
        int[] numbers = {-2,-1,0,1,2,3,4};
        int target = 2;

        int[] ans = Main.twoSum(numbers, target);

        assertEquals(1, ans[0]);
        assertEquals(7, ans[1]);
    }

    @Test
    public void testTwoSum_Test7(){
        int[] numbers = {-2,-1,0,1,2,3,4};
        int target = 3;

        int[] ans = Main.twoSum(numbers, target);

        assertEquals(2, ans[0]);
        assertEquals(7, ans[1]);
    }
}