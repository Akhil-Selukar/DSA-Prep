package org.akhil;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    // Solution 1 - bruteforce (TLE)
    // O(N*M*L)/O(S) where N is length of sentence, M is size of dictionary and L is max length of word in sentence and S is total words in strs
//    public String replaceWords(List<String> dictionary, String sentence) {
//        String[] strs = sentence.split("\\s");
//
//        for(int i=0; i<strs.length; i++){
//            for(int j=1; j<strs[i].length(); j++){
//                if(dictionary.contains(strs[i].substring(0,j))){
//                    strs[i] = strs[i].substring(0, j);
//                }
//            }
//        }
//
//        StringBuilder sb = new StringBuilder();
//        for(String str:strs){
//            sb.append(str).append(" ");
//        }
//
//        return sb.toString().strip();
//    }

    // ---------------
    // Solution 2 - Same concept (accepted but not efficient)
//    public String replaceWords(List<String> dictionary, String sentence) {
//        String[] strs = sentence.split("\\s");
//        Set<String> set = new HashSet<>();
//        set.addAll(dictionary);
//
//        for(int i=0; i<strs.length; i++){
//            for(int j=1; j<strs[i].length(); j++){
//                if(set.contains(strs[i].substring(0,j))){
//                    strs[i] = strs[i].substring(0, j);
//                }
//            }
//        }
//
//        StringBuilder sb = new StringBuilder();
//        for(String str:strs){
//            sb.append(str).append(" ");
//        }
//
//        return sb.toString().strip();
//    }

    // ------------------
    // Solution 3 - Using Trie (Most efficient solution)
    // TC -> O(Sdict + Ssen) where Sdict is total number of CHARACTERS in dictionary and Ssen is total number of CHARACTERS in sentense
    // SC -> O(Sdict + Ssen) where Sdict is total number of CHARACTERS in dictionary and Ssen is total number of CHARACTERS in sentense

    class TrieNode{
        TrieNode[] child;
        boolean isEndOfWord;
        String word;

        public TrieNode(){
            child = new TrieNode[26];
            isEndOfWord = false;
            word = null;
        }
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = new TrieNode();

        // insert all words in dictionary in trie
        for(String word:dictionary){
            insert(word, root);
        }

        String[] arr = sentence.split("\\s");       // SC : O(Ssen)  -> we are storing entire sentense in an array

        for(int i=0; i<arr.length; i++){
            String word = arr[i];
            arr[i] = search(word, root);        // search will be called on each word and TC of search is O(W) so it will effectivelly become O(Ssen) for entire sentense.
        }

        StringBuilder sb = new StringBuilder();

        for(String s:arr){
            sb.append(s).append(" ");
        }

        return sb.toString().strip();
    }

    // TC -> O(W) where W is length of word (each character in word will be traversed and checked in trie)
    private String search(String word, TrieNode root){
        for(int i=0; i<word.length(); i++){
            int index = word.charAt(i)-'a';
            if(root.child[index] == null){
                return word;
            }

            root = root.child[index];
            if(root.isEndOfWord){
                return root.word;
            }
        }
        return word;
    }

    // TC -> O(Sdict) -> each character will be traversed and create a node for itself
    // SC -> O(Sdict)
    private void insert(String word, TrieNode root){
        for(int i=0; i<word.length(); i++){
            int index = word.charAt(i)-'a';
            if(root.child[index] == null){
                root.child[index] = new TrieNode();
            }
            root = root.child[index];
        }
        root.isEndOfWord = true;
        root.word = word;
    }
}
