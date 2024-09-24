package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testFirstUpperCase_Test1(){
        String str = "geeksforgeeKs";

        assertEquals('K', Main.firstUpperCase(str, 0, str.length()));
    }

    @Test
    public void testFirstUpperCase_Test2(){
        String str = "geeksforgeekS";

        assertEquals('S', Main.firstUpperCase(str, 0, str.length()));
    }

    @Test
    public void testFirstUpperCase_Test3(){
        String str = "geekSforgeeKs";

        assertEquals('S', Main.firstUpperCase(str, 0, str.length()));
    }

    @Test
    public void testFirstUpperCase_Test4(){
        String str = "GeeksforgeeKs";

        assertEquals('G', Main.firstUpperCase(str, 0, str.length()));
    }

    @Test
    public void testFirstUpperCase_Test5(){
        String str = "gEEKSforgeeKs";

        assertEquals('E', Main.firstUpperCase(str, 0, str.length()));
    }

    @Test
    public void testFirstUpperCase_Test6(){
        String str = "geeksforgeeks";

        assertEquals(0, Main.firstUpperCase(str, 0, str.length()));
    }
}