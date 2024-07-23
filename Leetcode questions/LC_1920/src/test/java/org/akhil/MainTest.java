package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testBuildArray_NormalTest(){
        int[] arr = {0,2,1,5,3,4};
        assertEquals(6, Main.buildArray(arr).length);
        assertEquals(0, Main.buildArray(arr)[0]);
        assertEquals(1, Main.buildArray(arr)[1]);
        assertEquals(2, Main.buildArray(arr)[2]);
        assertEquals(4, Main.buildArray(arr)[3]);
        assertEquals(5, Main.buildArray(arr)[4]);
        assertEquals(3, Main.buildArray(arr)[5]);
    }

    @Test
    public void testBuildArray_EmptyArrayTest(){
        int[] arr = {};
        assertEquals(0, Main.buildArray(arr).length);
    }
}