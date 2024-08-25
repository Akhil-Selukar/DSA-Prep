package org.akhil;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testMinimumAbsDifference_Test1(){
        int[] arr = {4,2,1,3};

        List<List<Integer>> ans = Main.minimumAbsDifference(arr);

        assertEquals(3, ans.size());
        assertEquals(1, (int)ans.get(0).get(0));
        assertEquals(2, (int)ans.get(0).get(1));
        assertEquals(2, (int)ans.get(1).get(0));
        assertEquals(3, (int)ans.get(1).get(1));
        assertEquals(3, (int)ans.get(2).get(0));
        assertEquals(4, (int)ans.get(2).get(1));
    }

    @Test
    public void testMinimumAbsDifference_Test2(){
        int[] arr = {1,3,6,10,15};

        List<List<Integer>> ans = Main.minimumAbsDifference(arr);

        assertEquals(1, ans.size());
        assertEquals(1, (int)ans.get(0).get(0));
        assertEquals(3, (int)ans.get(0).get(1));
    }

    @Test
    public void testMinimumAbsDifference_Test3(){
        int[] arr = {3,8,-10,23,19,-4,-14,27};

        List<List<Integer>> ans = Main.minimumAbsDifference(arr);

        assertEquals(3, ans.size());
        assertEquals(-14, (int)ans.get(0).get(0));
        assertEquals(-10, (int)ans.get(0).get(1));
        assertEquals(19, (int)ans.get(1).get(0));
        assertEquals(23, (int)ans.get(1).get(1));
        assertEquals(23, (int)ans.get(2).get(0));
        assertEquals(27, (int)ans.get(2).get(1));
    }
}