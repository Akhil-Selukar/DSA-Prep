package org.akhil;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testRestoreString_Test1() {
        String s = "codeleet";
        int[] indices = {4, 5, 6, 7, 0, 2, 1, 3};

        assertEquals("leetcode", Main.restoreString(s, indices));
    }

    @Test
    public void testRestoreString_Test2() {
        String s = "abc";
        int[] indices = {0, 1, 2};

        assertEquals("abc", Main.restoreString(s, indices));
    }
}