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
            for(int spaces = 0; spaces<i; spaces++){
                System.out.print(" ");
            }
            for(int star = 0; star<n-i;star++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}