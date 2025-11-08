package org.akhil;

import java.util.Arrays;

public class Solution {

    // TC -> O(n * log(sum+k)) where sum = sum of station values
    // SC -> O(n)
    public long maxPower(int[] stations, int r, int k) {
        int n = stations.length;
        long[] diff = new long[n];      // difference array

        // construct diff array
        for(int i=0; i<n; i++){
            int leftBoundary = Math.max(0, i - r);
            int rightBoundary = i + r + 1;

            diff[leftBoundary] = diff[leftBoundary] + stations[i];
            if(rightBoundary < n){
                diff[rightBoundary] = diff[rightBoundary] - stations[i];
            }
        }

        // apply binary search on lowest possible result and highest possible result
        long start = Long.MAX_VALUE;
        long end = 0;

        for(int val:stations){
            start = Math.min(start, val);
            end = end + val;
        }
        end = end + k;      // max possible answer will also include K

        long result = 0;
        while(start <= end){
            long mid = start + (end - start)/2;

            if(isPossible(mid, diff, r, k, n)){
                result = mid;
                start = mid+1;
            } else {
                end = mid - 1;
            }
        }

        return result;
    }

    private boolean isPossible(long powerToCheck, long[] diff, int r, long k, int n){
        long[] temp = Arrays.copyOf(diff, n);
        long currCityPower = 0;

        for(int i=0; i<n; i++){
            currCityPower = currCityPower + temp[i];    // cumulative sum of diff array gives the actual power at that index

            // if current power at the city is less than the power we are looking for then we can use additional power stations from k
            if(currCityPower < powerToCheck){
                long requiredStations = powerToCheck - currCityPower;

                if(requiredStations > k){
                    return false;
                }

                // consume the required stations from k
                k = k - requiredStations;
                currCityPower = currCityPower + requiredStations;

                // because of additional stations at ith city update the range using diff array (i.e. temp or copied diff array)
                if((i + 2 * r + 1) < n){
                    temp[(int)(i+2*r+1)] = temp[(int)(i+2*r+1)] - requiredStations;
                }
            }
        }

        return true;
    }
}
