package org.akhil;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testFindNumbers_SimpleCase(){
        int[] nums = {12, 345, 2, 6, 7896};
        assertEquals(2, Main.findNumbers(nums));
    }

    @Test
    public void testFindNumbers_NoEvenNumbers(){
        int[] nums = {123, 345, 1, 0, 12365};
        assertEquals(0, Main.findNumbers(nums));
    }

    @Test
    public void testFindNumbers_AllEvenNumbers(){
        int[] nums = {11, 2222, 333333, 15};
        assertEquals(4, Main.findNumbers(nums));
    }

    @Test
    public void testFindNumbers_EmptyArray(){
        int[] nums = {};
        assertEquals(0, Main.findNumbers(nums));
    }

    @Test
    public void testFindNumbers_NegativeNumbersInArray(){
        int[] nums = {-5, -23, -156, -7561, 452, 44};
        assertEquals(3, Main.findNumbers(nums));
    }

    @Test
    public void testGetDigits_SimpleTest(){
        int number = 123658;
        assertEquals(6, Main.getDigits(number));
    }

    @Test
    public void testGetDigits_NegativeNumber(){
        int number = -23658;
        assertEquals(5, Main.getDigits(number));
    }

    @Test
    public void testGetDigits_ZeroTest(){
        int number = 0;
        assertEquals(1, Main.getDigits(number));
    }
}