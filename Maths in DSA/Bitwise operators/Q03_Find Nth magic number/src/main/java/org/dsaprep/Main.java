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

// To calculate the complexity of above program. The iterations of loop depends upon the number of digits in binary form of given number.
// we can simply calculate the number of digits in binary form of given decimal number by using formula (int)((lon(n)/log(2))+1)
//
// Actual formula is
// Number of digits in base b = (int)((log(N)/log(b)) +1)
//
// Hence the numbre of times loop will run and N has logerathmic relation so the time complexity for above code is O(N) = log(N).