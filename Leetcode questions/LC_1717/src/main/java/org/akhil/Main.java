package org.akhil;

public class Main {
    public static void main(String[] args) {
//        String s = "cdbcbbaaabab";
//        int x = 4;
//        int y = 5;

        String s = "aabbaaxybbaabb";
        int x = 5;
        int y = 4;

        Solution solution = new Solution();
        System.out.println(solution.maximumGain(s, x, y));
    }
}