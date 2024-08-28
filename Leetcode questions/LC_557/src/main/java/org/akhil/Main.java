package org.akhil;

public class Main {
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";

        System.out.println(reverseWords(s));
        System.out.println(reverseWords1(s));
    }

    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] words = s.split(" ");

        for(String word:words){
            for(int i=word.length()-1; i>=0; i--){
                sb.append(word.charAt(i));
            }
            sb.append(" ");
        }
        return sb.toString().strip();
    }

    public static String reverseWords1(String s) {
        StringBuilder sb = new StringBuilder();
        String[] words = s.split(" ");

        for(String word:words){
            StringBuilder reverse = new StringBuilder(word).reverse();
            sb.append(reverse).append(" ");
        }
        return sb.toString().strip();
    }
}