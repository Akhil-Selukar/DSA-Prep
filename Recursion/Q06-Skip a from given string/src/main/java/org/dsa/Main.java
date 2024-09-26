package org.dsa;

public class Main {
    public static void main(String[] args) {
        String str = "banana";

        System.out.println(skipCharacter(str));
        System.out.println(skipCharacter_2(str));
    }

    // Approach 1 : using 2 arguments (1 is actual string and another is StringBuilder)
    protected static String skipCharacter(String str) {
        StringBuilder sb = new StringBuilder();

        return skipHelper(str, sb);
    }

    private static String skipHelper(String str, StringBuilder sb) {
        if(str.length()==0){
            return sb.toString();
        }
        if(str.charAt(0) != 'a') {
            sb.append(str.charAt(0));
        }
        return skipHelper(str.substring(1), sb);
    }

    // Approach 1 : Without using 2 arguments (i.e. StringBuilder)
    protected static String skipCharacter_2(String str) {
        if(str.length() == 0){
            return "";
        }
        if(str.charAt(0) != 'a'){
            return str.charAt(0)+skipCharacter_2(str.substring(1));
        } else {
            return skipCharacter(str.substring(1));
        }

    }
}