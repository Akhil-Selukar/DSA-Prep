package org.akhil;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        printPattern(n);
    }

    private static void printPattern(int n) {
        for (int i = 0; i < 2 * n; i++) {
            int spaces = i < n ? i : 2 * n - 1 - i;
            int stars = i < n ? n - i : Math.abs(n - i - 1);
            for (int space = 0; space < spaces; space++) {
                System.out.print(" ");
            }
            for(int star=0; star<stars; star++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}