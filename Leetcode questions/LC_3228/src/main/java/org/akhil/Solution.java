package org.akhil;

public class Solution {
    // Solution 1 - Greedy (Using extra space to store countOfGaps (i.e. how many segments of 0's are there to the right of current element. Sort of prefix sum in reverse direction))
    // O(N)/O(N)
//    public int maxOperations(String s) {
//        // s = "1001101"
//        int n = s.length();
//        int[] count = new int[n+1];
//
//        for(int i=n-1; i>=0; i--){
//            if(s.charAt(i) == '0'){
//                count[i] = 1;
//                while(i>=0 && s.charAt(i) == '0'){
//                    count[i] = count[i] + count[i+1];
//                    i--;
//                }
//                i++;
//            } else {
//                while(i>=0 && s.charAt(i) == '1'){
//                    count[i] = count[i] + count[i+1];
//                    i--;
//                }
//                i++;
//            }
//        }
//
//        int result = 0;
//        for(int i=0; i<n; i++){
//            if(s.charAt(i) == '1'){
//                result = result + count[i];
//            }
//        }
//        return result;
//    }

    // -------------------
    // Solution 1.1 - Greedy (Same concept as above but cleaned code
    // O(N)/O(N)
//    public int maxOperations(String s) {
//        // s = "1001101"
//        int n = s.length();
//        int[] count = new int[n+1];
//
//        for(int i=n-1; i>=0; i--){
//            char currChar = s.charAt(i);
//            if(currChar == '0'){
//                count[i] = 1;
//            }
//
//            while(i>=0 && s.charAt(i) == currChar){
//                count[i] = count[i] + count[i+1];
//                i--;
//            }
//            i++;
//        }
//
//        int result = 0;
//        for(int i=0; i<n; i++){
//            if(s.charAt(i) == '1'){
//                result = result + count[i];
//            }
//        }
//        return result;
//    }


    // -------------------
    // Solution 2 - Greedy (Without using extra space)
    // Same concept we can use by counting 1's and using loop from i=0 to i<n
    // O(N)/O(1)
    public int maxOperations(String s) {
        // s = "1001101"
        int n = s.length();
        int countOfZeroSeg = 0;     // holds the count of segments of 0's to the right of current element
        int result = 0;

        for(int i=n-1; i>=0; i--){
            if(s.charAt(i) == '0'){
                countOfZeroSeg++;

                // we don't want to count actual 0's but we want segments of 0's hence once incremented skip all continuous 0's
                while(i>=0 && s.charAt(i) == '0'){
                    i--;
                }
            }

            if(i>=0 && s.charAt(i) == '1'){
                result = result + countOfZeroSeg;
            }
        }

        return result;
    }
}
