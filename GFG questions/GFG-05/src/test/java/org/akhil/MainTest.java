package org.akhil;

import org.junit.Test;
import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void testLengthOfString_Test1(){
        String str = "abcd";

        assertEquals(4, Main.lengthOfString(str));
    }

    @Test
    public void testLengthOfString_Test2(){
        String str = "";

        assertEquals(0, Main.lengthOfString(str));
    }

    @Test
    public void testLengthOfString_Test3(){
        String str = "a";

        assertEquals(1, Main.lengthOfString(str));
    }

    @Test
    public void testLengthOfString_Test4(){
        String str = "aabb";

        assertEquals(4, Main.lengthOfString(str));
    }

    @Test
    public void testLengthOfString_Test5(){
        String str = "Hello world";

        assertEquals(11, Main.lengthOfString(str));
    }
}