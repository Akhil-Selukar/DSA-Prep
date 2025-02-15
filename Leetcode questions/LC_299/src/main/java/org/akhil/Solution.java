package org.akhil;

public class Solution {

    // O(N)/O(1)
    public String getHint(String secret, String guess) {
        int[] secretCounts = new int[10];
        int bulls = 0;
        int cows = 0;

        for(char ch:secret.toCharArray()){
            int charValue = ch-'0';
            secretCounts[charValue]++;
        }

        for(int i=0; i<secret.length(); i++){
            if(guess.charAt(i) == secret.charAt(i)){
                if(secretCounts[guess.charAt(i)-'0'] == 0){
                    secretCounts[guess.charAt(i)-'0']++;
                    cows--;
                }
                bulls++;
                secretCounts[guess.charAt(i)-'0']--;
            } else {
                if(secretCounts[guess.charAt(i)-'0'] > 0){
                    cows++;
                    secretCounts[guess.charAt(i)-'0']--;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(bulls).append("A").append(cows).append("B");

        return sb.toString();
    }
}
