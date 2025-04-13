package org.dsaprep;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.myPower(2,3));
        System.out.println(solution.myPower(2,-3));
        System.out.println(solution.myPower(2,0));
        System.out.println(solution.myPower(2,1));
        System.out.println(solution.myPower(-2,0));
        System.out.println(solution.myPower(-2,2));
        System.out.println(solution.myPower(-2,3));
        System.out.println(solution.myPower(-2,-3));
    }
}