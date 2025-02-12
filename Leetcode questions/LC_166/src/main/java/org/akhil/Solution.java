package org.akhil;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    // (O(N)/O(N))
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0){
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        long quotient = 0;
        long remainder = 0;

        if((numerator < 0) ^ (denominator < 0)){
            sb.append('-');         // if any one (either numerator or denominator) is -ve then answer will be negative.
        }

        long nume = Math.abs((long)numerator);
        long deno = Math.abs((long)denominator);

        quotient = nume / deno;
        remainder = nume % deno;

        sb.append(quotient);
        if(remainder == 0){         // case 1 if numerator is completely divisible by denominator hence no need to check further for remainder and there will not be any decimal value in answer.
            return sb.toString();
        }

        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();

        while(remainder != 0){
            if(!map.containsKey(remainder)){
                map.put(remainder, sb.length());          // added remainder at (sb.length())th place in final answer. So that if in case of repetition we need to add bracket, we will have the place/index where bracket need to be added.
                remainder = remainder * 10;
                quotient = remainder / deno;
                remainder = remainder % deno;
                sb.append(quotient);
            } else {
                int index = map.get(remainder);
                sb.insert(index, "(");      // Inserting "(" at specific index.
                sb.append(")");                 // closing bracket at end.

                return sb.toString();
            }
        }

        return sb.toString();
    }
}
