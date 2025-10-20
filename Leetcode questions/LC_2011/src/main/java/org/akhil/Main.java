package org.akhil;

public class Main {
    public static void main(String[] args) {
        String[] operations = {"--X","X++","X++"};

        Solution solution = new Solution();
        System.out.println(solution.finalValueAfterOperations(operations));
    }
}