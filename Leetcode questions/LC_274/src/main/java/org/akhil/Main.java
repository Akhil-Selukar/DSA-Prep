package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] citations = {3,0,6,1,5};

        Solution solution = new Solution();
        System.out.println(solution.hIndex(citations));
    }
}