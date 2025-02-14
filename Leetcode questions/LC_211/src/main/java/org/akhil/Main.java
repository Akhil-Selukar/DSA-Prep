package org.akhil;

public class Main {
    public static void main(String[] args) {
        WordDictionary obj = new WordDictionary();

        obj.addWord("bad");
        obj.addWord("dad");
        obj.addWord("mad");

        System.out.println(obj.search("pad"));
        System.out.println(obj.search("bad"));
        System.out.println(obj.search(".ad"));
        System.out.println(obj.search("p.."));
        System.out.println(obj.search("b.."));
    }
}