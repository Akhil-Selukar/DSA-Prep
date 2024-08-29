package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class MainTest {

    @Test
    public void testIsLongPressedName_Test1(){
        String name = "alex";
        String typed = "aaleex";

        assertTrue(Main.isLongPressedName(name, typed));
    }

    @Test
    public void testIsLongPressedName_Test2(){
        String name = "zeel";
        String typed = "zeezel";

        assertFalse(Main.isLongPressedName(name, typed));
    }

    @Test
    public void testIsLongPressedName_Test3(){
        String name = "saeed";
        String typed = "ssaaedd";

        assertFalse(Main.isLongPressedName(name, typed));
    }

    @Test
    public void testIsLongPressedName_Test4(){
        String name = "a";
        String typed = "aaaabcds";

        assertTrue(Main.isLongPressedName(name, typed));
    }

    @Test
    public void testIsLongPressedName_Test5(){
        String name = "sa";
        String typed = "aseseaas";

        assertFalse(Main.isLongPressedName(name, typed));
    }

    @Test
    public void testIsLongPressedName_Test6(){
        String name = "alex";
        String typed = "aaexxallex";

        assertTrue(Main.isLongPressedName(name, typed));
    }
}