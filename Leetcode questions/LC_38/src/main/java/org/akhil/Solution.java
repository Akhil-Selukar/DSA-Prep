package org.akhil;

public class Solution {

    // O(2^N)/O(2^N) i.e. exponential time and space complexity.
    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder("1");
        String previous = sb.toString();
        int count;
        char ch;

        for (int i=1; i<n; i++){
            sb = new StringBuilder();
            count = 1;
            ch = previous.charAt(0);

            for (int j=1; j<previous.length(); j++){
                if (previous.charAt(j) != ch){
                    sb.append(count);
                    sb.append(ch);
                    count=1;
                    ch=previous.charAt(j);
                } else {
                    count++;
                }
            }
            sb.append(count);
            sb.append(ch);
            previous = sb.toString();
        }
        return sb.toString();
    }
}
