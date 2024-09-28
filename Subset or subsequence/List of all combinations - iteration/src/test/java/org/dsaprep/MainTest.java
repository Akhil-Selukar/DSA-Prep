package org.dsaprep;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

public class MainTest {

    @Test
    public void testSubset_Test1(){
        int[] arr = {1,2,3};
        List<List<Integer>> ans = Main.subset(arr);

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
    }

    @Test
    public void testSubset_Test2(){
        int[] arr = {1,2,3,4};
        List<List<Integer>> ans = Main.subset(arr);

        assertTrue(ans.contains(new ArrayList<>()));
        assertTrue(ans.get(1).contains(1));
        assertTrue(ans.get(2).contains(2));
        assertTrue(ans.get(3).contains(2));
        assertTrue(ans.get(4).contains(3));
        assertTrue(ans.get(5).contains(1));
        assertTrue(ans.get(5).contains(3));
        assertTrue(ans.get(6).contains(2));
        assertTrue(ans.get(6).contains(3));
        assertTrue(ans.get(7).contains(1));
        assertTrue(ans.get(7).contains(2));
        assertTrue(ans.get(7).contains(3));
        assertTrue(ans.get(8).contains(4));
        assertTrue(ans.get(9).contains(1));
        assertTrue(ans.get(9).contains(4));
        assertTrue(ans.get(10).contains(2));
        assertTrue(ans.get(10).contains(4));
        assertTrue(ans.get(11).contains(1));
        assertTrue(ans.get(11).contains(2));
        assertTrue(ans.get(11).contains(4));
        assertTrue(ans.get(12).contains(3));
        assertTrue(ans.get(12).contains(4));
        assertTrue(ans.get(13).contains(1));
        assertTrue(ans.get(13).contains(3));
        assertTrue(ans.get(13).contains(4));
        assertTrue(ans.get(14).contains(2));
        assertTrue(ans.get(14).contains(3));
        assertTrue(ans.get(14).contains(4));
        assertTrue(ans.get(15).contains(1));
        assertTrue(ans.get(15).contains(2));
        assertTrue(ans.get(15).contains(3));
        assertTrue(ans.get(15).contains(4));
    }
}