package org.akhil;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(isPowerOfTwo(n));
    }

    public static boolean isPowerOfTwo(int n) {
        if(n == 1){
            return true;
        }
        if(n == 0){
            return false;
        }
        return ((n%2 == 0) && isPowerOfTwo(n/2));
    }
}