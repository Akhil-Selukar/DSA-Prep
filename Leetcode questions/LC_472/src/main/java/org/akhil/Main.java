package org.akhil;

public class Main {
    public static void main(String[] args) {
        String[] words = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};

        Solution solution = new Solution();
        System.out.println(solution.findAllConcatenatedWordsInADict(words));
    }
}