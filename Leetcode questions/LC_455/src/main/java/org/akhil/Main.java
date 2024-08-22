package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] g = {1,2,3};
        int[] s = {1,1,3};

//        int[] g = {1,2};
//        int[] s = {1,2,3};

        System.out.println(findContentChildren(g, s));
    }

    public static int findContentChildren(int[] g, int[] s) {
        int count = 0;

        if(g.length == 0 || s.length == 0){
            return count;
        }

        Arrays.sort(g);
        Arrays.sort(s);

        int cookiePointer = s.length-1;
        int childPointer = g.length-1;

        while(cookiePointer >=0 && childPointer >=0){
            if(s[cookiePointer] >= g[childPointer]){
                cookiePointer--;
                childPointer--;
                count++;
            } else{
                childPointer--;
            }
        }
        return count;
    }
}