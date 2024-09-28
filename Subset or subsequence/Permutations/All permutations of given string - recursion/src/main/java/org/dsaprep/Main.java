package org.dsaprep;

public class Main {
    public static void main(String[] args) {
        String str = "abc";

        permutations(str);
    }

    private static void permutations(String str) {
        permutationHelper("", str);
    }

    private static void permutationHelper(String ansString, String givenString) {
        if(givenString.isEmpty()){
            System.out.println(ansString);
            return;
        }
        char ch = givenString.charAt(0);

        for(int i=0; i<=ansString.length(); i++){
            String firstPart = ansString.substring(0,i);
            String secondPart = ansString.substring(i, ansString.length());
            permutationHelper(firstPart+ch+secondPart, givenString.substring(1));
        }
    }


}