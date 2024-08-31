package org.akhil;

public class Main {
    public static void main(String[] args) {
        String word = "abcdefd";
        char ch = 'd';

        System.out.println(reversePrefix(word, ch));
    }

    public static String reversePrefix(String word, char ch) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while(index<word.length()){
            if(word.charAt(index) != ch){
                sb.append(word.charAt(index));
            } else {
                sb.append(word.charAt(index));
                break;
            }
            index++;
        }

        if(index == word.length()){
            return word;
        } else {
            return sb.reverse().toString().concat(word.substring(index+1));
        }
    }
}