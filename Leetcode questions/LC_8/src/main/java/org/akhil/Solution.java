package org.akhil;

public class Solution {
    public int myAtoi(String s) {
        int i=0;
        int n = s.length();
        int sign = 1;
        long answer = 0;

        // Whitespace: Ignore all leading whitespaces
        while(i<n && s.charAt(i) == ' '){
            i++;
        }

        // Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity if neither present.
        if(i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // Conversion and Rounding
        while(i<n && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
            int digit = s.charAt(i)-'0';

            answer = answer * 10 + digit;

            if(answer > Integer.MAX_VALUE){
                if(sign == -1){
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            }
            i++;
        }
        return (int)(answer * sign);
    }
}
