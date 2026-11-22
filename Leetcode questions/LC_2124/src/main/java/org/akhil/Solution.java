package org.akhil;

public class Solution {
    // O(N)/O(1)
     public boolean checkString(String s) {

         int firstIndexOfB = Integer.MAX_VALUE;
         int lastIndexOfA = Integer.MIN_VALUE;

         for(int i=0; i<s.length(); i++){
             if(s.charAt(i) == 'a'){
                 lastIndexOfA = i;
             } else {
                 firstIndexOfB = Math.min(firstIndexOfB, i);
             }
         }

         return lastIndexOfA < firstIndexOfB;
     }

    // -----------------------
//    public boolean checkString(String s) {
//        int firstIndexOfB = s.indexOf('b');
//        int lastIndexOfA = s.lastIndexOf('a');
//
//        return firstIndexOfB < 0 || lastIndexOfA < 0 || lastIndexOfA < firstIndexOfB;
//    }
}
