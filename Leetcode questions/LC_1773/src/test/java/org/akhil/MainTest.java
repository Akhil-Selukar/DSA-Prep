package org.akhil;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testCountMatches_Test1(){
        List<List<String>> items = new ArrayList<>();
        items.add(Main.generateItem("phone","blue","pixel"));
        items.add(Main.generateItem("computer","silver","lenovo"));
        items.add(Main.generateItem("phone","gold","iphone"));

        String ruleKey = "color";
        String ruleValue = "silver";

        assertEquals(1, Main.countMatches(items,ruleKey,ruleValue));
    }

    @Test
    public void testCountMatches_Test2(){
        List<List<String>> items = new ArrayList<>();
        items.add(Main.generateItem("phone","blue","pixel"));
        items.add(Main.generateItem("computer","silver","phone"));
        items.add(Main.generateItem("phone","gold","iphone"));

        String ruleKey = "type";
        String ruleValue = "phone";

        assertEquals(2, Main.countMatches(items,ruleKey,ruleValue));
    }
}