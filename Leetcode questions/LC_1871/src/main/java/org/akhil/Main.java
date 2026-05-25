package org.akhil;

public class Main {
    public static void main(String[] args) {
//        String s = "00111010";
//        int minJump = 3;
//        int maxJump = 5;

        String s = "011010";
        int minJump = 2;
        int maxJump = 3;

        Solution solution = new Solution();
        System.out.println(solution.canReach(s, minJump, maxJump));
    }
}