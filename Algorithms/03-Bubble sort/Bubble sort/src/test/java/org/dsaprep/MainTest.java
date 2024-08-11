package org.dsaprep;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testBubbleSort_Test1(){
        int[] arr = {1,4,3,2,5,7,6};

        int[] ans = Main.bubbleSort(arr);

        assertEquals(7, ans.length);
        assertEquals(1, ans[0]);
        assertEquals(2, ans[1]);
        assertEquals(3, ans[2]);
        assertEquals(4, ans[3]);
        assertEquals(5, ans[4]);
        assertEquals(6, ans[5]);
        assertEquals(7, ans[6]);
    }

    @Test
    public void testBubbleSort_Test2(){
        int[] arr = {1};

        int[] ans = Main.bubbleSort(arr);

        assertEquals(1, ans.length);
        assertEquals(1, ans[0]);
    }

    @Test
    public void testBubbleSort_Test3(){
        int[] arr = {};

        int[] ans = Main.bubbleSort(arr);

        assertEquals(0, ans.length);
    }

    @Test
    public void testBubbleSort_Test4(){
        int[] arr = {-1, 0, 5, -35, 35};

        int[] ans = Main.bubbleSort(arr);

        assertEquals(5, ans.length);
        assertEquals(-35, ans[0]);
        assertEquals(-1, ans[1]);
        assertEquals(0, ans[2]);
        assertEquals(5, ans[3]);
        assertEquals(35, ans[4]);
    }

    @Test
    public void testBubbleSort_Test5(){
        int[] arr = {-1, 0, -5, -35,};

        int[] ans = Main.bubbleSort(arr);

        assertEquals(4, ans.length);
        assertEquals(-35, ans[0]);
        assertEquals(-5, ans[1]);
        assertEquals(-1, ans[2]);
        assertEquals(0, ans[3]);
    }
}