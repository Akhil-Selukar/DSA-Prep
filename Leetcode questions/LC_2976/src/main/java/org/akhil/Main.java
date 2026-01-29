package org.akhil;

public class Main {
    public static void main(String[] args) {
        String source = "abcd";
        String target = "acbe";
        char[] original = {'a','b','c','c','e','d'};
        char[] changed = {'b','c','b','e','b','e'};
        int[] cost = {2,5,5,1,2,20};

        Solution solution = new Solution();
        System.out.println(solution.minimumCost(source, target, original, changed, cost));
    }
}