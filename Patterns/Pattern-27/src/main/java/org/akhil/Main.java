package org.akhil;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        printPattern(n);
    }

    private static void printPattern(int n) {
        int start = 1;
        int end = n*(n+1);
        for(int i=1; i<=n; i++){
            // print spaces
            for(int space=0; space<2*(i-1); space++){
                System.out.print(" ");
            }
            // print first half
            for(int j=0; j<(n+1-i); j++){
                System.out.print(start++ +" ");
            }
            // print second half
            int num = end - (n+1-i);
            end = num;
            for(int j=0; j<(n+1-i); j++){
                System.out.print(++num + " ");
            }
            System.out.println();
        }
    }
}