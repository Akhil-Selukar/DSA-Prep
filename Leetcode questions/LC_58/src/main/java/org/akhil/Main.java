package org.akhil;

public class Main {
    public static void main(String[] args) {
        String s = "   fly me   to   the moon  ";

        System.out.println(lengthOfLastWord(s));
    }

    public static int lengthOfLastWord(String s) {
        s = s.strip();
        System.out.println(s);
        int count = 0;
        for(int i=s.length()-1; i>=0;i--){
            if(s.charAt(i) != ' '){
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}