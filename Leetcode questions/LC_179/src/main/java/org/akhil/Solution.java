package org.akhil;

import java.util.Arrays;

public class Solution {
    public String largestNumber(int[] nums) {
        String[] str = new String[nums.length];

        for(int i=0; i<nums.length; i++){
            str[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(str, (a, b)->(b+a).compareTo(a+b));
//        System.out.println(Arrays.toString(str));

//        return str[0].equals("0") ? "0" : String.join("",str);

        if(str[0].equals("0")){
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for(String s:str){
            sb.append(s);
        }
        return sb.toString();
    }
}
