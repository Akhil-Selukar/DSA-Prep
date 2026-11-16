package org.akhil;

public class Solution {
    public String digitSum(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int index = 0;

        while(s.length() > k){
            while(index < s.length()) {
                int sum = 0;
                for (int i = 0; (i < k && index<s.length()); i++) {
                    sum = sum + Character.getNumericValue(s.charAt(index++));
                }
                sb.append(sum);
            }
            s = sb.toString();
            sb = new StringBuilder();
            index = 0;
        }

        return s;
    }
}
