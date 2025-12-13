package org.akhil;

public class Main {
    public static void main(String[] args) {
        String[] code = {"SAVE20","","PHARMA5","SAVE@20"};
        String[] businessLine = {"restaurant","grocery","pharmacy","restaurant"};
        boolean[] isActive = {true,true,true,true};

        Solution solution = new Solution();
        System.out.println(solution.validateCoupons(code, businessLine, isActive));
    }
}