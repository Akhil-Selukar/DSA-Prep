package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[][] lcp = {{4,0,2,0},{0,3,0,1},{2,0,2,0},{0,1,0,1}};

        Solution solution = new Solution();
        System.out.println(solution.findTheString(lcp));
    }
}