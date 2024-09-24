package org.akhil;

public class Main {
    public static void main(String[] args) {
        String str = "geeksforgeeKs";

        System.out.println(firstUpperCase(str, 0, str.length()));
    }

    protected static char firstUpperCase(String str, int index, int length){
        if(index >= length){
            return 0;
        }

        if(Character.isUpperCase(str.charAt(index))){
            return str.charAt(index);
        } else {
            index++;
            return firstUpperCase(str, index, length);
        }
    }
}