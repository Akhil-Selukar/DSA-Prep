package org.akhil;

public class Main {
    public static void main(String[] args) {
        int n = 3;
        int[][] trust = {{1,3},{2,3}};

//        int n = 2;
//        int[][] trust = {{1,2}};

//        int n = 3;
//        int[][] trust = {{1,3},{2,3},{3,1}};

        Solution solution = new Solution();
        System.out.println(solution.findJudge(n, trust));
    }
}