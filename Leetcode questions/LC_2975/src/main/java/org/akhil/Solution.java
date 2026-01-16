package org.akhil;

import java.util.*;

public class Solution {

    // TC -> we used sorting on both the fences so it will contribute to O(Max(m,n)log(max(m,n))), Also we iterated over the
    // sorted lists to find all combinations which is O(max(m,n)^2). If we consider max(m,n) = K then TC can be O(K^2)
    // SC -> we used list and set for horizontal and vertical fences hence it will be O(K)
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        final int MOD = (int)(1e9+7);

        // in case of the grid is already square then we can remove all given fences and max square will be entire grid
        if( m == n){
            long side = m-1;
            return (int)((side*side) % MOD);
        }

        // each fence in hFences can create a vertical border with top and bottom boundary of the grid so we need to take into consideration
        // top and bottom boundaries as well while calculating the sides
        List<Integer> hFencesList = new ArrayList<>();
        List<Integer> vFencesList = new ArrayList<>();

        // adding start boundary into consideration
        hFencesList.add(1);
        vFencesList.add(1);

        // add all other fences
        for(int fence:hFences){
            hFencesList.add(fence);
        }

        for(int fence:vFences){
            vFencesList.add(fence);
        }

        // add end boundary into consideration
        hFencesList.add(m);
        vFencesList.add(n);

        // sort the fences to get correct side length
        Collections.sort(hFencesList);
        Collections.sort(vFencesList);

        // now calculate side length we can get by removing all possible combinations of horizontal fences
        Set<Integer> hSides = new HashSet<>();

        for(int i=0; i<hFencesList.size(); i++){
            for(int j=i+1; j<hFencesList.size(); j++){
                hSides.add(hFencesList.get(j) - hFencesList.get(i));
            }
        }

        // Similarly check all sides we can create by removing vertical fences and if any of the side matches with side
        // created by removing horizontal fences then we can create a square shape. (We just need to maximize the area which means
        // indirectly maximize this matching side)

        int maxSide = -1;
        for(int i=0; i<vFencesList.size(); i++){
            for(int j=i+1; j<vFencesList.size(); j++){
                int sideLength = vFencesList.get(j) - vFencesList.get(i);

                if(hSides.contains(sideLength)){
                    maxSide = Math.max(maxSide, sideLength);
                }
            }
        }

        if(maxSide == -1){
            return -1;
        }
        long area = (long)maxSide * maxSide;
        return (int) (area % MOD);
    }
}
