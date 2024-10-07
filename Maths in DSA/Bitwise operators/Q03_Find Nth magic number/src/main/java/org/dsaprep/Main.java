package org.dsaprep;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(getMagicNumber(n));
    }

    protected static int getMagicNumber(int n) {
        int power = 1;
        int num = 0;
        while(n>0){
            int lsb = n&1;      // If we and 1 with any bit it gives us the same bit. Here we want LSB, so we are using & 1 with only LSB of N.
            num = (int) (num+(lsb*Math.pow(5,power)));
            power++;
            n = n>>1;     // LSB is consumed above so we have to shift the second bit to LSB which means we have to shift right bu 1 bit.
        }
        return num;
    }
}