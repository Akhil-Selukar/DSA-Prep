package org.akhil;

import java.util.*;

public class Solution {
    private class Pair{
        private String word;
        private int level;

        public Pair(String word, int level){
            this.word = word;
            this.level = level;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // initializing all preconditions for BFS
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginWord, 1));
        Set<String> set = new HashSet<>();

        for(String word:wordList){
            set.add(word);
        }

        // BFS
        while(!queue.isEmpty()){
            Pair temp = queue.poll();
            String word = temp.word;
            int level = temp.level;
            if(word.equals(endWord)) {
                return level;
            }

            for(int i=0; i<word.length(); i++){
                for(char ch='a'; ch<='z'; ch++){
                    char[] wordArray = word.toCharArray();
                    wordArray[i] = ch;
                    String newWord = new String(wordArray);
                    if(set.contains(newWord)){
                        set.remove(newWord);
                        queue.add(new Pair(newWord, level+1));
                    }
                }
            }
        }
        return 0;
    }
}
