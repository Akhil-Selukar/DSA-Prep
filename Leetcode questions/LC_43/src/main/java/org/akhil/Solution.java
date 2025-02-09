package org.akhil;

public class Solution {

    // O(M*N)/O(M+N)
    public String multiply(String num1, String num2) {
        // create an array to hold the product
        int n = num1.length();
        int m = num2.length();

        int[] ans = new int[n+m];

        // multiply digit by digit
        for(int i=m-1; i>=0; i--){      // each digit of one number
            for(int j=n-1; j>=0; j--){  // with each digit of second number
                int product = (num2.charAt(i)-'0') * (num1.charAt(j)-'0');
                int sum = ans[i+j+1] + product;         // add previous carry to the product and then calculate new value and carry.

                ans[i+j+1] = sum % 10;
                ans[i+j] = ans[i+j] + sum / 10;
            }
        }

        // remove 0's from start. (00012345 ans should be 112345 only)
        StringBuilder sb = new StringBuilder();
        for(int val:ans){
            if(!(sb.length() == 0 && val == 0)){
                sb.append(val);
            }
        }

//        return sb.toString();
        return sb.length() == 0 ? "0" : sb.toString();      // to handle edge case any of the number is 0 then whole ans will be 0 and sb will be empty.
    }
}
