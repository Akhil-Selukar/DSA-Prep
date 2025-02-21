package org.akhil;

public class Solution {

    // Solution 1 - O(N)/O(N)
//    public String licenseKeyFormatting(String s, int k) {
//        StringBuilder sb = new StringBuilder();
//        int n = s.length();
//        int count = 0;
//        for(int i=n-1; i>=0; i--){
//            if(s.charAt(i) == '-'){
//                continue;
//            } else {
//                if(count == k){
//                    sb.append('-');
//                    count = 0;
//                    i++;
//                } else {
//                    sb.append(Character.toUpperCase(s.charAt(i)));
//                    count++;
//                }
//            }
//        }
//
//        return sb.reverse().toString();
//    }

    // Solution 2 - O(N)/O(N)   (even though the code look a small and time complexity is same but here in each iteration we are
    // calculating length of sb which adds onto a bit of extra time. So this solution will be a bit slower than the first one.

    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();

        for(int i=n-1; i>=0; i--){
            if(s.charAt(i) != '-'){
                sb.append(sb.length() % (k+1) == k?"-":"").append(Character.toUpperCase(s.charAt(i)));
            }
        }
        return sb.reverse().toString();
    }
}
