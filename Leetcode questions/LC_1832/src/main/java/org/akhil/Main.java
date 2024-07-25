package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String str = "onrcsnlxckptsxffbyswujpamfltvmdoxovggepknmtacrjkkorjgvgtgaiaudspnpxkwikevmjeephhiyvnoymjwjfopovscbefecnoytjxfwasabwohqujwowmakpyuuqvgfab";
        System.out.println(checkIfPangram(str));
    }

    public static boolean checkIfPangram(String str){
        int[] arr = str.chars().distinct().toArray();
        Arrays.sort(arr);
        if(arr.length < 26){
            return false;
        }
        for(int i=0;i<arr.length; i++){
            if(arr[i]%97 != i)
                return false;
        }
        return true;
    }
}