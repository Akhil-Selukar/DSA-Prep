package org.akhil;

public class Main {
    public static void main(String[] args) {
        String s = "5F3Z-2e-9-w";
        int k = 4;

//        String s = "2-5g-3-J";
//        int k = 2;

        Solution solution = new Solution();
        System.out.println(solution.licenseKeyFormatting(s, k));
    }
}