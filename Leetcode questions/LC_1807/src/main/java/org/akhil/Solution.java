package org.akhil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    // O(N+M)/O(N) where N is length of s and M is number of elements in knowledge
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> dict = new HashMap<>();

        for(List<String> pair:knowledge){
            dict.put(pair.get(0), pair.get(1));
        }

        StringBuilder temp = new StringBuilder();
        StringBuilder result = new StringBuilder();
        int n = s.length();

        for(int i=0; i<n; i++){
            if(s.charAt(i) == '('){
                i++;
                while(i<n && s.charAt(i) != ')'){
                    temp.append(s.charAt(i));
                    i++;
                }

                if(dict.containsKey(temp.toString())){
                    result.append(dict.get(temp.toString()));
                } else {
                    result.append("?");
                }
                temp.setLength(0);
            } else {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }
}
