package org.akhil;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();

        printPattern(n);
    }

    private static void printPattern(int n) {
        for (int i = 0; i < n; i++) {
            for (int space = 0; space < n-1-i; space++) {
                System.out.print(" ");
            }
            System.out.print("*");
            if(i!=0 && i!=n-1){ // to print internal spaces we need to skip last and first row
                for(int space=0; space<2*i-1; space++){
                    System.out.print(" ");
                }
                System.out.print("*");
            }
            if(i==n-1){  // to print last row
                for(int star=0; star<2*i; star++){
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}