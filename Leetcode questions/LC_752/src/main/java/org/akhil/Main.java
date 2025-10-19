package org.akhil;

public class Main {
    public static void main(String[] args) {
        String[] deadends = {"0201","0101","0102","1212","2002"};
        String target = "0202";

        Solution solution = new Solution();
        System.out.println(solution.openLock(deadends, target));
    }
}