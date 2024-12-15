package org.akhil;

import java.util.*;

public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Queue<List<String>> queue = new LinkedList<>();
        Set<String> set = new HashSet<>(wordList);

        List<String> list = new ArrayList<>();
        list.add(beginWord);
        queue.offer(list);

        List<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(beginWord);
        int level = 0;

        List<List<String>> answer = new ArrayList<>();

        while(!queue.isEmpty()){
            List<String> temp = queue.poll();

            if(temp.size() > level){
                level++;
                for(String word:usedOnLevel){
                    set.remove(word);
                }
            }

            // current word
            String currentWord = temp.get(temp.size() - 1);

            if (currentWord.equals(endWord)) {
                // the first sequence where we reached the end.
                if (answer.size() == 0) {
                    answer.add(temp);
                } else if (answer.get(0).size() == temp.size()) {
                    answer.add(temp);
                }
            }

            for(int i = 0; i < currentWord.length(); i++){
                for(char ch = 'a'; ch <= 'z'; ch++) {
                    char[] replacedCharArray = currentWord.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);

                    if (set.contains(replacedWord)) {
                        temp.add(replacedWord);
                        queue.offer(new ArrayList<>(temp));
                        usedOnLevel.add(replacedWord);
                        temp.remove(temp.size()-1);
                    }
                }
            }

        }
        return answer;
    }
}
