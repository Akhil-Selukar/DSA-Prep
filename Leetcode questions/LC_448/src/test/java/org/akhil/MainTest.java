package org.akhil;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testFindDisappearedNumbers_Test1(){
        int[] nums = {4,3,2,7,8,2,3,1};

        List<Integer> ans = Main.findDisappearedNumbers(nums);

        assertEquals(2, ans.size());
        assertEquals(5, (int)ans.get(0));
        assertEquals(6, (int)ans.get(1));
    }

    @Test
    public void testFindDisappearedNumbers_Test2(){
        int[] nums = {1,1};

        List<Integer> ans = Main.findDisappearedNumbers(nums);

        assertEquals(1, ans.size());
        assertEquals(2, (int)ans.get(0));
    }

    @Test
    public void testFindDisappearedNumbers_Test3(){
        int[] nums = {1,2,6,2,2,2};

        List<Integer> ans = Main.findDisappearedNumbers(nums);

        assertEquals(3, ans.size());
        assertEquals(3, (int)ans.get(0));
        assertEquals(4, (int)ans.get(1));
        assertEquals(5, (int)ans.get(2));
    }

    @Test
    public void testFindDisappearedNumbers_Test4(){
        int[] nums = {1};

        List<Integer> ans = Main.findDisappearedNumbers(nums);

        assertEquals(0, ans.size());
    }

}