package org.akhil;

public class Solution {
    public String toHex(int num) {

        if(num == 0){
            return "0";
        }

        String hex = "0123456789abcdef";
        StringBuilder sb = new StringBuilder();

        while(num != 0){
            int val = num & 15;
            sb.append(hex.charAt(val));
            num = num>>>4;
        }

        return sb.reverse().toString();
    }
}
