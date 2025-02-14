package org.akhil;

public class Node {
    Node[] children;
    boolean isWordCompleted;

    public Node() {
        this.children = new Node[26];
        this.isWordCompleted = false;
    }
}
