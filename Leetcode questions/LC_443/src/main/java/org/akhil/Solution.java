package org.akhil;

public class Solution {
    // Solution 1 - O(N)/O(1)
//    public int compress(char[] chars) {
//        int start = 0;
//        int end = 0;
//        int count = 0;
//
//        while(end <= chars.length){
//            if(end == chars.length ||chars[start] != chars[end]){
//                int val = end-start;
//                if(val == 1){
//                    chars[count++] = chars[start];
//                }else if(val > 1 && val <= 9){
//                    chars[count++] = chars[start];
//                    chars[count++] = (char)(val+'0');
//                } else if(val<=99){
//                    chars[count++] = chars[start];
//                    chars[count++] = (char)((val/10)+'0');
//                    chars[count++] = (char)((val%10)+'0');
//                } else if(val <= 999){
//                    chars[count++] = chars[start];
//                    chars[count++] = (char)((val/100)+'0');
//                    chars[count++] = (char)(((val/10)%10)+'0');
//                    chars[count++] = (char)((val%10)+'0');
//                } else {
//                    chars[count++] = chars[start];
//                    chars[count++] = (char)((val/1000)+'0');
//                    chars[count++] = (char)(((val/100)%10)+'0');
//                    chars[count++] = (char)(((val/10)%10)+'0');
//                    chars[count++] = (char)((val%10)+'0');
//                }
//                start = end;
//            }
//            end++;
//        }
//        return count;
//    }

    // Solution 2 - Same complexity but a bit clean code
//    public int compress(char[] chars) {
//        int start = 0;
//        int end = 0;
//        int count = 0;
//
//        while(end <= chars.length){
//            if(end == chars.length ||chars[start] != chars[end]){
//                int val = end-start;
//                String valStr = String.valueOf(val);
//                chars[count++] = chars[start];
//
//                if(val>1){
//                    for(char ch:valStr.toCharArray()){
//                        chars[count++] = ch;
//                    }
//                }
//                start = end;
//            }
//            end++;
//        }
//        return count;
//    }

//     Solution 2 - Same complexity just more concise
    public int compress(char[] chars) {
        int index = 0;
        int count = 1;      // minimum 1 count will be there if char is present in chars.

        for(int i=0; i<chars.length; i++){
            if(i+1 == chars.length || chars[i] != chars[i+1]){
                chars[index++] = chars[i];

                if(count > 1){
                    String strCount = String.valueOf(count);
                    for(char ch:strCount.toCharArray()){
                        chars[index++] = ch;
                    }
                }
                count = 1;      // reset count to 1 for next char.
            } else {
                count++;
            }
        }
        return index;   // index will nothing but the new length.
    }
}
