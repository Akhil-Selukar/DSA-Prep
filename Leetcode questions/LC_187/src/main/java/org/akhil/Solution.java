package org.akhil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    // Solution 1 - TLE    (O(N^2)/O(M*N)
//    public List<String> findRepeatedDnaSequences(String s) {
//        List<String> answer = new ArrayList<>();
//
//        int start = 0;
//        int end = start + 10;
//
//        while (end < s.length()) {
//            int i = start + 1;
//            String dna = s.substring(start, end);
//            if (s.substring(i, s.length()).contains(dna)) {
//                if (!answer.contains(dna)) {
//                    answer.add(dna);
//                }
//            }
//            start++;
//            end++;
//        }
//        return answer;
//    }

    // Solution 2 - O(N)/O(M*N)

    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> checked = new HashSet<>();
        Set<String> answerSet = new HashSet<>();

        for(int i=0; i<=s.length()-10; i++){
            String dna = s.substring(i, i+10);
            if(checked.contains(dna)){
                answerSet.add(dna);
            } else {
                checked.add(dna);
            }
        }
        return new ArrayList<>(answerSet);
    }
}
