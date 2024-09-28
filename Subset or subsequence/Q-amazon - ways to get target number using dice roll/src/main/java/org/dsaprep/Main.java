package org.dsaprep;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int target = 3;

        System.out.println(dice(target));
    }

    protected static List<String> dice(int target) {
//        diceHelper("", target);
        return diceHelperList("", target);
    }

//    private static void diceHelper(String processedString, int target) {
//        if(target == 0){
//            System.out.println(processedString);
//            return;
//        }
//        for(int i=1; i<=6 && i<=target; i++){
//            diceHelper(processedString+i, target-i);
//        }
//    }

    private static List<String> diceHelperList(String processedString, int target) {
        List<String> ans = new ArrayList<>();
        if(target == 0){
            ans.add(processedString);
            return ans;
        }
        for(int i=1; i<=6 && i<=target; i++){
            ans.addAll(diceHelperList(processedString+i, target-i));
        }
        return ans;
    }
}