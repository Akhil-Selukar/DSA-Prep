package org.akhil;

import java.util.Collections;
import java.util.List;

public class Solution {

    // Solution 1 - (O(M*N + MLog(M))/O(log(M))
//    public String findLongestWord(String s, List<String> dictionary) {
//        Collections.sort(dictionary, (s1,s2)-> s1.length() != s2.length() ? s2.length() - s1.length() : s1.compareTo(s2));      // Sort by length and lexicographically
//
//        for(String word:dictionary){
//            int i=0;
//            for(int j=0; j<s.length(); j++){
//                if(s.charAt(j) == word.charAt(i)){
//                    i++;
//                    if(i == word.length()){
//                        return word;
//                    }
//                }
//            }
//        }
//
//        return "";
//    }

    // Solution 2 - Here time complexity will be same but still this solution is better than above one because here we are not iterating through the entire word after finding a character which is not present in S. This reduces many unnecessary iterations.
//    public String findLongestWord(String s, List<String> dictionary) {
//        Collections.sort(dictionary, (s1,s2)-> s1.length() != s2.length() ? s2.length() - s1.length() : s1.compareTo(s2));      // Sort by length and lexicographically
//
//        for(String word:dictionary){
//            if(isSubsequence(s, word)){
//                return word;
//            }
//        }
//        return "";
//    }
//
//    private boolean isSubsequence(String s, String word) {
//        int j = -1;
//        for(int i=0; i<word.length(); i++){
//            j = s.indexOf(word.charAt(i), j+1);
//            if(j == -1){
//                return false;
//            }
//        }
//        return true;
//    }

    // Solution 3 - eliminated the need of sorting hence improved the time complexity (O(MNK + MK)/O(K))
    public String findLongestWord(String s, List<String> dictionary) {

        String result = "";

        for(String word:dictionary){        // O(M) where M is the words in dictionary
            if((word.length() > result.length() || result.length() == word.length() && result.compareTo(word)>0) && isSubsequence(s, word)){        // Here compareTo method in worst case will have to compare each character, and the max character can be equal to length of S (i.e. K chars) hence complexity for this compareTo is O(K)
                result = word;
            }
        }
        return result;
    }

    private boolean isSubsequence(String s, String word) {      // O(NK) where N is length of S and K is length of word
        int j = -1;
        for(int i=0; i<word.length(); i++){
            j = s.indexOf(word.charAt(i), j+1);
            if(j == -1){
                return false;
            }
        }
        return true;
    }
}
