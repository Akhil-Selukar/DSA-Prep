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
            for(int space=0; space<n-1-i; space++){
                System.out.print(" ");
            }
            for(int star=0; star<i+1; star++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}