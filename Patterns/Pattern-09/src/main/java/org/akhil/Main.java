package org.akhil;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        printPattern(n);
    }

    private static void printPattern(int n) {
        for(int i=0; i<n; i++){
            for(int spaces=0; spaces<i; spaces++){
                System.out.print(" ");
            }
            for(int stars=0; stars<2*n-1-(2*i); stars++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}