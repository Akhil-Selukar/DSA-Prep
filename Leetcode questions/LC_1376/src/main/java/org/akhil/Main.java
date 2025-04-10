package org.akhil;

public class Main {
    public static void main(String[] args) {
//        int n = 6;
//        int headID = 2;
//        int[] manager = {2,2,-1,2,2,2};
//        int[] informTime = {0,0,1,0,0,0};

        int n = 15;
        int headID = 0;
        int[] manager = {-1,0,0,1,1,2,2,3,3,4,4,5,5,6,6};
        int[] informTime = {1,1,1,1,1,1,1,0,0,0,0,0,0,0,0};

        Solution solution = new Solution();

        System.out.println(solution.numOfMinutes(n, headID,manager, informTime));
    }
}