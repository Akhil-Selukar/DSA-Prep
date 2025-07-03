package org.akhil;

public class Solution {

    // O(K)/O(K)
    public char kthCharacter(int k) {
        StringBuilder sb = new StringBuilder("a");
        int count = 1;

        while(count <= k){
            int length = sb.length();
            for(int i=0; i<length; i++){
                char ch = sb.charAt(i);
                if(ch == 'z'){
                    sb.append('a');
                    continue;
                }
                sb.append((char)(ch+1));
            }
            count = count * 2;
        }
        return sb.charAt(k-1);      // k-1 because kth character is k-1th index.
    }
}
