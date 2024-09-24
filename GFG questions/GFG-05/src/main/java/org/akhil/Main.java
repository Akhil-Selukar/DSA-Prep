package org.akhil;

public class Main {
    public static void main(String[] args) {
        String str = "abcd";

        System.out.println(lengthOfString(str));
    }

    protected static int lengthOfString(String str) {
        if(str.equals("")){
            return 0;
        }

        return 1+lengthOfString(str.substring(1));
    }
}