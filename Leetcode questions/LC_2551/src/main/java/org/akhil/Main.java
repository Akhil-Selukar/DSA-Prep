package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] weights = {1,3,5,1};
        int k = 2;

        Solution solution = new Solution();
        System.out.println(solution.putMarbles(weights, k));
    }
}