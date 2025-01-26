package org.akhil;

public class Main {
    public static void main(String[] args) {
        String[] tokens = {"2","1","+","3","*"};

        Solution solution = new Solution();
        System.out.println(solution.evalRPN(tokens));
    }
}