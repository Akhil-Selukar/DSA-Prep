package org.akhil;

import java.util.*;

public class Solution {
    // O(N*L + L*NlogN)/O(N*L)   dominated by sorting
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String[]> valid = new ArrayList<>();
        Set<String> businessLines = new HashSet<>(Arrays.asList("electronics", "grocery", "pharmacy", "restaurant"));

        for(int i=0; i<code.length; i++){
            if(isActive[i] && businessLines.contains(businessLine[i]) && isValid(code[i])){
                valid.add(new String[]{code[i], businessLine[i]});
            }
        }

        Collections.sort(valid, (a, b) ->{
            if(a[1].equals(b[1])){
                return a[0].compareTo(b[0]);
            }
            return a[1].compareTo(b[1]);
        });

        List<String> result = new ArrayList();
        for(String[] validCoupon:valid){
            result.add(validCoupon[0]);
        }

        return result;
    }

    private boolean isValid(String code) {
        for(char ch:code.toCharArray()){
            if((ch >= '0' && ch <='9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch == '_')){
                continue;
            }
            return false;
        }
        return code.length() != 0;
    }
}
