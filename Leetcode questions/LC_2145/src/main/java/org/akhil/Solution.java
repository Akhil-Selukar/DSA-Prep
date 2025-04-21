package org.akhil;

public class Solution {

    // Solution 1 - bruteforce
    // time complexity - O((Upper-Lower+1)*(sizeOfDiff+1)) where upper is upperLimit, lower is lower limit +1 for inclusive and sizeOfDiff is size of difference array.
    // space complexity - O(1)
    // as upper and lower has range 10^5 and diff can also have size 10^5 hence this solution will give TLE.
//    public int numberOfArrays(int[] differences, int lower, int upper) {
//        int count = 0;
//        int noOfElements = 0;
//        int n = differences.length+1;
//        int currVal = 0;
//
//        for(int i=lower; i<=upper; i++){
//            currVal = i;
//            noOfElements++;
//            for(int diff:differences){
//                int nextVal = currVal+diff;
//                if((lower <= nextVal) && (nextVal <= upper)){
//                    currVal = nextVal;
//                    noOfElements++;
//
//                    if(noOfElements == n){
//                        count++;
//                        noOfElements = 0;
//                        break;
//                    }
//                } else {
//                    noOfElements = 0;
//                    break;
//                }
//            }
//        }
//
//        return count;
//    }


    // Solution 2 - prefix sum (range of curve vs range of boundaries)
    // O(N)/O(1)
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long lowerRangeOfCurve = 0;
        long higherRangeOfCurve = 0;
        long sum = 0;

        for(int diff:differences){
            sum = sum + diff;
            lowerRangeOfCurve = Math.min(lowerRangeOfCurve, sum);
            higherRangeOfCurve = Math.max(higherRangeOfCurve, sum);
        }

        long curveHeight = higherRangeOfCurve - lowerRangeOfCurve + 1;   // +1 for inclusive range
        long availableRange = upper - lower + 1;     // +1 for inclusive range

        long possibleSolutions = availableRange - curveHeight + 1;

        return (possibleSolutions < 0) ? 0 : (int)possibleSolutions;
    }
}
