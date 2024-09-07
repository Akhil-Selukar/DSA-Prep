package org.akhil;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        printPattern(n);
    }

    private static void printPattern(int n){
        for(int i=1; i<2*n; i++){
            int stars = i<=n?i:(2*n)-i;
            for(int star=1;star<=stars; star++){
                System.out.print("*");
            }

            int spaces = i<=n?2*(n-i):2*(i-n);
            for(int space=1;space<=spaces;space++){
                System.out.print(" ");
            }

            for(int star=1;star<=stars; star++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

}