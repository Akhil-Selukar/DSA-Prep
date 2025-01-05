package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] val = {6, 1, 7, 7};
        int[] wt = {1, 3, 4, 5};
        int capacity = 8;

//        int[] val = {6, 8, 7, 100};
//        int[] wt = {2, 3, 4, 5};
//        int capacity = 1;

//        int[] val = {1, 1};
//        int[] wt = {2, 1};
//        int capacity = 3;

        Solution solution = new Solution();
        System.out.println(solution.knapSack(val, wt, capacity));
    }
}