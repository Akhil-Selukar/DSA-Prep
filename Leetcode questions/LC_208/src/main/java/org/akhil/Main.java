package org.akhil;

public class Main {
    public static void main(String[] args) {
        Trie obj = new Trie();
        obj.insert("Food");
        boolean param_2 = obj.search("Food");
        boolean param_3 = obj.startsWith("Fo");

        System.out.println(param_2);
        System.out.println(param_3);
    }
}