package org.akhil;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        printPattern(n);
    }

    private static void printPattern(int n) {
        for(int row=1; row<2*n; row++){
            for(int col=1; col<2*n; col++){
                int num = (n+1) - Math.min(Math.min(row, col), Math.min(((2*n)-row), ((2*n)-col))); // (n+1) - Min of distance from all 4 sides.
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }
}