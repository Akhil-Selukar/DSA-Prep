package org.akhil;

public class Solution {

    // O(N)/O(N) where N is max of length of num1 and num2.
    public String addStrings(String num1, String num2) {
        int i = num1.length()-1;
        int j = num2.length()-1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();

        while(i>=0 || j>=0 || carry > 0){
            int digit1 = 0;
            int digit2 = 0;
            if(i>=0){
                digit1 = Character.getNumericValue(num1.charAt(i));
                i--;
            }
            if(j>=0){
                digit2 = Character.getNumericValue(num2.charAt(j));
                j--;
            }

            int addition = digit1 + digit2 + carry;
            sb.append(addition % 10);
            carry = addition / 10;
        }
        return sb.reverse().toString();
    }
}
