package org.akhil;

public class Main {
    public static void main(String[] args) {
        BrowserHistory history = new BrowserHistory("Leetcode");

        history.visit("Google");
        history.visit("Facebook");
        history.visit("YouTube");
        System.out.println(history.back(1));
        System.out.println(history.back(1));
        System.out.println(history.forward(1));
        history.visit("LinkedIn");
        System.out.println(history.forward(2));
        System.out.println(history.back(2));
        System.out.println(history.back(7));
    }
}