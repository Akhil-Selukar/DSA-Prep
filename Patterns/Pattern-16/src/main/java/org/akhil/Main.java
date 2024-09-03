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
            // Print spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print("  ");
            }

            // print values
            int value = 1;
            for (int j = 1; j <= i; j++) {
                System.out.print(value + "   ");
                value = value * (i - j) / j;
            }

            System.out.println();
        }
    }
}