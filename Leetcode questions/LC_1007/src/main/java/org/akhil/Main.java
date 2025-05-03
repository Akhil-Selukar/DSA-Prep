package org.akhil;

public class Main {
    public static void main(String[] args) {
//        int[] tops = {2,1,2,4,2,2};
//        int[] bottoms = {5,2,6,2,3,2};

//        int[] tops = {3,5,1,2,3};
//        int[] bottoms = {3,6,3,3,4};

        int[] tops = {1,2,2,1,1,1,2,3};
        int[] bottoms = {2,1,1,2,2,2,1,3};

        Solution solution = new Solution();
        System.out.println(solution.minDominoRotations(tops, bottoms));
    }
}