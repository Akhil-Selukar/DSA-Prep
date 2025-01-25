package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> current = new ArrayList<>();
        current.add(1);

        for(int i=0; i<rowIndex; i++){
            List<Integer> previous = new ArrayList<>();

            previous.add(0);
            previous.addAll(current);
            previous.add(0);

            current = new ArrayList<>();

            for(int j=0; j<previous.size()-1; j++){
                current.add(previous.get(j) + previous.get(j+1));
            }
        }
        return current;
    }
}
