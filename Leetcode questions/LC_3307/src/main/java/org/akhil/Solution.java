package org.akhil;

public class Solution {

    // Solution-1 (TLE)
    // Even though it is giving TLE but anyway it will not work for test cases where k > Integer.MAX_VALUE;
//    public char kthCharacter(long k, int[] operations) {
//        StringBuilder sb = new StringBuilder("a");
//        int n = operations.length;
//
//        int i = 0;
//        while(i<n && sb.length() < k){
//            int size = sb.length();
//
//            if(operations[i] == 0){
//                for(int j=0; j<size; j++){
//                    sb.append(sb.charAt(j));
//                }
//            } else {
//                for(int j=0; j<size; j++){
//                    char ch = sb.charAt(j);
//
//                    if(ch == 'z'){
//                        sb.append('a');
//                    } else {
//                        sb.append((char)(ch+1));
//                    }
//                }
//            }
//            i++;
//        }
//
//        return sb.charAt((int) (k-1));
//    }


    // Solution 2 - Using maths and observations
    // O(logK)/O(1)
    public char kthCharacter(long k, int[] operations) {
        int totalShifts = 0;

        while(k != 1){
            int turnNo = (int) Math.ceil(Math.log(k)/Math.log(2));
            long partitionIndex = (long)Math.pow(2, turnNo-1);
            long correspondingIndexInLHS = k - partitionIndex;
            int operationIndex = turnNo-1;

            totalShifts = totalShifts + operations[operationIndex];

            k = correspondingIndexInLHS;
        }

        int finalShiftsNeeded = totalShifts % 26;

        return (char)('a'+finalShiftsNeeded);
    }
}
