package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[][] img1 = {{1,1,0},{0,1,0},{0,1,0}};
        int[][] img2 = {{0,0,0},{0,1,1},{0,0,1}};

        Solution solution = new Solution();
        System.out.println(solution.largestOverlap(img1, img2));
    }
}