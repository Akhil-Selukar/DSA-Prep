package org.akhil;

public class Main {
    public static void main(String[] args) {
        String s = "is2 sentence4 This1 a3";

        System.out.println(sortSentence(s));
        System.out.println(sortSentence1(s));
    }

    public static String sortSentence(String s) {
        String[] words = s.split(" ");
        String[] ans = new String[words.length];
        StringBuilder sb = new StringBuilder();

        for(String word:words){
            int index = Character.getNumericValue(word.charAt(word.length()-1));
            String val = word.substring(0, word.length()-1);
            ans[index-1] = val;
        }

        for(int i=0; i<ans.length; i++){
            sb.append(ans[i]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    // without using StringBuilder

    public static String sortSentence1(String s) {
        String[] words = s.split(" ");
        String[] ans = new String[words.length];

        for(String word:words){
            int index = Character.getNumericValue(word.charAt(word.length()-1));
            String val = word.substring(0, word.length()-1);
            ans[index-1] = val;
        }

        return String.join(" ", ans);
    }
}