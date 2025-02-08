package org.akhil;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    // Solution - 1 (O(N)/O(N)) where N is the number of digits in given number. Even though space complexity can be
    // called as O(1) but is not O(1) because number of values in sb depends on how many digits we have in num.
//    final Map<Integer, String> map = new HashMap<>();
//    {
//        map.put(1,"I");
//        map.put(5,"V");
//        map.put(10,"X");
//        map.put(50,"L");
//        map.put(100,"C");
//        map.put(500,"D");
//        map.put(1000,"M");
//    }
//    public String intToRoman(int num) {
//        int multi = 1;
//        StringBuilder sb = new StringBuilder();
//
//        while(num>0){
//            int digit = num%10;
//            int placeValue = digit * multi;
//
//            convert(sb, placeValue, multi);
//
//            multi = multi * 10;
//            num = num / 10;
//        }
//
//        return sb.reverse().toString();
//    }
//
//    private void convert(StringBuilder sb, int placeValue, int multi){
//        int last = placeValue/multi;
//
//        if(last == 4 || last == 9){
//            sb.append(map.get(placeValue + multi));
//            sb.append(map.get(multi));
//        } else {
//            while(placeValue > 0){
//                if(placeValue/multi == 5){
//                    sb.append(map.get(placeValue));
//                    placeValue = placeValue - (5*multi);
//                } else {
//                    sb.append(map.get(multi));
//                    placeValue = placeValue - multi;
//                }
//            }
//        }
//    }

    // Solution 2 - Space and time complexity will be same only as above code but this will perform better because of less complexity and conditional statements.
    public String intToRoman(int num) {
        final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        final String[] symbols = {"M", "CM", "D",  "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            if (num == 0)
                break;
            while (num >= values[i]) {
                sb.append(symbols[i]);
                num -= values[i];
            }
        }

        return sb.toString();
    }
}
