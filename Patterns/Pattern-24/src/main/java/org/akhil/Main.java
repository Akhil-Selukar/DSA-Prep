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
            System.out.print("*");

            int spaces = i<n?i-1:2*(n-1)-i;
            for(int space=0; space<=spaces; space++){
                System.out.print(" ");
            }
            if(i!=0 && i !=2*n-1){
                System.out.print("*");
            } else {
                System.out.print(" ");
            }

            int spacesBetween = i<n?2*(n-1-i):2*(i-n);
            for(int space=0; space<=spacesBetween; space++){
                System.out.print(" ");
            }

            if(i!=0 && i !=2*n-1){
                System.out.print("*");
            } else {
                System.out.print(" ");
            }

            int spacesAfter = i<n?i-1:2*(n-1)-i;
            for(int space=0; space<=spacesAfter; space++){
                System.out.print(" ");
            }

            System.out.print("*");



            System.out.println();
        }
    }
}