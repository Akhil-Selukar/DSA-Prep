package org.akhil;

public class Solution {

    // O(N)/O(1)
    public boolean checkRecord(String s) {
        int absentCount = 0;
        int lateCount = 0;

        for(char ch:s.toCharArray()){
            if(ch == 'A'){
                absentCount++;
                if(absentCount >= 2){
                    return false;
                }
                lateCount = 0;
            } else if(ch == 'L'){
                lateCount++;
                if(lateCount >= 3){
                    return false;
                }
            } else {
                lateCount = 0;
            }
        }
        return true;
    }
}
