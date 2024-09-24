package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testReverseString_Test1(){
        char[] s = {'h','e','l','l','o'};
        Main.reverseString(s);

        assertEquals('o', s[0]);
        assertEquals('l', s[1]);
        assertEquals('l', s[2]);
        assertEquals('e', s[3]);
        assertEquals('h', s[4]);
    }

    @Test
    public void testReverseString_Test2(){
        char[] s = {'H','a','n','n','a','h'};
        Main.reverseString(s);

        assertEquals('h', s[0]);
        assertEquals('a', s[1]);
        assertEquals('n', s[2]);
        assertEquals('n', s[3]);
        assertEquals('a', s[4]);
        assertEquals('H', s[5]);
    }

    @Test
    public void testReverseString_Test3(){
        char[] s = {'H','h'};
        Main.reverseString(s);

        assertEquals('h', s[0]);
        assertEquals('H', s[1]);
    }

    @Test
    public void testReverseString_Test4(){
        char[] s = {'a'};
        Main.reverseString(s);

        assertEquals('a', s[0]);
    }

    @Test
    public void testReverseString_Test5(){
        char[] s = {'H','a','h','a'};
        Main.reverseString(s);

        assertEquals('a', s[0]);
        assertEquals('h', s[1]);
        assertEquals('a', s[2]);
        assertEquals('H', s[3]);
    }

    @Test
    public void testReverseStringWithoutRecursion_Test1(){
        char[] s = {'h','e','l','l','o'};
        Main.reverseStringWithoutRecursion(s);

        assertEquals('o', s[0]);
        assertEquals('l', s[1]);
        assertEquals('l', s[2]);
        assertEquals('e', s[3]);
        assertEquals('h', s[4]);
    }

    @Test
    public void testReverseStringWithoutRecursion_Test2(){
        char[] s = {'H','a','n','n','a','h'};
        Main.reverseStringWithoutRecursion(s);

        assertEquals('h', s[0]);
        assertEquals('a', s[1]);
        assertEquals('n', s[2]);
        assertEquals('n', s[3]);
        assertEquals('a', s[4]);
        assertEquals('H', s[5]);
    }

    @Test
    public void testReverseStringWithoutRecursion_Test3(){
        char[] s = {'H','h'};
        Main.reverseStringWithoutRecursion(s);

        assertEquals('h', s[0]);
        assertEquals('H', s[1]);
    }

    @Test
    public void testReverseStringWithoutRecursion_Test4(){
        char[] s = {'a'};
        Main.reverseStringWithoutRecursion(s);

        assertEquals('a', s[0]);
    }

    @Test
    public void testReverseStringWithoutRecursion_Test5(){
        char[] s = {'H','a','h','a'};
        Main.reverseStringWithoutRecursion(s);

        assertEquals('a', s[0]);
        assertEquals('h', s[1]);
        assertEquals('a', s[2]);
        assertEquals('H', s[3]);
    }
}