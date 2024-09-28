package org.dsaprep;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String str = "abcd";

        System.out.println(permutations(str));
    }

    protected static List<String> permutations(String str) {
        return permutationHelper("", str);
    }

    private static List<String> permutationHelper(String ansString, String givenString) {
        List<String> ans = new ArrayList<>();
        if(givenString.isEmpty()){
            ans.add(ansString);
            return ans;
        }

        char ch = givenString.charAt(0);
        for(int i=0; i<=ansString.length(); i++){
            String firstHalf = ansString.substring(0,i);
            String secondHalf = ansString.substring(i,ansString.length());
            ans.addAll(permutationHelper(firstHalf+ch+secondHalf, givenString.substring(1)));
        }
        return ans;
    }
}