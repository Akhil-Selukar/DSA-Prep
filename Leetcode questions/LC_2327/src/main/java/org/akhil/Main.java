package org.akhil;

public class Main {
    public static void main(String[] args) {
        int n = 6;
        int delay = 2;
        int forget = 4;

        Solution solution = new Solution();
        System.out.println(solution.peopleAwareOfSecret(n, delay, forget));
    }
}