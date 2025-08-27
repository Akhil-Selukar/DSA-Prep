package org.akhil;

import java.util.*;

public class Solution {
    // O(N*M)/O(N) where N is length of words array and M is average length of word in words array.
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        Set<String> set = new HashSet<>();

        // sort the words based on their length in ascending order as we can form bigger string using smaller ones hence we need to
        // visit smaller ones first so that we will know what all smaller strings we have to create a larger one
        Arrays.sort(words, (a, b)-> a.length()-b.length());

        for(String word:words){
            if(canForm(word, set)){
                result.add(word);
            }
            set.add(word);  // this word we visited (i.e. we have this word to form further larger words now).
        }

        return result;
    }

    private boolean canForm(String word, Set<String> set){
        // we dont have any word in set, then we can not form the target word.
        if(set.isEmpty()){
            return false;
        }

        // check if we can form the word (similar to LC-139 problem -> word break)
        boolean[] checkedTill = new boolean[word.length()+1];
        checkedTill[0] = true;     // empty string can always be formed
        for(int endIndex = 1; endIndex <= word.length(); endIndex++){         // O(N)
            for(int startIndex=0; startIndex < endIndex; startIndex++){      // O(M) where M is average length of words in words array/set
                // we are are not able to form word till startIndex then no need to check further word.
                // if we are checking for a substring in target word then the word till startIndex should be able to form.
                if(!checkedTill[startIndex]){
                    continue;
                }
                if(set.contains(word.substring(startIndex, endIndex))){
                    checkedTill[endIndex] = true;
                    break;
                }
            }
        }

        return checkedTill[word.length()];
    }
}
