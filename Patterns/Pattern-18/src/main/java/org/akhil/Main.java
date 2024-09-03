package org.akhil;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        printPatttern(n);
    }

    private static void printPatttern(int n) {
        for(int i=1; i<=2*n; i++){
            // print stars
            int stars = i<=n?n+1-i:i-n;
            for(int star=1; star<=stars; star++){
                System.out.print("*");
            }

            // print spaces
            int spaces = i<=n?(2*i)-2:2*(2*n-i);
            for(int space=0;space<spaces; space++){
                System.out.print(" ");
            }

            // print remaining stars
            for(int star=1; star<=stars; star++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}