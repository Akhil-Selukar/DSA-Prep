package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    // Solution 1
//    public String convert(String s, int numRows) {
//
//        if(numRows == 1 || numRows >= s.length()){
//            return s;
//        }
//
//        String[] arr = new String[numRows];
//        int direction = 1;
//        int index = 0;
//
//        for(int i=0; i<numRows; i++){
//            arr[i] = "";
//        }
//
//        for(char ch:s.toCharArray()){
//            arr[index] = arr[index]+ch;
//            if(index == 0){
//                direction = 1;
//            }
//            if(index == numRows-1){
//                direction = -1;
//            }
//            index = index + direction;
//        }
//        StringBuilder sb = new StringBuilder();
//        for(String str:arr){
//            sb.append(str);
//        }
//
//        return sb.toString();
//    }

    // Solution 2 - In above solution instead of creating new string every time in for each loop we can use char array
    // and save the code from creating new string each time like below. (Approach is same just the data structure is different but it makes difference)
    public String convert(String s, int numRows) {
        if(numRows == 1 || numRows >= s.length()){
            return s;
        }

        List<Character>[] arr = new ArrayList[numRows];
        int direction = 1;
        int index = 0;

        for(int i=0; i<numRows; i++){
            arr[i] = new ArrayList();
        }

        for(char ch:s.toCharArray()){
            arr[index].add(ch);
            if(index == 0){
                direction = 1;
            }
            if(index == numRows-1){
                direction = -1;
            }
            index = index + direction;
        }
        StringBuilder sb = new StringBuilder();
        for(List<Character> str:arr){
            for(char ch:str){
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}
