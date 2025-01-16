package org.akhil;

public class Main {
    public static void main(String[] args) {
//        int[] height = {1,8,6,2,5,4,8,3,7};
//        int[] height = {1,1};
        int[] height = {1,4,2,5,3,1,1,2,1};

        Solution solution = new Solution();
        System.out.println(solution.maxArea(height));
    }
}