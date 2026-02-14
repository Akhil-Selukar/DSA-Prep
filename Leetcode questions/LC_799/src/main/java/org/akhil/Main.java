package org.akhil;

public class Main {
    public static void main(String[] args) {
        int poured = 100000009;
        int query_row = 33;
        int query_glass = 17;

        Solution solution = new Solution();
        System.out.println(solution.champagneTower(poured, query_row, query_glass));
    }
}