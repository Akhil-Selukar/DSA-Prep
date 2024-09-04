package org.akhil;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        printPattern(n);
    }

    private static void printPattern(int n){
        for(int i=1; i<=n; i++){
            if(i != 1 && i != n){
                System.out.print("*  *");
            } else {
                for(int star=1; star<=4; star++){
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}