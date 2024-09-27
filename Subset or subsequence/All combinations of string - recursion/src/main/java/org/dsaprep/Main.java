package org.dsaprep;

public class Main {
    public static void main(String[] args) {
        String str = "abc";

        printCombinations(str);
    }

    private static void printCombinations(String str) {
        printCombinationsHelper("", str);
    }

    private static void printCombinationsHelper(String ans, String str) {
        if(str.isEmpty()){
            System.out.println(ans);
            return;
        }
        char letter = str.charAt(0);
        printCombinationsHelper(ans+letter, str.substring(1)); // one path of recursion tree with considering the letter in hand
        printCombinationsHelper(ans, str.substring(1)); // another path of recursion tree without considering the letter in hand
    }
}