package org.akhil;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void TestGetConcatenation_EmptyArray() {
        int[] arr = {};
        assertEquals(0, Main.getConcatenation(arr).length);
    }

    @Test
    public void TestGetConcatenation_ArrayWithValues() {
        int[] arr = {1,2,3,4};
        assertEquals(8, Main.getConcatenation(arr).length);
        assertEquals(1, Main.getConcatenation(arr)[0]);
        assertEquals(1, Main.getConcatenation(arr)[4]);
        assertEquals(2, Main.getConcatenation(arr)[1]);
        assertEquals(2, Main.getConcatenation(arr)[5]);
        assertEquals(3, Main.getConcatenation(arr)[2]);
        assertEquals(3, Main.getConcatenation(arr)[6]);
        assertEquals(4, Main.getConcatenation(arr)[3]);
        assertEquals(4, Main.getConcatenation(arr)[7]);
    }
}