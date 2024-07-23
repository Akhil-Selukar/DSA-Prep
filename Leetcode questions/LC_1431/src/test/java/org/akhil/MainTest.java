package org.akhil;

import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;


public class MainTest{

    @Test
    public void testKidsWithCandies_Test1(){
        int[] candies = {2,3,5,1,3};
        int extraCandies = 3;

        List<Boolean> result = Main.kidsWithCandies(candies, extraCandies);
        assertEquals(5, result.size());
        assertTrue(result.get(0));
        assertTrue(result.get(1));
        assertTrue(result.get(2));
        assertFalse(result.get(3));
        assertTrue(result.get(4));
    }

    @Test
    public void testKidsWithCandies_Test2(){
        int[] candies = {2,3,15,1,3};
        int extraCandies = 3;

        List<Boolean> result = Main.kidsWithCandies(candies, extraCandies);
        assertEquals(5, result.size());
        assertFalse(result.get(0));
        assertFalse(result.get(1));
        assertTrue(result.get(2));
        assertFalse(result.get(3));
        assertFalse(result.get(4));
    }
}