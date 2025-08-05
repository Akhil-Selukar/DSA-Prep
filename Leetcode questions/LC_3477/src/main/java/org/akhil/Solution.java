package org.akhil;

public class Solution {

//    // Solution 1 - bruteforce
//    // O(N^2)/O(1)
//    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
//        int count = 0;
//
//        for(int fruit:fruits){
//            for(int i=0; i<baskets.length; i++){
//                if(fruit <= baskets[i]){
//                    baskets[i] = 0;
//                    break;
//                }
//                if(i == baskets.length-1){
//                   count++;
//                }
//            }
//        }
//        return count;
//    }

    //------------------------

    // Solution 2 - same concept but reduced 1 if check
    // O(N^2)/O(1)
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int count = 0;

        for(int fruit:fruits){
            for(int i=0; i<baskets.length; i++){
                if(fruit <= baskets[i]){
                    baskets[i] = 0;
                    count++;
                    break;
                }
            }
        }
        return baskets.length - count;
    }
}
