package org.akhil;

public class Solution {
    public String convertToBase7(int num) {
        boolean negative = num < 0;

        if(num == 0){
            return "0";
        }

        num = Math.abs(num);
        StringBuilder sb = new StringBuilder();

        while(num != 0){
            int rem = num % 7;
            sb.append(String.valueOf(rem));
            num = num/7;
        }

        if(negative){
            sb.append("-");
        }

        return sb.reverse().toString();
    }
}
