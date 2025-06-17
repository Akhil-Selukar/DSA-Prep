package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] cookies = {8,15,10,20,8};
        int k = 2;

        Solution solution = new Solution();
        System.out.println(solution.distributeCookies(cookies, k));
    }
}