package org.akhil;

public class Solution {
    // as we need lexicographically smallest permutation but greater than target (this is imp). So if we have 'b' at 0th
    // index in our target then we can not put anything less than 'b' in our answer so we know that answer will have at-least
    // 'b' at 0th index. similarly at 1st index if we have 'f' then answer will have at-least 'f' at 1st index, nothing less than
    // 'f' is allowed.
    // So we can try filling each index of result with minimum possible char (id available). If available because we need
    // to make sure that the result should be permutation of given string s. If current char is not possible then we will check
    // for next greater available char.
    // now as we are checking from char greater than or EQUAL TO current char in target, so we can end up in getting same
    // string as that of target in result, (for example s = "abab" target = "bbaa" we will get "bbaa" as resulting string
    // but it is mentioned in question that we need Strictly greater than target. So in this case we need to backtrack and try
    // some other chars for example in case of s="abcd" target="bcda" result="bcda" we need to backtrack and change 1st index
    // char to "d" so result = "bdac". (now here it is important that as soon as we found first greater char in result which is
    // different than target, we simply need to add all remaining chars from given string in smallest to greatest order. Hence
    // added "ac" and not "ca") So we need to make sure we are tracing if we have found the 1st differentiating char or not.
    // Now there is an edge case where even after backtracking we might not able to find the answer like s="bbaa" target="bbaa"
    // we can not get any other string than "bbaa" as result. So this is not strictly greater than target. in this case we need
    // to return "" (i.e. empty string)

    String result = "";
    public String lexGreaterPermutation(String s, String target) {
        int[] count = new int[26];

        // keep track of available chars (these are the only ones we can use)
        for(char ch:s.toCharArray()){
            count[ch-'a']++;
        }

        // try filling result greedily
        StringBuilder currStr = new StringBuilder();
        helper(target, count, currStr, 0, false);

        return result;
    }

    private boolean helper(String target, int[] count, StringBuilder currStr, int index, boolean isGreaterFound){
        // if we are at the end of target and greater was found then we found the result
        if(index == target.length()){
            if(isGreaterFound){
                result = currStr.toString();
                return true;
            }
            return false;
        }

        // check all chars
        for(char ch='a'; ch<='z'; ch++){
            // if this char is not available then move ahead or if this char is not suitable at current index then aswell move ahead
            if(count[ch-'a'] == 0 || (ch < target.charAt(index) && !isGreaterFound)){
                continue;
            }

            // if this char can be taken then add it in currStr and reduce the count
            currStr.append(ch);
            count[ch-'a']--;

            boolean isThisGreater = isGreaterFound || ch > target.charAt(index);

            // explore for next index
            if(helper(target, count, currStr, index+1, isThisGreater)){
                return true;    // if we have an answer then no need to backtrack simply return from here and exit the helper function
            }

            // else backtrack
            currStr.deleteCharAt(currStr.length()-1);
            count[ch-'a']++;    // make the char available again
        }

        return false;   // no matter what we are not able to get answer
    }
}
