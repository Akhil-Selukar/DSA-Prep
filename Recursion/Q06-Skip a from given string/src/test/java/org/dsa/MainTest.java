package org.dsa;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testSkipCharacter_Test1(){
        String str = "banana";

        assertEquals("bnn", Main.skipCharacter(str));
    }

    @Test
    public void testSkipCharacter_2_Test1(){
        String str = "banana";

        assertEquals("bnn", Main.skipCharacter_2(str));
    }

    @Test
    public void testSkipCharacter_Test2(){
        String str = "bAnanA";

        assertEquals("bAnnA", Main.skipCharacter(str));
    }

    @Test
    public void testSkipCharacter_2_Test2(){
        String str = "bAnanA";

        assertEquals("bAnnA", Main.skipCharacter_2(str));
    }

    @Test
    public void testSkipCharacter_Test3(){
        String str = "a";

        assertEquals("", Main.skipCharacter(str));
    }

    @Test
    public void testSkipCharacter_2_Test3(){
        String str = "a";

        assertEquals("", Main.skipCharacter_2(str));
    }

    @Test
    public void testSkipCharacter_Test4(){
        String str = "";

        assertEquals("", Main.skipCharacter(str));
    }

    @Test
    public void testSkipCharacter_2_Test4(){
        String str = "";

        assertEquals("", Main.skipCharacter_2(str));
    }

    @Test
    public void testSkipCharacter_Test5(){
        String str = "AA";

        assertEquals("AA", Main.skipCharacter(str));
    }

    @Test
    public void testSkipCharacter_2_Test5(){
        String str = "AA";

        assertEquals("AA", Main.skipCharacter_2(str));
    }

    @Test
    public void testSkipCharacter_Test6(){
        String str = "ana";

        assertEquals("n", Main.skipCharacter(str));
    }

    @Test
    public void testSkipCharacter_2_Test6(){
        String str = "ana";

        assertEquals("n", Main.skipCharacter_2(str));
    }
}