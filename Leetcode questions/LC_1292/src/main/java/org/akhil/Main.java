package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[][]mat = {{1,1,3,2,4,3,2},{1,1,3,2,4,3,2},{1,1,3,2,4,3,2}};
        int threshold = 4;

        Solution solution = new Solution();
        System.out.println(solution.maxSideLength(mat, threshold));
    }
}