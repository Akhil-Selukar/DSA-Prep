package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testMissingNumber_Test1(){
        int[] arr = {9,6,4,2,3,5,7,0,1};

        assertEquals(8, Main.missingNumber(arr));
    }

    @Test
    public void testMissingNumber_Test2(){
        int[] arr = {9,6,4,2,3,5,7,8,1};

        assertEquals(0, Main.missingNumber(arr));
    }

    @Test
    public void testMissingNumber_Test3(){
        int[] arr = {0,1,2};

        assertEquals(3, Main.missingNumber(arr));
    }

    @Test
    public void testMissingNumber_Test4(){
        int[] arr = {0,2,3};

        assertEquals(1, Main.missingNumber(arr));
    }

    @Test
    public void testMissingNumber_Test5(){
        int[] arr = {1};

        assertEquals(0, Main.missingNumber(arr));
    }
}