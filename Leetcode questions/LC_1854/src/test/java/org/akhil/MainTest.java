package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testMaximumPopulation_Test1(){
        int[][] logs = {{1950,1961},{1960,1971},{1970,1981}};

        assertEquals(1960, Main.maximumPopulation(logs));
    }

    @Test
    public void testMaximumPopulation_Test2(){
        int[][] logs = {{1950,1961},{1960,1965},{1963,1970}};

        assertEquals(1960, Main.maximumPopulation(logs));
    }

    @Test
    public void testMaximumPopulation_Test3(){
        int[][] logs = {{1993,1999},{2000,2010}};

        assertEquals(1993, Main.maximumPopulation(logs));
    }

    @Test
    public void testMaximumPopulation2_Test1(){
        int[][] logs = {{1950,1961},{1960,1971},{1970,1981}};

        assertEquals(1960, Main.maximumPopulation2(logs));
    }

    @Test
    public void testMaximumPopulation2_Test2(){
        int[][] logs = {{1950,1961},{1960,1965},{1963,1970}};

        assertEquals(1960, Main.maximumPopulation2(logs));
    }

    @Test
    public void testMaximumPopulation2_Test3(){
        int[][] logs = {{1993,1999},{2000,2010}};

        assertEquals(1993, Main.maximumPopulation2(logs));
    }
}