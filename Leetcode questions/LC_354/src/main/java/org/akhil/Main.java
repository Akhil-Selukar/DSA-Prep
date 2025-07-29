package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};

        Solution solution = new Solution();
        System.out.println(solution.maxEnvelopes(envelopes));
    }
}