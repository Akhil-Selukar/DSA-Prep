package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testFlipAndInvertImage_Test1(){
        int[][] image = {{1,1,0},{1,0,1},{0,0,0}};
        int[][] flipped = Main.flipAndInvertImage(image);

        assertEquals(1, flipped[0][0]);
        assertEquals(0, flipped[0][1]);
        assertEquals(0, flipped[0][2]);
        assertEquals(0, flipped[1][0]);
        assertEquals(1, flipped[1][1]);
        assertEquals(0, flipped[1][2]);
        assertEquals(1, flipped[2][0]);
        assertEquals(1, flipped[2][1]);
        assertEquals(1, flipped[2][2]);
    }

    @Test
    public void testFlipAndInvertImage_Test2(){
        int[][] image = {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
        int[][] flipped = Main.flipAndInvertImage(image);

        assertEquals(1, flipped[0][0]);
        assertEquals(1, flipped[0][1]);
        assertEquals(0, flipped[0][2]);
        assertEquals(0, flipped[0][3]);
        assertEquals(0, flipped[1][0]);
        assertEquals(1, flipped[1][1]);
        assertEquals(1, flipped[1][2]);
        assertEquals(0, flipped[1][3]);
        assertEquals(0, flipped[2][0]);
        assertEquals(0, flipped[2][1]);
        assertEquals(0, flipped[2][2]);
        assertEquals(1, flipped[2][3]);
        assertEquals(1, flipped[3][0]);
        assertEquals(0, flipped[3][1]);
        assertEquals(1, flipped[3][2]);
        assertEquals(0, flipped[3][3]);
    }

    @Test
    public void testFlipAndInvertImage_Test3(){
        int[][] image = {{1,0},{1,1}};
        int[][] flipped = Main.flipAndInvertImage(image);

        assertEquals(1, flipped[0][0]);
        assertEquals(0, flipped[0][1]);
        assertEquals(0, flipped[1][0]);
        assertEquals(0, flipped[1][1]);
    }

    @Test
    public void testFlipAndInvertImage2_Test1(){
        int[][] image = {{1,1,0},{1,0,1},{0,0,0}};
        int[][] flipped = Main.flipAndInvertImage2(image);

        assertEquals(1, flipped[0][0]);
        assertEquals(0, flipped[0][1]);
        assertEquals(0, flipped[0][2]);
        assertEquals(0, flipped[1][0]);
        assertEquals(1, flipped[1][1]);
        assertEquals(0, flipped[1][2]);
        assertEquals(1, flipped[2][0]);
        assertEquals(1, flipped[2][1]);
        assertEquals(1, flipped[2][2]);
    }

    @Test
    public void testFlipAndInvertImage2_Test2(){
        int[][] image = {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
        int[][] flipped = Main.flipAndInvertImage2(image);

        assertEquals(1, flipped[0][0]);
        assertEquals(1, flipped[0][1]);
        assertEquals(0, flipped[0][2]);
        assertEquals(0, flipped[0][3]);
        assertEquals(0, flipped[1][0]);
        assertEquals(1, flipped[1][1]);
        assertEquals(1, flipped[1][2]);
        assertEquals(0, flipped[1][3]);
        assertEquals(0, flipped[2][0]);
        assertEquals(0, flipped[2][1]);
        assertEquals(0, flipped[2][2]);
        assertEquals(1, flipped[2][3]);
        assertEquals(1, flipped[3][0]);
        assertEquals(0, flipped[3][1]);
        assertEquals(1, flipped[3][2]);
        assertEquals(0, flipped[3][3]);
    }

    @Test
    public void testFlipAndInvertImage2_Test3(){
        int[][] image = {{1,0},{1,1}};
        int[][] flipped = Main.flipAndInvertImage2(image);

        assertEquals(1, flipped[0][0]);
        assertEquals(0, flipped[0][1]);
        assertEquals(0, flipped[1][0]);
        assertEquals(0, flipped[1][1]);
    }
}