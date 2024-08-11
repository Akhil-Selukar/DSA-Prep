package org.akhil;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};

        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        int[] countArray = new int[10000];
        ArrayList<Integer> elements = new ArrayList<>();

        for(int num:nums1){
            countArray[num] = 1;
        }

        for(int num:nums2){
            if(countArray[num] == 1){
                countArray[num] = 2;
            }
        }

        for (int i = 0; i < countArray.length; i++) {
            if(countArray[i]==2){
                elements.add(i);
            }
        }

        int[] ans = new int[elements.size()];

        for(int i=0; i< elements.size(); i++){
            ans[i] = elements.get(i);
        }

        return ans;
    }
}