package org.akhil;

public class Main {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";

        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        s = s.toLowerCase();
        for(int i =0; i<s.length(); i++){
            int num = s.charAt(i);
            if ((num >= 48 && num <= 57) || (97 <= num && num <= 122)){
                sb.append((char)num);
            }
        }
        return (sb.toString().equals(sb.reverse().toString()));
    }
}