package org.akhil;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    // Solution 1 - using sliding window and Map
    // O(N)/O(M) -> where N is size of string s and M is size of t
//    public String minWindow(String s, String t) {
//        // edge case
//        if (s.length() < t.length()) {
//            return "";
//        }
//
//        int[] resultIndex = {0, Integer.MAX_VALUE};
//        Map<Character, Integer> freq = new HashMap<>();
//        int distinctCharsToMatch = 0;
//
//        // add -ve frequency for chars in t as those are the only chars we are interested in.
//        for (char ch : t.toCharArray()) {
//            freq.put(ch, freq.getOrDefault(ch, 0) - 1);
//            if (freq.get(ch) == -1) {
//                distinctCharsToMatch++;
//            }
//        }
//
//        // iterate through s using sliding window (variable size) and check if we can bring the -ve frequency to 0.
//        int startIndex = 0;
//        int charsMatched = 0;
//        for (int endIndex = 0; endIndex < s.length(); endIndex++) {
//            char ch = s.charAt(endIndex);
//
//            // we need to process the character only if it is one of t's character
//            if (freq.containsKey(ch)) {
//                freq.put(ch, freq.get(ch) + 1);
//                if (freq.get(ch) == 0) {
//                    charsMatched++;
//                }
//            }
//
//            // if all chars are matched, shrink the window from start till match condition becomes invalid.
//            while (distinctCharsToMatch == charsMatched) {
//                // check if current length of substring is less than previous length
//                if (resultIndex[1] - resultIndex[0] > endIndex - startIndex) {
//                    resultIndex[0] = startIndex;
//                    resultIndex[1] = endIndex;
//                }
//
//                char startCh = s.charAt(startIndex);
//                if (freq.containsKey(startCh)) {
//                    freq.put(startCh, freq.get(startCh) - 1);
//                    if (freq.get(startCh) == -1) {
//                        charsMatched--;
//                    }
//                }
//                startIndex++;
//            }
//        }
//
//        if(resultIndex[1] == Integer.MAX_VALUE){
//            return "";
//        }
//        return s.substring(resultIndex[0], resultIndex[1]+1);
//    }

    // ------------------------
    // ----------------------

    // Solution 2 - More clean and intuitive code
    // O(N)/O(M) -> where N is size of string s and M is size of t
    public String minWindow(String s, String t) {
        // edge case
        if (s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> freq = new HashMap<>();
        int charsToMatch = 0;

        for(char ch:t.toCharArray()){
            freq.put(ch, freq.getOrDefault(ch, 0)-1);
            charsToMatch++;
        }

        int start = 0;
        int windowStartIndex = 0;
        int windowSize = Integer.MAX_VALUE;

        for(int end = 0; end < s.length(); end++){
            // match the charAt end in s (i.e. try to make freq 0 for that char)
            char ch = s.charAt(end);

            if(freq.containsKey(ch) && freq.get(ch) < 0){   // means this char is required
                charsToMatch--;
            }

            // update the char count in freq
            freq.put(ch, freq.getOrDefault(ch, 0)+1);

            while(charsToMatch == 0){      // i.e. all chars in t are matched
                // check if we can shring the window from start

                int currWindowSize = end - start + 1;
                if(currWindowSize < windowSize){
                    windowSize = currWindowSize;
                    windowStartIndex = start;
                }

                char startChar = s.charAt(start);

                freq.put(startChar, freq.getOrDefault(startChar, 0)-1);

                if(freq.containsKey(startChar) && freq.get(startChar) < 0){
                    charsToMatch++;
                }
                start++;
            }
        }

        return windowSize == Integer.MAX_VALUE ? "" : s.substring(windowStartIndex, windowStartIndex + windowSize);
    }
}
