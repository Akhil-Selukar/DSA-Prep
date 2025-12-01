package org.akhil;

public class Main {
    public static void main(String[] args) {
        int n = 2;
        int[] batteries = {3,3,3};

        Solution solution = new Solution();
        System.out.println(solution.maxRunTime(n, batteries));
    }
}