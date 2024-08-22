package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {
    @Test
    public void testMaximumProduct_Test1() {
        int[] arr = {0, 2, 3, 4};

        assertEquals(24, Main.maximumProduct(arr));
    }

    @Test
    public void testMaximumProduct_Test2() {
        int[] arr = {2, 3, 4};

        assertEquals(24, Main.maximumProduct(arr));
    }

    @Test
    public void testMaximumProduct_Test3() {
        int[] arr = {3, 4};

        assertEquals(12, Main.maximumProduct(arr));
    }

    @Test
    public void testMaximumProduct_Test4() {
        int[] arr = {0};

        assertEquals(0, Main.maximumProduct(arr));
    }

    @Test
    public void testMaximumProduct_Test5() {
        int[] arr = {0, 2, -3, 4};

        assertEquals(0, Main.maximumProduct(arr));
    }

    @Test
    public void testMaximumProduct_Test6() {
        int[] arr = {8, -12, -10, 2, 3, 4};

        assertEquals(960, Main.maximumProduct(arr));
    }

    @Test
    public void testMaximumProduct_Test7() {
        int[] arr = {-100, -98, -1, 2, 3, 4};

        assertEquals(39200, Main.maximumProduct(arr));
    }

    @Test
    public void testMaximumProduct_Test8() {
        int[] arr = {-100,-2,-3,1};

        assertEquals(300, Main.maximumProduct(arr));
    }

    @Test
    public void testMaximumProduct_2_Test1() {
        int[] arr = {0, 2, 3, 4};

        assertEquals(24, Main.maximumProduct_2(arr));
    }

    @Test
    public void testMaximumProduct_2_Test2() {
        int[] arr = {2, 3, 4};

        assertEquals(24, Main.maximumProduct_2(arr));
    }

    @Test
    public void testMaximumProduct_2_Test3() {
        int[] arr = {3, 4};

        assertEquals(12, Main.maximumProduct_2(arr));
    }

    @Test
    public void testMaximumProduct_2_Test4() {
        int[] arr = {0};

        assertEquals(0, Main.maximumProduct_2(arr));
    }

    @Test
    public void testMaximumProduct_2_Test5() {
        int[] arr = {0, 2, -3, 4};

        assertEquals(0, Main.maximumProduct_2(arr));
    }

    @Test
    public void testMaximumProduct_2_Test6() {
        int[] arr = {8, -12, -10, 2, 3, 4};

        assertEquals(960, Main.maximumProduct_2(arr));
    }

    @Test
    public void testMaximumProduct_2_Test7() {
        int[] arr = {-100, -98, -1, 2, 3, 4};

        assertEquals(39200, Main.maximumProduct_2(arr));
    }

    @Test
    public void testMaximumProduct_2_Test8() {
        int[] arr = {-100,-2,-3,1};

        assertEquals(300, Main.maximumProduct_2(arr));
    }
}