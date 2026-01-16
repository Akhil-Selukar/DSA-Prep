package org.akhil;

public class Main {
    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        int[] hFences = {2,3};
        int[] vFences = {2};

        Solution solution = new Solution();
        System.out.println(solution.maximizeSquareArea(m, n, hFences, vFences));
    }
}