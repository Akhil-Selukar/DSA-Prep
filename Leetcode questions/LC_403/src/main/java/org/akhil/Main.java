package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] stones = {0,1,3,5,6,8,12,17};
//        int[] stones = {0,1,2,3,4,8,9,11};
//        int[] stones = {0,1,3,6,10,13,14};

        Solution solution = new Solution();
        System.out.println(solution.canCross(stones));
    }
}