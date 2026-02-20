package org.akhil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    // The important thing to observe here is the definition of special string, by careful observation we can identify below 2 points
    // First is every special string has to start 1 to be special.
    // and second is every string has to end with 0 to be special.
    // Now as per question we can swap special substrings inside the given special string, which indirectly pointing us to check special strings inside
    // given special substring, So sub-problem inside given problem means recursion.
    // For lexicographically largest string we will need more 1's in front of the string, That we can achieve by using sorting.

    // O(N^2)/O(N)
    public String makeLargestSpecial(String s) {
        List<String> specialStrings = new ArrayList<>();
        int start = 0;      // start index of current special string
        int count = 0;      // consider 1 as +1 and 0 as -1 then each special string will give us total count as '0'

        for(int i=0; i<s.length(); i++){
            count = count + (s.charAt(i) == '1' ? 1 : -1);

            if(count == 0){
                String innerStr = s.substring(start+1, i);      // string between current string/input string

                String processedStr = '1'+makeLargestSpecial(innerStr)+'0';     // as we are calling recursion on inner string hence need to wrap the string between '1' and '0'
                specialStrings.add(processedStr);
                start = i+1;
            }
        }

        // to get best string lexicographically
        Collections.sort(specialStrings, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();

        for(String str:specialStrings){
            sb.append(str);
        }

        return sb.toString();
    }
}
