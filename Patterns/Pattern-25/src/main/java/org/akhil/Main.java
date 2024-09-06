package org.akhil;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        printPattern(n);
    }

    private static void printPattern(int n) {
        for (int i = 1; i <= n; i++) {
            //print spaces
            for (int space = 1; space <= (n - i); space++) {
                System.out.print(" ");
            }
            System.out.print("*");
            for (int space = 1; space <= (n - 2); space++) {
                if (i != 1 && i != n) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.print("*");
            System.out.println();
        }
    }
}