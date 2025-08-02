package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] basket1 = {4,2,2,2};
        int[] basket2 = {1,4,1,2};

//        int[] basket1 = {2,3,4,1};
//        int[] basket2 = {3,2,5,1};

//        int[] basket1 = {4,4,4,4,3};
//        int[] basket2 = {5,5,5,5,3};

        Solution solution = new Solution();
        System.out.println(solution.minCost(basket1, basket2));
    }
}