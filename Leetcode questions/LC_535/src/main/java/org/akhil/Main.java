package org.akhil;

public class Main {
    public static void main(String[] args) {
        String url = "https://leetcode.com/problems/design-tinyurl";

        Codec codec = new Codec();
        String shortURL = codec.encode(url);
        System.out.println(shortURL);
        String longURL = codec.decode(shortURL);
        System.out.println(longURL);
    }
}