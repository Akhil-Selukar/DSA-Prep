package org.akhil;

public class Main {
    public static void main(String[] args) {
        int start = 1;
        int finish = 6000;
        int limit = 4;
        String s = "124";

        Solution solution = new Solution();
        System.out.println(solution.numberOfPowerfulInt(start, finish, limit, s));
    }
}