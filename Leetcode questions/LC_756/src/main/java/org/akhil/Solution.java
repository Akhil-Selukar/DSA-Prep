package org.akhil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

//    // Solution 1 - without memoization (Accepted)
//    // TC -> O(A+6^N) where A is the length of allowed list O(A) because of pre-computation of possibleStruct map and in constraints
//    // it is given that the structure can have only A-F so total 6 possible chars and base can be of maximum length 6 hence at max there can be 6
//    // possible structures for each base hence 6^N where N is the length of bottom layer.
//    // SC -> O(A) plus there will be recursive stack space.
//    public boolean pyramidTransition(String bottom, List<String> allowed) {
//        // we need to check for all allowed top part on the bottom structure we have, so either we can check all chars by placing them on the
//        // bottom structure we have (which will not be efficient) or we can precompute which are the allowed top parts for a particular bottom structure.
//        Map<String, List<Character>> possibleStruct = new HashMap<>();
//
//        for(String str:allowed){
//            String base = str.substring(0,2);
//            char top = str.charAt(2);
//
//            if(!possibleStruct.containsKey(base)){
//                possibleStruct.put(base, new ArrayList<>());
//            }
//            possibleStruct.get(base).add(top);
//        }
//
//        return helper(bottom, possibleStruct, 0, new StringBuilder());
//    }
//
//    private boolean helper(String bottom, Map<String, List<Character>> possibleStruct, int index, StringBuilder sb) {
//        if(bottom.length() == 1){       // means we are at the top of the pyramid and it is completed.
//            return true;
//        }
//
//        // reach the end of current layer
//        if(index == bottom.length()-1){
//            // call for next layer
//            boolean result = helper(sb.toString(), possibleStruct, 0, new StringBuilder());
//            return result;
//        }
//
//        // check for the base at current index and find of any top is allowed or not.
//        String currBase = bottom.substring(index, index+2);     // extracting index and index+1 char from bottom
//
//        if(!possibleStruct.containsKey(currBase)){      // if no allowed top present for current base.
//            return false;
//        }
//
//        // if there are allowed top then check for all of them
//        for(char ch:possibleStruct.get(currBase)){
//            sb.append(ch);
//            // check for next base at same level i.e. index+1
//            if(helper(bottom, possibleStruct, index+1, sb)){
//                return true;        // if we are able to reach till top by using this path.
//            }
//
//            // else backtrack
//            sb.deleteCharAt(sb.length()-1);
//        }
//
//        return false;
//    }


    // ----------------------------
    // Solution 2 - with memoization (Optimized)
    // Complexity will be same still this is faster as some computations are reduced here
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        // we need to check for all allowed top part on the bottom structure we have, so either we can check all chars by placing them on the
        // bottom structure we have (which will not be efficient) or we can precompute which are the allowed top parts for a particular bottom structure.
        Map<String, List<Character>> possibleStruct = new HashMap<>();
        Map<String, Boolean> dp = new HashMap<>();

        for(String str:allowed){
            String base = str.substring(0,2);
            char top = str.charAt(2);

            if(!possibleStruct.containsKey(base)){
                possibleStruct.put(base, new ArrayList<>());
            }
            possibleStruct.get(base).add(top);
        }

        return helper(bottom, possibleStruct, 0, new StringBuilder(), dp);
    }

    private boolean helper(String bottom, Map<String, List<Character>> possibleStruct, int index, StringBuilder sb, Map<String, Boolean> dp) {
        if(bottom.length() == 1){       // means we are at the top of the pyramid and it is completed.
            return true;
        }

        String key = bottom + "_" + index + "_" + sb.toString();
        if(dp.containsKey(key)){
            return dp.get(key);
        }

        // reach the end of current layer
        if(index == bottom.length()-1){
            // call for next layer
            boolean result = helper(sb.toString(), possibleStruct, 0, new StringBuilder(), dp);
            dp.put(key, result);
            return result;
        }

        // check for the base at current index and find of any top is allowed or not.
        String currBase = bottom.substring(index, index+2);     // extracting index and index+1 char from bottom

        if(!possibleStruct.containsKey(currBase)){      // if no allowed top present for current base.
            dp.put(key, false);
            return false;
        }

        // if there are allowed top then check for all of them
        for(char ch:possibleStruct.get(currBase)){
            sb.append(ch);
            // check for next base at same level i.e. index+1
            if(helper(bottom, possibleStruct, index+1, sb, dp)){
                dp.put(key, true);
                return true;        // if we are able to reach till top by using this path.
            }

            // else backtrack
            sb.deleteCharAt(sb.length()-1);
        }

        dp.put(key, false);
        return false;
    }
}
