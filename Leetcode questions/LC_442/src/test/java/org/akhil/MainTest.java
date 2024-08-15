package org.akhil;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testFindDuplicates_Test1(){
        int[] nums = {4,3,2,7,8,2,3,1};

        List<Integer> ans = Main.findDuplicates(nums);

        assertEquals(2, ans.size());
        assertEquals(3, (int)ans.get(0));
        assertEquals(2, (int)ans.get(1));
    }

    @Test
    public void testFindDuplicates_Test2(){
        int[] nums = {1,1,2};

        List<Integer> ans = Main.findDuplicates(nums);

        assertEquals(1, ans.size());
        assertEquals(1, (int)ans.get(0));
    }

    @Test
    public void testFindDuplicates_Test3(){
        int[] nums = {1};

        List<Integer> ans = Main.findDuplicates(nums);

        assertEquals(0, ans.size());
    }

    @Test
    public void testFindDuplicates_Test4(){
        int[] nums = {1,3,2,5,4,7,6};

        List<Integer> ans = Main.findDuplicates(nums);

        assertEquals(0, ans.size());
    }
    

}