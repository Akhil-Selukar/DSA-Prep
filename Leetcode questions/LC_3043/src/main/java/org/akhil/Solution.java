package org.akhil;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    // Solution 1 - Using set
    // O((M+N)*D^2)/O(M)
//    public int longestCommonPrefix(int[] arr1, int[] arr2) {
//        int m = arr1.length;
//        int n = arr2.length;
//
//        Set<String> set = new HashSet<>();
//
//        // create all prefix of numbers in arr1 and add them to set
//        for(int num:arr1) {             // O(M)
//            createPrefix(set, num);     // O(D^2) where D is number of digits in the number and ^2 because substring operation
//        }
//
//        // check all prefixes for numbers from arr2 and find the common in set to get maxLength
//        int maxLength = 0;
//        for(int num:arr2){          // O(N)
//            int currMax = checkPrefixLength(set, num);      // O(D^2)
//            maxLength = Math.max(maxLength, currMax);
//        }
//
//        return maxLength;
//    }
//
//    private void createPrefix(Set<String> set, int num){
//        String strNum = Integer.toString(num);  // it is easy to get substrings out of string
//
//        for(int i=1; i<=strNum.length(); i++){
//            set.add(strNum.substring(0, i));
//        }
//    }
//
//    private int checkPrefixLength(Set<String>set, int num){
//        String strNum = Integer.toString(num);
//        int currLength = 0;
//
//        for(int i=1; i<=strNum.length(); i++){
//            if(set.contains(strNum.substring(0,i))){
//                currLength++;
//            } else {
//                break;
//            }
//        }
//        return currLength;
//    }


    // ---------------------------------
    // Solution 2 - Using Trie
    // O((M+N)*D)/O(MD)
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Trie trie = new Trie();

        // insert all prefix of numbers from num1 in trie
        for(int num:arr1){
            trie.insert(num);
        }

        // check/compare all numbers from arr2 with created trie
        int maxLength = 0;
        for(int num:arr2){
            int currLength = trie.getCommonPrefixLength(num);
            maxLength = Math.max(maxLength, currLength);
        }
        return maxLength;
    }

    private class Node{
        char charVal;
        Node[] child = new Node[10];        // size 10 because only 1 of 10 digits (0-9) can be present at any place
    }

    private class Trie{
        Node root = new Node();

        // insert node in Trie
        public void insert(int num){
            Node curr = root;

            String strNum = Integer.toString(num);
            for(int i=0; i<strNum.length(); i++){
                char ch = strNum.charAt(i);
                int charIndex = ch-'0';

                if(curr.child[charIndex] == null){
                    Node newNode = new Node();
                    newNode.charVal = ch;
                    curr.child[charIndex] = newNode;
                }
                curr = curr.child[charIndex];
            }
        }

        // check the prefix and compute length
        public int getCommonPrefixLength(int num){
            Node curr = root;
            String strNum = Integer.toString(num);

            int currLength = 0;

            for(int i=0; i<strNum.length(); i++){
                int chVal = strNum.charAt(i);
                int charIndex = chVal - '0';
                if(curr.child[charIndex] != null){
                    curr = curr.child[charIndex];
                    currLength++;
                } else {
                    break;
                }
            }
            return currLength;
        }
    }
}
