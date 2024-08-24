package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testHeightChecker_Test1(){
        int[] heights = {1,1,4,2,1,3};

        assertEquals(3, Main.heightChecker(heights));
    }

    @Test
    public void testHeightChecker_Test2(){
        int[] heights = {1};

        assertEquals(0, Main.heightChecker(heights));
    }

    @Test
    public void testHeightChecker_Test3(){
        int[] heights = {1,2,1};

        assertEquals(2, Main.heightChecker(heights));
    }

    @Test
    public void testHeightChecker_Test4(){
        int[] heights = {1,2};

        assertEquals(0, Main.heightChecker(heights));
    }

    @Test
    public void testHeightChecker_Test5(){
        int[] heights = {5,1,2,3,4};

        assertEquals(5, Main.heightChecker(heights));
    }

    @Test
    public void testHeightChecker_Test6(){
        int[] heights = {1,2,3,4,5};

        assertEquals(0, Main.heightChecker(heights));
    }
}