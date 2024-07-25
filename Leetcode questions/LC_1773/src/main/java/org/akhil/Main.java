package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<List<String>> items = new ArrayList<>();
        items.add(generateItem("phone","blue","pixel"));
        items.add(generateItem("computer","silver","lenovo"));
        items.add(generateItem("phone","gold","iphone"));

        String ruleKey = "color";
        String ruleValue = "silver";

        System.out.println(countMatches(items, ruleKey, ruleValue));
    }

    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;

        for(List<String> item:items){
            switch (ruleKey){
                case "type":
                    if(item.get(0).equalsIgnoreCase(ruleValue))
                        count++;
                    break;
                case "color":
                    if(item.get(1).equalsIgnoreCase(ruleValue))
                        count++;
                    break;
                case "name":
                    if(item.get(2).equalsIgnoreCase(ruleValue))
                        count++;
                    break;
            }
        }
        return count;
    }

     static List<String> generateItem(String type, String color, String name) {
        List<String> itemDetails = new ArrayList<>();
        itemDetails.add(type);
        itemDetails.add(color);
        itemDetails.add(name);

        return itemDetails;
    }
}