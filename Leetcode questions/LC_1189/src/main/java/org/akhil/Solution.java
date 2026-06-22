package org.akhil;

public class Solution {
    // Solution 1
    // public int maxNumberOfBalloons(String text) {
    //     char[] arr = text.toCharArray();
    //     int result = 0;

    //     while(true){
    //         String word = "balloon";

    //         for(char ch:word.toCharArray()){
    //             boolean found = false;

    //             for(int i=0; i<arr.length; i++){
    //                 if(arr[i] == ch){
    //                     arr[i] = '#';
    //                     found = true;
    //                     break;
    //                 }
    //             }

    //             if(!found){
    //                 return result;
    //             }
    //         }
    //         result++;
    //     }
    // }

    // -----------------------
    // Solution 2
    public int maxNumberOfBalloons(String text) {
        int b_freq = 0;
        int a_freq = 0;
        int l_freq = 0;
        int o_freq = 0;
        int n_freq = 0;

        for(char ch: text.toCharArray()) {
            if(ch == 'b') b_freq++;
            else if(ch == 'a') a_freq++;
            else if(ch == 'l') l_freq++;
            else if(ch == 'o') o_freq++;
            else if(ch == 'n') n_freq++;
        }
        return Math.min(Math.min(b_freq, a_freq), Math.min(n_freq, Math.min(l_freq/2, o_freq/2)));
    }
}
