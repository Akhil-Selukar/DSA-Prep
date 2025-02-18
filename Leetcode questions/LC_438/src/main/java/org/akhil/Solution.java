package org.akhil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    // O(N+M) where N is size of s and M is size of P (In most of the cases M will be less that N, hence we can simply the complexity to O(N)) at max M can be N in that case complexity will be O(2N) i.e. o(N)
    // space complexity O(N+M) where N is size of s (at each index we got the anagram), and M is size of P where p has all unique chars hence frequency map will have space complexity of O(M).
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> answer = new ArrayList<>();
        if(p.length() > s.length()){
            return answer;
        }

        // populate the frequency map for target or P string
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : p.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        int counter = map.size();       // will keep track of if there are elements left to consume or not.

        // define the window
        int start = 0;
        int end = 0;

        while(end < s.length()){
            char ch = s.charAt(end);

            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)-1);         // reduce the frequency as we found the match (i.e. the char is consumed.
                if(map.get(ch) == 0){               // need to check with 0 because if ch is repeated then even though we just consumed ch there might be some more ch left.
                    counter--;
                }
            }
            end++;                                  // expand the window

            while(counter == 0){
                char tempCh = s.charAt(start);      // after consumption of all elements shrink window from left. hence we will have to repopulate the frequency for shrunk character.

                if(map.containsKey(tempCh)){
                    if(map.get(tempCh) == 0){
                        counter++;                  //need to increase counter when it first adds back to the map.
                    }
                    map.put(tempCh, map.get(tempCh)+1);
                }
                if(end-start == p.length()){
                    answer.add(start);
                }
                start++;
            }
        }
        return answer;
    }
}
