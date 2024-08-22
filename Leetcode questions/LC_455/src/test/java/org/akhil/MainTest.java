package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testFindContentChildren_Test1(){
        int[] g = {1,2,3};
        int[] s = {1,1,3};

        assertEquals(2, Main.findContentChildren(g,s));
    }

    @Test
    public void testFindContentChildren_Test2(){
        int[] g = {};
        int[] s = {1,1,3};

        assertEquals(0, Main.findContentChildren(g,s));
    }

    @Test
    public void testFindContentChildren_Test3(){
        int[] g = {1,2,3};
        int[] s = {};

        assertEquals(0, Main.findContentChildren(g,s));
    }

    @Test
    public void testFindContentChildren_Test4(){
        int[] g = {2,3};
        int[] s = {1,1,1};

        assertEquals(0, Main.findContentChildren(g,s));
    }

    @Test
    public void testFindContentChildren_Test5(){
        int[] g = {6,3,2,2};
        int[] s = {2,1,3,7,1};

        assertEquals(3, Main.findContentChildren(g,s));
    }
}