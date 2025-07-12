package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // O(N)/O(P) where P is size of peaks list
    public List<Integer> findPeaks(int[] mountain) {
        List<Integer> peaks = new ArrayList();

        for(int i=1; i<mountain.length-1; i++){
            if((mountain[i-1]<mountain[i]) && (mountain[i] > mountain[i+1])){
                peaks.add(i);
            }
        }

        return peaks;
    }
}
