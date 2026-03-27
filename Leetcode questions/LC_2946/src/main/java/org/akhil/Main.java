package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[][] mat = {{1,2,1,2},{5,5,5,5},{6,3,6,3}};
        int k = 2;

        Solution solution = new Solution();
        System.out.println(solution.areSimilar(mat, k));
    }
}