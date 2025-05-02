package org.akhil;

public class Main {
    public static void main(String[] args) {
        String dominoes = ".L.R...LR..L..";
//        String dominoes = ".L.R...LR..L..R..";
//        String dominoes = "RR.L";

        Solution solution = new Solution();
        System.out.println(solution.pushDominoes(dominoes));
    }
}