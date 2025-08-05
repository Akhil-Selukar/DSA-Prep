package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] fruits = {4,2,5};
        int[] baskets = {3,5,4};

        Solution solution = new Solution();
        System.out.println(solution.numOfUnplacedFruits(fruits, baskets));
    }
}