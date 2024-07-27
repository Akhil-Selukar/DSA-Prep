package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class MainTest {

    @Test
    public void testFindRotation_Test1(){
        int[][] mat = {{0,1},{1,0}};
        int[][] target = {{1,0},{0,1}};

        assertTrue(Main.findRotation(mat, target));
    }

    @Test
    public void testFindRotation_Test2(){
        int[][] mat = {{0,1},{1,1}};
        int[][] target = {{1,0},{0,1}};

        assertFalse(Main.findRotation(mat, target));
    }

    @Test
    public void testFindRotation_Test3(){
        int[][] mat = {{0,0,0},{0,1,0},{1,1,1}};
        int[][] target = {{1,1,1},{0,1,0},{0,0,0}};

        assertTrue(Main.findRotation(mat, target));
    }
}