package org.akhil;

public class Main {
    public static void main(String[] args) {
        String name = "alex";
        String typed = "aaleex";
//        String name = "zeel";
//        String typed = "zeezel";

        System.out.println(isLongPressedName(name, typed));
    }

    public static boolean isLongPressedName(String name, String typed) {
//        ############# Even though below code satisfy more testcases here but not accepted in leetcode.
//        int nameIndex = 0;
//        int typedIndex = 0;
//
//        while(nameIndex < name.length() && typedIndex < typed.length()){
//            if(name.charAt(nameIndex) == typed.charAt(typedIndex)){
//                nameIndex++;
//                typedIndex++;
//            } else if(name.charAt(Math.max(nameIndex - 1, 0)) == typed.charAt(typedIndex)){
//                typedIndex++;
//            } else {
//                return false;
//            }
//        }
//        return true;

//        ############# Even though 2 testcases are failing here this is accepted in leetcode ###########

        if (name.charAt(0) != typed.charAt(0)) return false;
        int i = 1;
        int j = 1;
        while (i < typed.length()) {
            if (j < name.length() && typed.charAt(i) == name.charAt(j)) {
                i++;
                j++;
            }
            else if (typed.charAt(i) == name.charAt(j - 1)) i++;
            else return false;
        }
        return j == name.length();
    }
}