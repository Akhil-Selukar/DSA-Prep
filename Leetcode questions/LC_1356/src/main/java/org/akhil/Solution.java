package org.akhil;

import java.util.PriorityQueue;
import java.util.Arrays;

public class Solution {
    // // Solution 1 - Bruteforce
    // // O(NlogN)+O(N)+O(N) ~ O(NlogN)/O(N)
    // public int[] sortByBits(int[] arr) {
    //     Arrays.sort(arr);
    //     Map<Integer, List<Integer>> map = new HashMap<>();

    //     for(int num:arr){
    //         int bitCount = Integer.bitCount(num);

    //         if(!map.containsKey(bitCount)){
    //             map.put(bitCount, new ArrayList<>());
    //         }

    //         map.get(bitCount).add(num);
    //     }

    //     int index = 0;
    //     for(List<Integer> list:map.values()){
    //         for(int val:list){
    //             arr[index++] = val;
    //         }
    //     }

    //     return arr;
    // }

    // -------------------------
    // // Solution 2 - using comparator
    // // O(NlogN)/O(N)
    // public int[] sortByBits(int[] arr) {
    //     Integer[] temp = new Integer[arr.length];

    //     for(int i=0; i<arr.length; i++){
    //         temp[i] = arr[i];
    //     }

    //     // Arrays.sort with comparator need Integer and not int hence we need temp array because
    //     // Java generics + Comparator work only with objects, not primitives.
    //     Arrays.sort(temp, (a,b) -> {
    //         int bitCountA = Integer.bitCount(a);
    //         int bitCountB = Integer.bitCount(b);

    //         if(bitCountA == bitCountB){
    //             return a-b;
    //         }
    //         return bitCountA-bitCountB;
    //     });

    //     // as we are returning int[] and not Integer[] hence need to convert temp to arr again
    //     for(int i=0; i<arr.length; i++){
    //         arr[i] = temp[i];
    //     }

    //     return arr;
    // }

    // -------------------------
    // Solution 3 - Using priority queue
    // O(NlogN)/O(N)
    public int[] sortByBits(int[] arr) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            if(a[0] == b[0]){
                return a[1]-b[1];
            }
            return a[0]-b[0];
        });

        for(int num:arr){
            int bitCount = Integer.bitCount(num);
            queue.offer(new int[]{bitCount, num});
        }

        for(int i=0; i<arr.length; i++){
            arr[i] = queue.poll()[1];
        }

        return arr;
    }
}
