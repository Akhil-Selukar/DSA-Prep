package org.akhil;

public class Main {
    public static void main(String[] args) {
//        int[] differences = {1,-3,4};
//        int lower = 1, upper = 6;

//        int[] differences = {3,-4,5,1,-2};
//        int lower = -4, upper = 5;

        int[] differences = {4,-7,2};
        int lower = 3, upper = 6;

        Solution solution = new Solution();
        System.out.println(solution.numberOfArrays(differences, lower, upper));
    }
}