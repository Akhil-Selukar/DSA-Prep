package org.akhil;

public class Main {
    public static void main(String[] args) {
        char[] tasks = {'A','A','A','B','B','B'};
        int n = 2;

//        char[] tasks = {'A','C','A','B','D','B'};
//        int n = 1;

        Solution solution = new Solution();
        System.out.println(solution.leastInterval(tasks, n));
    }
}