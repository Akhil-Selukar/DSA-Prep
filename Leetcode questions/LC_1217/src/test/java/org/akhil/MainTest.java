package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testMinCostToMoveChips_Test1(){
        int[] position = {2,2,2,3,3};

        assertEquals(2, Main.minCostToMoveChips(position));
    }

    @Test
    public void testMinCostToMoveChips_Test2(){
        int[] position = {1,2,2,3,4,2,4,5,7,7};

        assertEquals(5, Main.minCostToMoveChips(position));
    }

    @Test
    public void testMinCostToMoveChips_Test3(){
        int[] position = {1};

        assertEquals(0, Main.minCostToMoveChips(position));
    }

    @Test
    public void testMinCostToMoveChips_Test4(){
        int[] position = {2};

        assertEquals(0, Main.minCostToMoveChips(position));
    }

    @Test
    public void testMinCostToMoveChips_Test5(){
        int[] position = {2,2,2,2,2,1};

        assertEquals(1, Main.minCostToMoveChips(position));
    }

    @Test
    public void testMinCostToMoveChips_Test6(){
        int[] position = {2,2,2,2,2};

        assertEquals(0, Main.minCostToMoveChips(position));
    }

    @Test
    public void testMinCostToMoveChips_Test7(){
        int[] position = {1,2,3,4,5,6,7,8,9,10,11,12,13};

        assertEquals(6, Main.minCostToMoveChips(position));
    }

    @Test
    public void testMinCostToMoveChips_Test8(){
        int[] position = {1,10000000};

        assertEquals(1, Main.minCostToMoveChips(position));
    }
}