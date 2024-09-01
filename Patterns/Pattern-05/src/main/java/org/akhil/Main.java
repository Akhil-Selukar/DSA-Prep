package org.akhil;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        printPattern(n);
    }

    private static void printPattern(int n) {
        for(int i=0; i<2*n; i++){
            int columns = i<=n?i:2*n-i;
            for(int j=0; j<columns; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}