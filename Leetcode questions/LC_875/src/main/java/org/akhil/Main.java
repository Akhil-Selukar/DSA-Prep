package org.akhil;

public class Main {
    public static void main(String[] args) {
//        int[] piles = {3,6,7,11};
//        int h = 8;

//        int[] piles = {30,11,23,4,20};
//        int h = 5;

//        int[] piles = {30,11,23,4,20};
//        int h = 6;

        int[] piles = {805306368,805306368,805306368};
        int h = 1000000000;

        Solution solution = new Solution();
        System.out.println(solution.minEatingSpeed(piles, h));
    }
}