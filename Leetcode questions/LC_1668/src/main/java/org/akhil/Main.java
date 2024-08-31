package org.akhil;

public class Main {
    public static void main(String[] args) {
        String sequence = "ababc";
        String word = "ab";

        System.out.println(maxRepeating(sequence, word));
    }

    public static int maxRepeating(String sequence, String word) {
        if(sequence.length() < word.length()){
            return 0;
        }
        int count = 0;
        StringBuilder sb = new StringBuilder();
        sb.append(word);
        while(sequence.contains(sb.toString())){
            sb.append(word);
            count++;
        }
        return count;
    }
}