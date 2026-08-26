package org.akhil;

public class Solution {
    // O(N^2)/O(1)
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int p1 = 0;
        int p2 = 0;
        String result = "";
        int oneCount = 0;

        while(p2 < n){
            char ch = s.charAt(p2);
            if(ch == '1'){
                oneCount++;
            }

            while(oneCount > k || (p1 < p2 && s.charAt(p1) == '0')){
                if(s.charAt(p1) == '1'){
                    oneCount--;
                }
                p1++;
            }

            if(oneCount == k) {
                String subStr = s.substring(p1, p2 + 1);
                if (result.equals("") || result.length() > subStr.length() || (result.length() == subStr.length() && subStr.compareTo(result) < 0)) {
                    result = subStr;
                }
            }
            p2++;
        }
        return result;
    }
}
