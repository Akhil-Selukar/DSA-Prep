package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testTranspose_Test1(){
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};

        int[][] transpose = Main.transpose(matrix);
        assertEquals(1, transpose[0][0]);
        assertEquals(4, transpose[0][1]);
        assertEquals(7, transpose[0][2]);
        assertEquals(2, transpose[1][0]);
        assertEquals(5, transpose[1][1]);
        assertEquals(8, transpose[1][2]);
        assertEquals(3, transpose[2][0]);
        assertEquals(6, transpose[2][1]);
        assertEquals(9, transpose[2][2]);
    }

    @Test
    public void testTranspose_Test2(){
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};

        int[][] transpose = Main.transpose(matrix);
        assertEquals(1, transpose[0][0]);
        assertEquals(5, transpose[0][1]);
        assertEquals(9, transpose[0][2]);
        assertEquals(13, transpose[0][3]);
        assertEquals(2, transpose[1][0]);
        assertEquals(6, transpose[1][1]);
        assertEquals(10, transpose[1][2]);
        assertEquals(14, transpose[1][3]);
        assertEquals(3, transpose[2][0]);
        assertEquals(7, transpose[2][1]);
        assertEquals(11, transpose[2][2]);
        assertEquals(15, transpose[2][3]);
        assertEquals(4, transpose[3][0]);
        assertEquals(8, transpose[3][1]);
        assertEquals(12, transpose[3][2]);
        assertEquals(16, transpose[3][3]);
    }

    @Test
    public void testTranspose_Test(){
        int[][] matrix = {{1,2,3},{4,5,6}};

        int[][] transpose = Main.transpose(matrix);

        assertEquals(1, transpose[0][0]);
        assertEquals(4, transpose[0][1]);
        assertEquals(2, transpose[1][0]);
        assertEquals(5, transpose[1][1]);
        assertEquals(3, transpose[2][0]);
        assertEquals(6, transpose[2][1]);
    }
}