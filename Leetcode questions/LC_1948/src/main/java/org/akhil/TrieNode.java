package org.akhil;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    String val;
    String subFolder;
    Map<String, TrieNode> children;

    public TrieNode(String val) {
        this.val = val;
        this.subFolder = "";
        this.children = new HashMap<>();
    }
}
