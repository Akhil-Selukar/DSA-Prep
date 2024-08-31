package org.akhil;

public class Main {
    public static void main(String[] args) {
        String word1 = "abc";
        String word2 = "pqr";

        System.out.println(mergeAlternately(word1, word2));
    }

    public static String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int index = 0;

        while(index < word1.length() || index < word2.length()){
            if(index < word1.length()){
                sb.append(word1.charAt(index));
            }
            if(index < word2.length()){
                sb.append(word2.charAt(index));
            }
            index++;
        }

        return sb.toString();
    }
}