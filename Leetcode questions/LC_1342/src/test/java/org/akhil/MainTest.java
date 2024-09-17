package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {
    @Test
    public void testNumberOfSteps_Test1(){
        int num = 14;
        assertEquals(6, Main.numberOfSteps(num));
    }

    @Test
    public void testNumberOfSteps_Test2(){
        int num = 84;
        assertEquals(9, Main.numberOfSteps(num));
    }

    @Test
    public void testNumberOfSteps_Test3(){
        int num = 0;
        assertEquals(0, Main.numberOfSteps(num));
    }

    @Test
    public void testNumberOfSteps_Test4(){
        int num = 1;
        assertEquals(1, Main.numberOfSteps(num));
    }

    @Test
    public void testNumberOfSteps_Test5(){
        int num = 2;
        assertEquals(2, Main.numberOfSteps(num));
    }

    @Test
    public void testNumberOfSteps_Test6(){
        int num = 17;
        assertEquals(6, Main.numberOfSteps(num));
    }

    @Test
    public void testNumberOfSteps_Test7(){
        int num = 9901;
        assertEquals(21, Main.numberOfSteps(num));
    }

    @Test
    public void testNumberOfSteps_Test8(){
        int num = 990;
        assertEquals(17, Main.numberOfSteps(num));
    }

    @Test
    public void testNumberOfSteps_Test9(){
        int num = 111;
        assertEquals(12, Main.numberOfSteps(num));
    }
}