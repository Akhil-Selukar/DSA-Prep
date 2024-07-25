package org.akhil;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MainTest {

    @Test
    public void testPangram_Success(){
        String str = "thequickbrownfoxjumpsoverthelazydog";

        assertTrue(Main.checkIfPangram(str));
    }

    @Test
    public void testPangram_Faile(){
        String str = "helloworld";

        assertFalse(Main.checkIfPangram(str));
    }

    @Test
    public void testPangram_Faile_1(){
        String str = "thequickbrown=oxjumpsoverthelazydog";

        assertFalse(Main.checkIfPangram(str));
    }

    @Test
    public void testPangram_Faile_2(){
        String str = "onrcsnlxckptsxffbyswujpamfltvmdoxovggepknmtacrjkkorjgvgtgaiaudspnpxkwikevmjeephhiyvnoymjwjfopovscbefecnoytjxfwasabwohqujwowmakpyuuqvgfab";

        assertFalse(Main.checkIfPangram(str));
    }

    @Test
    public void testPangram_Faile_3(){
        String str = "bcdefghijklmnopqrstuvwxyz@";

        assertFalse(Main.checkIfPangram(str));
    }

    @Test
    public void testPangram_Faile_4(){
        String str = "AbcDefghijklmnopqrstuvwxyz@";

        assertFalse(Main.checkIfPangram(str));
    }

    @Test
    public void testPangram_Faile_5(){
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        assertFalse(Main.checkIfPangram(str));
    }
}