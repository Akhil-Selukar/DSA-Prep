package org.dsaprep;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testSqrtByNewtonRaphson_Test1(){
        int n = 40;

        assertEquals(6.325023209103984, Main.sqrtByNewtonRaphson(n), 0.2);
    }


    @Test
    public void testSqrtByNewtonRaphson_Test2(){
        int n = 4;

        assertEquals(2.00000000000000, Main.sqrtByNewtonRaphson(n), 0.2);
    }

    @Test
    public void testSqrtByNewtonRaphson_Test3(){
        int n = 57;

        assertEquals(7.55000000000000, Main.sqrtByNewtonRaphson(n),0.2);
    }
}