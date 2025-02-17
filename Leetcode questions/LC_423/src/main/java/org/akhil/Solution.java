package org.akhil;

public class Solution {

    // (O(N)/O(N))
    public String originalDigits(String s) {
        int[] count = new int[10];
        StringBuilder sb = new StringBuilder();
        for(char ch:s.toCharArray()){
            if(ch == 'z') {count[0]++;}
            if(ch == 'w') {count[2]++;}
            if(ch == 'u') {count[4]++;}
            if(ch == 'x') {count[6]++;}
            if(ch == 'g') {count[8]++;}
            if(ch == 'f') {count[5]++;}
            if(ch == 'h') {count[3]++;}
            if(ch == 's') {count[7]++;}
            if(ch == 'o') {count[1]++;}
            if(ch == 'i') {count[9]++;}
        }
        count[5] = count[5] - count[4];
        count[3] = count[3] - count[8];
        count[7] = count[7] - count[6];
        count[1] = count[1] - count[0] - count[2] - count[4];
        count[9] = count[9] - count[8] - count[6] - count[5];

        for(int i=0; i<count.length; i++){
            for(int j=0; j<count[i]; j++){
                sb.append(i);
            }
        }
        return sb.toString();
    }
}
