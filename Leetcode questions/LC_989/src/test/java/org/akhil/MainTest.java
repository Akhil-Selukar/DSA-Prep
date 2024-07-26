package org.akhil;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testAddToArrayForm_Test1(){
        int[] num = {1,2,0,0};
        int k = 34;

        List<Integer> ans = Main.addToArrayForm(num, k);

        assertEquals(1, (int)ans.get(0));
        assertEquals(2, (int)ans.get(1));
        assertEquals(3, (int)ans.get(2));
        assertEquals(4, (int)ans.get(3));
    }

    @Test
    public void testAddToArrayForm_Test2(){
        int[] num = {2,7,4};
        int k = 181;

        List<Integer> ans = Main.addToArrayForm(num, k);

        assertEquals(4, (int)ans.get(0));
        assertEquals(5, (int)ans.get(1));
        assertEquals(5, (int)ans.get(2));
    }

    @Test
    public void testAddToArrayForm_Test3(){
        int[] num = {2,1,5};
        int k = 806;

        List<Integer> ans = Main.addToArrayForm(num, k);

        assertEquals(1, (int)ans.get(0));
        assertEquals(0, (int)ans.get(1));
        assertEquals(2, (int)ans.get(2));
        assertEquals(1, (int)ans.get(3));
    }

    @Test
    public void testAddToArrayForm_Test4(){
        int[] num = {9,9,9,9,9,9,9,9,9,9};
        int k = 1;

        List<Integer> ans = Main.addToArrayForm(num, k);

        assertEquals(1, (int)ans.get(0));
        assertEquals(0, (int)ans.get(1));
        assertEquals(0, (int)ans.get(2));
        assertEquals(0, (int)ans.get(3));
        assertEquals(0, (int)ans.get(4));
        assertEquals(0, (int)ans.get(5));
        assertEquals(0, (int)ans.get(6));
        assertEquals(0, (int)ans.get(7));
        assertEquals(0, (int)ans.get(8));
        assertEquals(0, (int)ans.get(9));
        assertEquals(0, (int)ans.get(10));
    }
}