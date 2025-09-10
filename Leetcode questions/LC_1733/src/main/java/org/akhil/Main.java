package org.akhil;

public class Main {
    public static void main(String[] args) {
        int n = 3;
        int[][] languages = {{2},{1,3},{1,2},{3}};
        int[][] friendships = {{1,4},{1,2},{3,4},{2,3}};

        Solution solution = new Solution();
        System.out.println(solution.minimumTeachings(n, languages, friendships));
    }
}