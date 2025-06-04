package org.akhil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    // Solution 1
//    public List<String> wordBreak(String s, List<String> wordDict) {
//        StringBuilder sb = new StringBuilder();
//        List<String> answer = new ArrayList<>();
//
//        helper(s, 0, wordDict, sb, answer);
//
//        return answer;
//    }
//
//    private void helper(String s, int start, List<String> wordDict, StringBuilder sb, List<String> answer) {
//        if(start >= s.length()){
//            String str = sb.toString().trim();
//            answer.add(str);
//            return;
//        }
//
//        for(int i=start; i<=s.length(); i++){
//            if(wordDict.contains(s.substring(start, i))){
//                int originalLength = sb.length();
//                sb.append(" ").append(s.substring(start, i));
//
//                helper(s, i, wordDict, sb, answer);
//
//                sb.setLength(originalLength);
//            }
//        }
//    }


    // Solution 2

//    Set<String> dict = new HashSet<>();
//    public List<String> wordBreak(String s, List<String> wordDict) {
//        StringBuilder sb = new StringBuilder();
//        List<String> answer = new ArrayList<>();
//
//        for(String word:wordDict){
//            dict.add(word);
//        }
//
//        helper(s, 0, sb, answer);
//
//        return answer;
//    }
//
//    private void helper(String s, int start, StringBuilder sb, List<String> answer) {
//        if(start >= s.length()){
//            String str = sb.toString().trim();
//            answer.add(str);
//            return;
//        }
//
//        for(int i=start; i<=s.length(); i++){
//            if(dict.contains(s.substring(start, i))){
//                int originalLength = sb.length();
//                sb.append(" ").append(s.substring(start, i));
//
//                helper(s, i, sb, answer);
//
//                sb.setLength(originalLength);
//            }
//        }
//    }


    // Solution 3

//    Set<String> dict = new HashSet<>();
//    public List<String> wordBreak(String s, List<String> wordDict) {
//        List<String> answer = new ArrayList<>();
//
//        for(String word:wordDict){
//            dict.add(word);
//        }
//
//        helper(s, 0, "", answer);
//
//        return answer;
//    }
//
//    private void helper(String s, int start, String sb, List<String> answer) {
//        if(start >= s.length()){
//            String str = sb.trim();
//            answer.add(str);
//            return;
//        }
//
//        for(int i=start; i<=s.length(); i++){
//            if(dict.contains(s.substring(start, i))){
//                String originalString = sb;
//
//                if(sb.length() > 0){
//                    sb = sb+" ";
//                }
//
//                helper(s, i, sb+s.substring(start, i), answer);
//
//                if(sb.length() > 0){
//                    sb = originalString;
//                }
//            }
//        }
//    }

//    Solution - 4

    Set<String> dict = new HashSet<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> answer = new ArrayList<>();

        for(String word:wordDict){
            dict.add(word);
        }

        helper(s, 0, new StringBuilder(), answer);

        return answer;
    }

    private void helper(String s, int start, StringBuilder sb, List<String> answer) {
        if(start >= s.length()){
            String str = sb.toString().trim();
            answer.add(str);
            return;
        }

        for(int i=start; i<=s.length(); i++){
            if(dict.contains(s.substring(start, i))){
                int originalLength = sb.length();

                if(sb.length() > 0){
                    sb = sb.append(" ");
                }

                helper(s, i, sb.append(s.substring(start, i)), answer);

                sb.setLength(originalLength);
            }
        }
    }
}
