package org.akhil;

public class Solution {
    // Here with some observations we can find that if lcp[i][j] = 4 i.e. if we arrange the string in grid fashion then in horizontal direction from
    // jth index and in vertical direction from ith index whatever strings we are getting those string has same prefix of length 4.
    // so if the strings are abcde and abcdz and i and j both are 0 and 0 then strings in consideration will be abcde and abcdz so we have same prefix of 4 length.
    // now if we move ahead in both the string (i.e. i+1 and j+1) so from 1 and 1 the strings will be bcde and bcdz so common prefix length will be 3
    // if we again move ahead then it will be 2 and then 1 so simple observation here will be if the matrix represent actual valid string then it has to
    // follow below rule `lcp[i][j] == lcp[i+1][j+1] + 1`
    // also as the strings at both direction (horizontal and vertical) are same so it has to follow lcp[i][j] == lcp[j][i]

    // Another important observation is if we need a string of length n and lcp[i][j] is a non-zero value that means the string has the same character
    // at ith and jth index and if lcp[i][j] == 0 then it has different character at ith and jth index

    public String findTheString(int[][] lcp) {
        int n = lcp.length;
        char[] chars = new char[n];

        // construct the string
        int charCount = 0;
        char ch = 'a';
        for(int i=0; i<n; i++){
            if(chars[i] > 0){       // means the char is already assigned at the index by previous assertion
                continue;
            }
            if(ch > 'z') {
                return "";
            }

            chars[i] = ch;
            for(int j=i+1; j<n; j++) {
                if(lcp[i][j] > 0) {
                    chars[j] = chars[i];
                }
            }
            ch++;
        }

        // check if given LCP can form a valid string or not
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                int prefix;
                if(chars[i]==chars[j]) {
                    int prevPref = 0;
                    if(i==n-1 || j==n-1)
                        prevPref = 0;
                    else prevPref = lcp[i+1][j+1];
                    prefix = 1 + prevPref;
                }
                else prefix = 0;
                if(prefix != lcp[i][j])
                    return "";
            }
        }

        return String.valueOf(chars);
    }
}
