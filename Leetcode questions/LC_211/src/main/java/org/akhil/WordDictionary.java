package org.akhil;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordDictionary {
    // Solution 1 - TLE
//    List<String> list;
//    public WordDictionary() {
//        list = new ArrayList<>();
//    }
//
//    public void addWord(String word) {
//        list.add(word);
//    }
//
//    public boolean search(String word) {
//        Pattern p = Pattern.compile(word);
//        for(String str:list){
//            Matcher m = p.matcher(str);
//            if(m.matches()){
//                return true;
//            }
//        }
//        return false;
//    }

    // Solution 2 - TLE (O(M*N)/O(N))

//    private HashMap<Integer, Set<String>> map;
//    public WordDictionary() {
//        this.map = new HashMap<>();
//    }
//
//    public void addWord(String word) {
//        int length = word.length();
//        if(!this.map.containsKey(length)){
//            map.put(length, new HashSet<String>());
//        }
//        map.get(length).add(word);
//    }
//
//    public boolean search(String word) {
//        int length = word.length();
//        if(this.map.containsKey(length)){
//            for(String str:map.get(length)){
//                int index=0;
//                while(index < length && ((str.charAt(index) == word.charAt(index) || (word.charAt(index) == '.')))){
//                    index++;
//                }
//                if(index == length){
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

    // Solution 3

    Node root;
    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node newRoot = root;
        for(char ch:word.toCharArray()){
            int alphabetIndex = ch - 'a';
            if (newRoot.children[alphabetIndex] == null) {
                newRoot.children[alphabetIndex] = new Node();
            }
            newRoot = newRoot.children[alphabetIndex];
        }
        newRoot.isWordCompleted = true;
    }

    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }

    boolean searchHelper(String word, int index, Node newRoot) {
        if (index == word.length())
            return newRoot.isWordCompleted;
        char ch = word.charAt(index);
        if (ch == '.') {
            for (int i = 0; i < 26; i++) {
                if (newRoot.children[i] != null && searchHelper(word, index + 1, newRoot.children[i])) {
                    return true;
                }
            }
            return false;
        }
        else {
            if (newRoot.children[ch - 'a'] == null) {
                return false;
            }
            return searchHelper(word, index + 1, newRoot.children[ch - 'a']);
        }
    }
}
