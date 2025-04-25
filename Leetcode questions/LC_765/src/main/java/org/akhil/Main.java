package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] row = {5,4,2,6,3,1,0,7};
//        int[] row = {0,2,1,3};

        Solution solution = new Solution();

        System.out.println(solution.minSwapsCouples(row));
    }
}