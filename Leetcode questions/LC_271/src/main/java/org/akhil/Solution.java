package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    // Solution
    // O(L)/O(L) where L is the total of length's of all strings in strs.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for(String str:strs){
            int length = str.length();      // here as per constraints the length can be at max 200 (in ASCII system we have unique char for each value till 256)
            sb.append((char)length);        // as we have unique char till 256 in ASCII hence this will work. (check decoding part as well)
            sb.append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();

        // as we know that before each unique string we have a ASCII char whos int value denotes the length of string.
        int i=0;

        while(i<str.length()){
            int length = (int)str.charAt(i);

            result.add(str.substring(i+1, i+1+length));
            i = i + length+1;
        }

        return result;
    }
}
