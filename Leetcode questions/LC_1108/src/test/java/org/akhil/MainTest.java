package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testDefangIPaddr_Test1(){
        String address = "1.1.1.1";

        String ans = Main.defangIPaddr(address);
        String ans1 = Main.defangIPaddr1(address);

        assertEquals("1[.]1[.]1[.]1", ans);
        assertEquals("1[.]1[.]1[.]1", ans1);
    }

    @Test
    public void testDefangIPaddr_Test2(){
        String address = "255.100.50.0";

        String ans = Main.defangIPaddr(address);
        String ans1 = Main.defangIPaddr1(address);

        assertEquals("255[.]100[.]50[.]0", ans);
        assertEquals("255[.]100[.]50[.]0", ans1);
    }
}