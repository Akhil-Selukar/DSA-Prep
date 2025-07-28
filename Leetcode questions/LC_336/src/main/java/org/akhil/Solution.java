package org.akhil;

import java.util.*;

public class Solution {

    // Solution 1 - checking all combinations (TLE)
    // O(N^2 * L_Max)/O(N) -> where L_Max is length of largest word
//    public List<List<Integer>> palindromePairs(String[] words) {
//        int n = words.length;
//        List<List<Integer>> result = new ArrayList<>();
//
//        for(int i=0; i<n; i++){           // O(N)
//            for(int j=0; j<n; j++){       // O(N)
//                if(i==j){
//                    continue;
//                }
//                if(isPalindrome(words[i]+words[j])){
//                    List<Integer> temp = new ArrayList<>();
//                    temp.add(i);
//                    temp.add(j);
//                    result.add(temp);
//                }
//            }
//        }
//        return result;
//    }
//
//    private boolean isPalindrome(String s) {
//        int start = 0;
//        int end = s.length()-1;
//
//        while(start <= end){          // O(L_Max/2)   ~ O(L_Max)
//            if(s.charAt(start) != s.charAt(end)){
//                return false;
//            }
//            start++;
//            end--;
//        }
//        return true;
//    }


    // Solution 2 - considering all cases individually
    // O(N*L_Max^2)/O(N^2*L_Max)
    public List<List<Integer>> palindromePairs(String[] words) {
        int n = words.length;
        List<List<Integer>> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        // populate the map
        for(int i=0; i<n; i++){         // O(N)
            map.put(words[i], i);
        }

        // case 1 - if straight reverse is present in words then we can combine the two to create palindrome.
        for(int i=0; i<n; i++){             // O(N)
            String reverse = new StringBuilder(words[i]).reverse().toString();
            Integer reverseIndex = map.get(reverse);
            if(reverseIndex != null && reverseIndex != i){
                result.add(Arrays.asList(i, reverseIndex));
            }
        }

        // case 2 - if empty string is present then any palindrome with empty string at any end will be palindrome
        if(map.containsKey("")){
            int emptyIndex = map.get("");
            for(int i=0; i<n; i++){             // O(N)
                if(emptyIndex != i && isPalindrome(words[i])){
                    result.add(Arrays.asList(emptyIndex, i));
                    result.add(Arrays.asList(i, emptyIndex));
                }
            }
        }

        // case 3 - if any string when broken at a index has one palindromic part and other parts reverse is present in words we can combine those strings to form a palindrome
        // for ex: "lls" and "sssll", for "sssll" if we split it at index 2, then "ss" is palindrome and reverse of "sll" is present in words hence we can combine them as "llssssll"
        for(int i=0; i<n; i++){         // O(N)
            String currWord = words[i];
            for(int j=1; j<currWord.length(); j++){         // O(L_Max)
                String leftPart = currWord.substring(0, j);
                String rightPart = currWord.substring(j, currWord.length());

                //if left part is palindrome
                if(isPalindrome(leftPart)){
                    String rightReversed = new StringBuilder(rightPart).reverse().toString();       // O(L_Max)
                    if(map.containsKey(rightReversed)){
                        result.add(Arrays.asList(map.get(rightReversed), i));
                    }
                }

                // if rightPart is palindrome
                if(isPalindrome(rightPart)){
                    String leftReversed = new StringBuilder(leftPart).reverse().toString();         // O(L_Max)
                    if(map.containsKey(leftReversed)){
                        result.add(Arrays.asList(i, map.get(leftReversed)));
                    }
                }
            }
        }
        return result;
    }

    private boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length()-1;

        while(start <= end){                // O(L_Max/2) ~ O(L_Max)
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
