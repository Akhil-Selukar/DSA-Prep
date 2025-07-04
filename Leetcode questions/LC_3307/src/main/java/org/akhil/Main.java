package org.akhil;

public class Main {
    public static void main(String[] args) {
//        int k = 5;
//        int[] operations = {0,0,0};

        int k = 10;
        int[] operations = {0,1,0,1};

        Solution solution = new Solution();
        System.out.println(solution.kthCharacter(k, operations));
    }
}