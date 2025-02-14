package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Trie {
    private List<String> list;
    public Trie() {
        list = new ArrayList<>();
    }

    public void insert(String word) {
        list.add(word);
    }

    public boolean search(String word) {
        return list.contains(word);
    }

    public boolean startsWith(String prefix) {
        for(String word:list){
            if (word.startsWith(prefix)){
                return true;
            }
        }
        return false;
    }
}
