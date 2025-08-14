package org.akhil;

public class Solution {
    // Solution 1 - Using StringBuilder
    // O(N)/O(1)
//    public String largestGoodInteger(String num) {
//        int max = Integer.MIN_VALUE;
//        StringBuilder sb = new StringBuilder("");
//
//        for(int i=2; i<num.length(); i++){
//            if(num.charAt(i-2) == num.charAt(i-1) && num.charAt(i-1) == num.charAt(i)){
//                int val = Integer.parseInt(num.substring(i-2,i+1));
//                if(val > max){
//                    max = val;
//                    sb = new StringBuilder();
//                    sb.append(num.charAt(i));
//                    sb.append(num.charAt(i));
//                    sb.append(num.charAt(i));
//                }
//
//            }
//        }
//
//        return sb.toString();
//    }

    // ----------------
    // Solution 2 - Without using StringBuilder
    // O(N)/O(1)
    // O(N)/O(1)
    public String largestGoodInteger(String num) {
        int max = Integer.MIN_VALUE;
        String result = "";

        for(int i=2; i<num.length(); i++){
            if(num.charAt(i-2) == num.charAt(i-1) && num.charAt(i-1) == num.charAt(i)){
                int val = Integer.parseInt(num.substring(i-2,i+1));
                if(val > max){
                    max = val;
                    result = num.substring(i-2, i+1);
                }

            }
        }

        return result;
    }
}
