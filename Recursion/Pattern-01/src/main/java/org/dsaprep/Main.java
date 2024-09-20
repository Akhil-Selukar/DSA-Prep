package org.dsaprep;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        printPattern(n);
    }

    private static void printPattern(int n) {
        draw(n, 0);
    }

    private static void draw(int rowIndex, int columnIndex) {
        if(rowIndex==0){
            return;
        }
        if(columnIndex<rowIndex){
            System.out.print("*");
            draw(rowIndex, columnIndex+1);
        } else {
            System.out.println();
            draw(rowIndex - 1, 0);
        }
    }
}