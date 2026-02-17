package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    // O(1)/O(1)
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();

        for(int hr=0; hr<12; hr++){
            for(int min=0; min<=59; min++){
                if(Integer.bitCount(hr) + Integer.bitCount(min) == turnedOn){
                    StringBuilder sb = new StringBuilder();

                    sb.append(hr);
                    sb.append(":");

                    if(min<10){
                        sb.append("0");
                    }
                    sb.append(min);

                    result.add(sb.toString());
                }
            }
        }
        return result;
    }
}
