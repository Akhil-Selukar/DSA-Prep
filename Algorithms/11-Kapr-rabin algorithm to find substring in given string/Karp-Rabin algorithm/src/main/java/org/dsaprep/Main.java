package org.dsaprep;

public class Main {
    public static void main(String[] args) {
        KarpRabin krb = new KarpRabin();

        String text = "HelloAllHowAreYou?";
        String pattern = "How";

        krb.search(text, pattern);
    }
}