package org.akhil;

public class Solution {

    // O(N)/O(N) // O(N) space because we are creating new string of size 2N, 2 is constant hence we can drop it.
    public boolean repeatedSubstringPattern(String s) {
        String concatenated = s+s;

        if(concatenated.substring(1, concatenated.length()-1).contains(s)){
            return true;
        }

        return false;
    }

    /*
    Explanation - The reason this solution works is, if the string is created by repeating a sequence of character then
    that means the last character of the string must be the last character in repeating char sequence. Hence if we add
    same string again then it should again repeat the char sequence from start. Now next is we are removing first and
    last character from the concatenated string which will make the two strings which are concatenated different and
    if the string is valid then because of last part of first string and first part of second string we will get the original
    string exactly at the middle of the combined string.

    This also impact the time complexity, here we are using contains() method of string which in worst case has time complexity
    of O(M*N) where M is length of original string and N is length of search string. But here we know that if the string is
    present then it will start before the middle char of combined string hence in no circumstances we will have to search
    till the end we have to iterate at max N times hence time complexity is O(N) here.
     */
}
