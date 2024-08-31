package org.akhil;

public class Main {
    public static void main(String[] args) {
        String s = "110";

        System.out.println(checkOnesSegment(s));
    }

    public static boolean checkOnesSegment(String s) {
        if(s.length()<2) return true;

        for(int i=1; i<s.length(); i++){
            if(s.charAt(i-1) == '0' && s.charAt(i) == '1'){
                return false;
            }
        }
        return true;
    }
}