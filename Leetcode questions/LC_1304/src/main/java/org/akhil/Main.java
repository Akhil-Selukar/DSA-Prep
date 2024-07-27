package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int n = 6;

        System.out.println(Arrays.toString(sumZero(n)));
    }
    public static int[] sumZero(int n) {
        int[] ans = new int[n];

        if(n%2 != 0){
            for(int i=0, j=n-1; i<n/2 && j>n/2; i++,j--){
                ans[i] = -1*(n/2-i);
                ans[j] = (n/2-i);
            }
        } else {
            for(int i=0, j=n-1; i<=n/2 && j>=n/2; i++,j--){
                ans[i] = -1*(n/2-i);
                ans[j] = (n/2-i);
            }
        }
        return ans;
    }
}