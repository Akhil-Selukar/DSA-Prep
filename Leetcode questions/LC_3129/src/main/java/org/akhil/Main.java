package org.akhil;

public class Main {
    public static void main(String[] args) {
        int zero = 3;
        int one = 3;
        int limit = 2;

        Solution solution = new Solution();
        System.out.println(solution.numberOfStableArrays(zero, one, limit));
    }
}