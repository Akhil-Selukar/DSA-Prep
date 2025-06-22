package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    // Solution 1 - bruteforce
    // TC - O(N)
    // SC - O(N)
//    public String[] divideString(String s, int k, char fill) {
//        List<String> list = new ArrayList<>();
//
//        for(int i=0; i<s.length();){
//            int upperBound = i+k;
//            StringBuilder sb = new StringBuilder();
//            while(i<upperBound){
//                if(i < s.length()) {
//                    sb.append(s.charAt(i));
//                } else {
//                    sb.append(fill);
//                }
//                i++;
//            }
//            list.add(sb.toString());
//        }
//
//        String[] result = new String[list.size()];
//        int i=0;
//        for(String str:list){
//            result[i] = str;
//            i++;
//        }
//
//        return result;
//    }


    // Solution 2 - same concept but modified implementation
    // O(N)/O(N)
    public String[] divideString(String s, int k, char fill) {
        StringBuilder sb = new StringBuilder(s);

        while(sb.length() % k != 0){
            sb.append(fill);
        }

        String[] result = new String[sb.length()/k];

        for(int i=0; i<sb.length()/k; i++){
            result[i] = sb.substring(i*k, (i+1)*k);
        }

        return result;
    }
}
