package org.akhil;

public class Main {
    public static void main(String[] args) {
//        String[] strs = {"10","0001","111001","1","0"};
//        int m = 5;
//        int n = 3;

        String[] strs = {"10","0001","111001","1","0"};
        int m = 4;
        int n = 3;

        Solution solution = new Solution();
        System.out.println(solution.findMaxForm(strs, m, n));
    }
}