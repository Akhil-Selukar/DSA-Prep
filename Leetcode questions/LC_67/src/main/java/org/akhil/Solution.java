package org.akhil;

public class Solution {
    public String addBinary(String a, String b) {
        char[] str1 = a.toCharArray();
        char[] str2 = b.toCharArray();

        int index1 = str1.length-1;
        int index2 = str2.length-1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();

        while(index1 >=0 || index2 >=0 || carry>0){
            int num1 = index1 >= 0 && str1[index1] == '1' ? 1 : 0;
            int num2 = index2 >= 0 && str2[index2] == '1' ? 1 : 0;

            int sum = num1 + num2 + carry;
            carry = sum / 2;
            sb.append(sum % 2);

            index1--;
            index2--;
        }

        return sb.reverse().toString();
    }
}
