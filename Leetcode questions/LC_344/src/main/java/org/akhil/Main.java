package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
//        reverseString(s);
        reverseStringWithoutRecursion(s);
        System.out.println(Arrays.toString(s));
    }

    public static void reverseString(char[] s) {
        reverseHelper(s, 0);
    }

    private static void reverseHelper(char[] s, int index) {
        if(index > (s.length - 1 - index)){
            return;
        }
        swap(s,index, s.length - 1 - index);
        reverseHelper(s, index+1);
    }

    private static void swap(char[] s, int firstIndex, int secondIndex){
        char temp = s[firstIndex];
        s[firstIndex] = s[secondIndex];
        s[secondIndex] = temp;
    }

//    Above can be solved faster using two pointer method.

    public static void reverseStringWithoutRecursion(char[] s) {
        int leftPointer = 0;
        int rightPointer = s.length-1-leftPointer;

        while(leftPointer < rightPointer){
            char temp = s[leftPointer];
            s[leftPointer] = s[rightPointer];
            s[rightPointer] = temp;
            leftPointer++;
            rightPointer--;
        }
    }
}