package org.dsaprep;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

public class MainTest {

    @Test
    public void testSubset_Test1(){
        int[] arr = {1,2,2};
        List<List<Integer>> ans = Main.subsetDuplicates(arr);

        assertTrue(ans.contains(new ArrayList<>()));
        assertTrue(ans.get(1).contains(1));
        assertTrue(ans.get(2).contains(2));
        assertTrue(ans.get(3).contains(1));
        assertTrue(ans.get(3).contains(2));
        assertTrue(ans.get(4).contains(2));
        assertEquals(2, ans.get(4).size());
        assertTrue(ans.get(5).contains(1));
        assertTrue(ans.get(5).contains(2));
        assertEquals(3,ans.get(5).size());
    }

    @Test
    public void testSubset_Test2(){
        int[] arr = {1,3,2,3};
        List<List<Integer>> ans = Main.subsetDuplicates(arr);

        assertTrue(ans.contains(new ArrayList<>()));
        assertTrue(ans.get(1).contains(1));
        assertTrue(ans.get(2).contains(2));
        assertTrue(ans.get(3).contains(1));
        assertTrue(ans.get(3).contains(2));
        assertTrue(ans.get(4).contains(3));
        assertTrue(ans.get(5).contains(1));
        assertTrue(ans.get(5).contains(3));
        assertTrue(ans.get(6).contains(2));
        assertTrue(ans.get(6).contains(3));
        assertTrue(ans.get(7).contains(1));
        assertTrue(ans.get(7).contains(2));
        assertTrue(ans.get(7).contains(3));
        assertTrue(ans.get(8).contains(3));
        assertEquals(2,ans.get(8).size());
        assertTrue(ans.get(9).contains(1));
        assertTrue(ans.get(9).contains(3));
        assertEquals(3,ans.get(9).size());
        assertTrue(ans.get(10).contains(2));
        assertTrue(ans.get(10).contains(3));
        assertEquals(3,ans.get(10).size());
        assertTrue(ans.get(11).contains(1));
        assertTrue(ans.get(11).contains(2));
        assertTrue(ans.get(11).contains(3));
        assertTrue(ans.get(11).contains(3));
        assertEquals(4,ans.get(11).size());
    }
}