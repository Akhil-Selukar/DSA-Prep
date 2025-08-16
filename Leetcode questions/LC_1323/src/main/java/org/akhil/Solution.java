package org.akhil;

public class Solution {
    // Solution 1 -
    // O(N)/O(N) where N is number of digits in num
    public int maximum69Number (int num) {
        String n = Integer.toString(num);
        char[] chars = n.toCharArray();

        for(int i=0; i<n.length(); i++){
            if(chars[i] == '6'){
                chars[i] = '9';
                break;
            }
        }

        return Integer.parseInt(new String(chars));
    }
}
