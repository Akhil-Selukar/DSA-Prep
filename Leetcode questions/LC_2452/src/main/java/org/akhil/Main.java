package org.akhil;

public class Main {
    public static void main(String[] args) {
        String[] queries = {"word","note","ants","wood"};
        String[] dictionary = {"wood","joke","moat"};

        Solution solution = new Solution();
        System.out.println(solution.twoEditWords(queries, dictionary));
    }
}