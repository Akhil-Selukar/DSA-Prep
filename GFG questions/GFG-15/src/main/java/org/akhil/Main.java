package org.akhil;

public class Main {
    public static void main(String[] args) {
//        int capacity = 4;
//        int[] val = {1, 2, 3};
//        int[] wt = {4, 5, 1};

//        int capacity = 3;
//        int[] val = {1, 2, 3};
//        int[] wt = {4, 5, 6};

//        int capacity = 5;
//        int[] val = {10, 40, 30, 50};
//        int[] wt = {5, 4, 6, 3};

        int capacity = 7;
        int[] val = {10, 8, 6};
        int[] wt = {1, 7, 9};

        Solution solution = new Solution();
        System.out.println(solution.knapSack(capacity, val, wt));
    }
}