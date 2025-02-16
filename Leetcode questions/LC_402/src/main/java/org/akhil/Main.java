package org.akhil;

public class Main {
    public static void main(String[] args) {
//        String num = "001432219";
//        int k = 3;

//        String num = "10";
//        int k = 2;

//        String num = "9";
//        int k = 1;

//        String num = "112";
//        int k = 1;

        String num = "1234567890";
        int k = 9;

        Solution solution = new Solution();
        System.out.println(solution.removeKdigits(num, k));
    }
}