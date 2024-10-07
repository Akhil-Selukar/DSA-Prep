package org.dsaprep;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        System.out.println(isPowerOfTwo(n));
    }

    protected static boolean isPowerOfTwo(int n) {
        if(n==1) return false;
        int result = n &(n-1);
        return result == 0;
    }
}