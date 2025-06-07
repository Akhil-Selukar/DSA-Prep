package org.akhil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    // O(N)/O(N)
    public String clearStars(String s) {
        List<List<Integer>> freq = new ArrayList<>();
        for(int i=0; i<26; i++){
            freq.add(new ArrayList<>());
        }
        char[] chars = s.toCharArray();

        for(int i=0; i<s.length(); i++){
            int ch = s.charAt(i);
            if(ch == '*'){
                removeLeftSmallest(freq, chars);
            } else {
                freq.get(ch-'a').add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char ch:chars){
            if(ch != '*'){
                sb.append(ch);
            }
        }

        return sb.toString();
    }

    private void removeLeftSmallest(List<List<Integer>> freq, char[] chars) {
        for(int i=0; i<26; i++){
            if(freq.get(i).size() > 0){
                int position = freq.get(i).get(freq.get(i).size()-1);
                chars[position] = '*';
                freq.get(i).remove(freq.get(i).size()-1);
                return;
            }
        }
    }


    // ---------------------- Below is more intuitive as whenever we think about frequency Map is first thing which popup in mind,
    // but here as size is fixed i.e. 26 hence go with List<List<>> as Map involves hashing and all which increase time even though complexity is same.

//    public String clearStars(String s) {
//        Map<Integer, List<Integer>> freq = new HashMap<>();
//
//        char[] chars = s.toCharArray();
//
//        for(int i=0; i<s.length(); i++){
//            int ch = s.charAt(i);
//            if(ch == '*'){
//                removeLeftSmallest(freq, chars);
//            } else {
//                List<Integer> list = freq.getOrDefault(ch-'a', new ArrayList<>());
//                list.add(i);
//                freq.put(ch-'a', list);
//            }
//        }
//
//        StringBuilder sb = new StringBuilder();
//        for(char ch:chars){
//            if(ch != '*'){
//                sb.append(ch);
//            }
//        }
//
//        return sb.toString();
//    }
//
//    private void removeLeftSmallest(Map<Integer, List<Integer>> freq, char[] chars) {
//        for(int i=0; i<26; i++){
//            if(freq.containsKey(i)){
//                int position = freq.get(i).get(freq.get(i).size()-1);
//                chars[position] = '*';
//                freq.get(i).remove(freq.get(i).size()-1);
//                if(freq.get(i).size() == 0){
//                    freq.remove(i);
//                }
//                return;
//            }
//        }
//    }
}
