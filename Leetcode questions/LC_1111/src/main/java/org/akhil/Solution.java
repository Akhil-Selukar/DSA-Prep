package org.akhil;

import java.util.ArrayList;
import java.util.List;

class Solution {
    // O(N)/O(N)
    public int[] maxDepthAfterSplit(String seq) {
        List<Integer> firstGroup = new ArrayList<>();
        int firstDepth = 0;
        List<Integer> secondGroup = new ArrayList<>();
        int secondDepth = 0;

        for(int i=0; i<seq.length(); i++){
            if(seq.charAt(i) == '('){       // we have to add this in one of the group (i.e. group with smallest depth - to minimize the max depth of both the groups)
                if(firstGroup.size() == 0 || firstDepth <= secondDepth){    // prioritize first group
                    firstGroup.add(i);
                    firstDepth++;
                } else {
                    secondGroup.add(i);
                    secondDepth++;
                }
            } else {        // we got a closing bracket - reduce depth in one of the group which has max depth - to minimize overall max
                if(secondDepth > firstDepth){
                    secondGroup.add(i);
                    secondDepth--;
                } else {
                    firstGroup.add(i);
                    firstDepth--;
                }
            }
        }

        int[] result = new int[seq.length()];

        for(int index:firstGroup){
            result[index] = 0;
        }
        for(int index:secondGroup){
            result[index] = 1;
        }

        return result;
    }
}
