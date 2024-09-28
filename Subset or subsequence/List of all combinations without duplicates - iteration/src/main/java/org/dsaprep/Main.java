package org.dsaprep;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,3,2,3};
        List<List<Integer>> ans = subsetDuplicates(arr);

        for(List<Integer> list:ans){
            System.out.println(list);
        }
    }

    protected static List<List<Integer>> subsetDuplicates(int[] arr){
        Arrays.sort(arr);
        List<List<Integer>> outerList = new ArrayList<>();
        outerList.add(new ArrayList<>());
        int startIndex = 0;
        int endIndex = 0;
        for(int i=0; i<arr.length; i++){
            if(i>0 && arr[i] == arr[i-1]){
                startIndex = endIndex+1;
            }
            endIndex = outerList.size()-1;
            for(int j=startIndex; j<=endIndex; j++){
                List<Integer> innerList = new ArrayList<>(outerList.get(j));
                innerList.add(arr[i]);
                outerList.add(innerList);
            }
        }
        return outerList;
    }
}