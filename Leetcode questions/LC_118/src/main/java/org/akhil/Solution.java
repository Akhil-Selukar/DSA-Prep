package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(List.of(1));

        for(int i=0; i<numRows-1; i++){
            List<Integer> previousRow = new ArrayList<>();
            previousRow.add(0);
            previousRow.addAll(answer.get(answer.size()-1));
            previousRow.add(0);

            List<Integer> newList = new ArrayList<>();
            for(int j=0; j<previousRow.size()-1; j++){
                newList.add(previousRow.get(j) + previousRow.get(j+1));
            }
            answer.add(newList);
        }
        return answer;
    }
}
