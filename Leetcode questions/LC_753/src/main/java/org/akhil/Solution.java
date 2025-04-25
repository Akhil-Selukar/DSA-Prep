package org.akhil;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

// O(K^N)/O(K^N)
public class Solution {
    public String crackSafe(int n, int k) {
        StringBuilder sb = new StringBuilder();         // to store the generated password string.
        // fill in n '0' in sb as n 0's is one of the possible password
        String firstPass = String.join("", Collections.nCopies(n, "0"));        // you can use a simple for loop as well here
        sb.append(firstPass);

        Set<String> consideredPass = new HashSet<>();
        consideredPass.add(firstPass);

        // graph dfs
        helper(sb, consideredPass, n, k, (long)Math.pow(k, n));

        return sb.toString();
    }

    private boolean helper(StringBuilder sb, Set<String> consideredPass, int n, int k, long possibleComb) {
        if(possibleComb == consideredPass.size()){
            return true;
        }

        String currPass = sb.substring(sb.length() - n + 1);        // last n-1 chars of previous password (will add 1 new char to generate new pass)

        // explore all allowed chars (i.e. from 0 to k-1) with currPass.
        for(char ch = '0'; ch < ('0'+k); ch++){
            String newPass = currPass+ch;
            if(!consideredPass.contains(newPass)){
                consideredPass.add(newPass);
                sb.append(ch);

                if(helper(sb, consideredPass, n, k, possibleComb)){
                    return true;
                }
                // backtrack (if further traversal is not possible down the current path and we have not explored all possible passwords (i.e. base condition))
                consideredPass.remove(newPass);
                sb.deleteCharAt(sb.length()-1);
            }
        }
        return false;
    }
}
