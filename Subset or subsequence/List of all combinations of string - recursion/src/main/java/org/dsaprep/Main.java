package org.dsaprep;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String str = "abc";

        System.out.println(printCombinations(str));
    }

    protected static List<String> printCombinations(String str) {

        return printCombinationsHelper("", str);
    }

    private static List<String> printCombinationsHelper(String ans, String str) {
        List<String> combinations = new ArrayList<>();
        if(str.isEmpty()){
            combinations.add(ans);
            return combinations;
        }

        char letter = str.charAt(0);
        List<String> leftSideCombinations = printCombinationsHelper(ans+letter, str.substring(1)); // one path of recursion tree with considering the letter in hand
        List<String> rightSideCombinations = printCombinationsHelper(ans, str.substring(1)); // another path of recursion tree without considering the letter in hand

        leftSideCombinations.addAll(rightSideCombinations);
        return leftSideCombinations;
    }
}