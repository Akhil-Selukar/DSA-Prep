package org.akhil;

public class Solution {
//    // Solution 1 - Bruteforce (TLE)
//    // O(N^3)/O(1)
//    public int numberOfSubstrings(String s) {
//        int result = 0;
//        for(int i=0; i<s.length(); i++){
//            for(int j=i; j<s.length(); j++){
//                if(isDominant(s, i, j)){
//                    result++;
//                }
//            }
//        }
//        return result;
//    }
//
//    private boolean isDominant(String s, int start, int end){
//        int zeroCount = 0;
//        int oneCount = 0;
//
//        for(int i=start; i<=end; i++){
//            if(s.charAt(i) == '0'){
//                zeroCount++;
//            } else {
//                oneCount++;
//            }
//        }
//
//        if((zeroCount * zeroCount) <= oneCount){
//            return true;
//        }
//        return false;
//    }


    // --------------
    // Solution 2 - Bruteforce with pre computation of no of ones (TLE)
    // O(N^2)/O(N)
//    public int numberOfSubstrings(String s) {
//        int result = 0;
//
//        // count the prefix sum of ones
//        int[] oneCount = new int[s.length()];
//        oneCount[0] = s.charAt(0)-'0';
//
//        for(int i=1; i<s.length(); i++){
//            oneCount[i] = oneCount[i-1] + (s.charAt(i)-'0');
//        }
//
//        for(int i=0; i<s.length(); i++){
//            for(int j=i; j<s.length(); j++){
//                if(isDominant(oneCount, i, j)){
//                    result++;
//                }
//            }
//        }
//        return result;
//    }
//
//    private boolean isDominant(int[] oneCount, int start, int end){
//        int ones = oneCount[end];
//        if(start > 0){
//            ones = ones - oneCount[start-1];
//        }
//        int zeros = (end - start + 1) - ones;
//
//        if((zeros * zeros) <= ones){
//            return true;
//        }
//        return false;
//    }


    // ---------------------
    // Solution 3 - With rapid movement of j pointer
    // O(N^2)/O(N)
    public int numberOfSubstrings(String s) {
        int result = 0;

        // count the prefix sum of ones
        int[] oneCount = new int[s.length()];
        oneCount[0] = s.charAt(0)-'0';

        for(int i=1; i<s.length(); i++){
            oneCount[i] = oneCount[i-1] + (s.charAt(i)-'0');
        }

        for(int i=0; i<s.length(); i++){
            for(int j=i; j<s.length(); j++){
                int ones = oneCount[j];
                if(i > 0){
                    ones = ones - oneCount[i-1];
                }
                int zeros = (j - i + 1) - ones;

                int sqOfZeros = (zeros * zeros);

                // case 1 - non dominant string
                if(sqOfZeros > ones){       // not a dominant string
                    int onesNeeded = sqOfZeros - ones;
                    // as we need at least 'onesNeeded' ones hence j has to at least move that many times (jumping of j)
                    j = j + onesNeeded - 1;         // -1 because j++ will happen as a part of loop increment
                } else if(sqOfZeros == ones) {      // case 2 - dominant with exact match count
                    result++;
                } else {        // case 3 - dominant with more 1's than required
                    result++;

                    int placesWeCanShift = (int)Math.sqrt(ones) - zeros;        // try this equation on paper
                    int nextPossibleJ = j + placesWeCanShift;

                    if(nextPossibleJ >= s.length()){        // next possible j is OOB
                        result = result + (s.length() - j - 1);
                        break;
                    } else {
                        result = result + placesWeCanShift;
                    }

                    j = nextPossibleJ;
                }
            }
        }
        return result;
    }
}
