package org.akhil;

public class Main {
    public static void main(String[] args) {
        String startGene = "AACCGGTT";
        String endGene = "AAACGGTA";
        String[] bank = {"AACCGGTA","AACCGCTA","AAACGGTA"};

        Solution solution = new Solution();
        System.out.println(solution.minMutation(startGene, endGene, bank));
    }
}