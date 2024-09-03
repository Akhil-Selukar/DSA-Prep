package org.akhil;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        printPattern(n);
    }

    private static void printPattern(int n) {
        for(int i=0; i<2*n-1; i++){
            int spaces = i<n? (n-1)-i: i-(n-1);
            int innerSpace = i<n? ((2*n-1)-(2*(n-i))):((2*n-1)+(2*(n-i))-4);

            for(int space = 0; space<spaces; space++){
                System.out.print(" ");
            }
            System.out.print("*");
            for(int space = 0; space<innerSpace; space++){
                System.out.print(" ");
            }

            if(i != 0 && i != 2*n-2){ // first and last row
                System.out.print("*");
            }
            System.out.println();
        }
    }
}