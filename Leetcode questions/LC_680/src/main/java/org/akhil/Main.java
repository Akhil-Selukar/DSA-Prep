package org.akhil;

public class Main {
    public static void main(String[] args) {
        String s = "abca";

        System.out.println(validPalindrome(s));
    }

    // Below is not the time efficient solution
    public static boolean validPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                if (i != j) {
                    sb.append(s.charAt(j));
                }
            }
            if (sb.toString().equals(sb.reverse().toString())) {
                return true;
            }
        }
        return false;
    }

    //    alternative approach
    public static boolean validPalindrome1(String s) {
        if(s.length() < 3) { // if length of string is 2 then removing 1 element will left only 1 element hence true.
            return true;
        }

        int startIndex = 0;
        int endIndex = s.length()-1;

        while(startIndex < endIndex){
            if(s.charAt(startIndex) == s.charAt(endIndex)){
                startIndex++;
                endIndex--;
            } else {
                return checkPalindrome(s, startIndex+1,endIndex) || checkPalindrome(s, startIndex, endIndex-1); // we are at else part because either element at startIndex or element at endIndex is not following the palindrome condition, so we have to check by removing them individually.
            }
        }
        return true;
    }

    public static boolean checkPalindrome(String s, int startIndex, int endIndex){
        while(startIndex<endIndex){
            if(s.charAt(startIndex) != s.charAt(endIndex)){
                return false;   // we are at this method because 1 element was not matching/satisfying palindrome condition hence if any other such element found then we can directly return false;
            }
            startIndex++;
            endIndex--;
        }
        return true;
    }
}