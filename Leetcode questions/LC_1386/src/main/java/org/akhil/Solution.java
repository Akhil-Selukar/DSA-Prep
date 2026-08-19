package org.akhil;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    // here important thing is if no seat is reserved in a row then max we can book both sets of seats i.e. [2,3,4,5] and [6,7,8,9]
    // but if any of the seat is reserved then we can either book only 1 set or no set of seats.
    // O(N)/O(N)
//    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
//        Map<Integer, Set<Integer>> map = new HashMap<>();
//
//        for(int[] reservedSeat : reservedSeats) {
//            int row  = reservedSeat[0];
//            int seat = reservedSeat[1];
//            if(!map.containsKey(row)){
//                map.put(row, new HashSet<>());
//            }
//            map.get(row).add(seat);
//        }
//
//        int result = (n - map.size()) * 2;  // these will be the rows where we can book both set of seats
//
//        for(Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
//            Set<Integer> bookedSeats = entry.getValue();
//
//            boolean canBeekSetOne = !bookedSeats.contains(2) && !bookedSeats.contains(3) && !bookedSeats.contains(4) && !bookedSeats.contains(5);
//            boolean canBookSetTwo = !bookedSeats.contains(4) && !bookedSeats.contains(5) && !bookedSeats.contains(6) && !bookedSeats.contains(7);
//            boolean canBookSetThree = !bookedSeats.contains(6) && !bookedSeats.contains(7) && !bookedSeats.contains(8) && !bookedSeats.contains(9);
//
//            if(canBeekSetOne && canBookSetThree)
//                result = result + 2;
//            else if(canBeekSetOne || canBookSetTwo || canBookSetThree)
//                result = result + 1;
//        }
//
//        return result;
//    }


    // ----------------------
    // Solution 2 - Instead of map we can use bit masking to save some time
    // we know that there can not be more than 10 seats per row. So we can consider each seat as a bit
    // Now if a seat is reserved then we can set that bit and mark it as reserved.
    // Further to check if the three sets can be booked or not we can take another bit mark for each set
    // for set 1 (i.e. [2,3,4,5]) -> 0 1 1 1 1 0 0 0 0 0
    // for set 2 (i.e. [4,5,6,7]) -> 0 0 0 1 1 1 1 0 0 0
    // for set 1 (i.e. [6,7,8,9]) -> 0 0 0 0 0 1 1 1 1 0
    // now if we take & operation of these bit marks with row's bit mark if we are able to book the set then we will get 0 as
    // the result of AND because as the sears are not reserved we will have 0 bit in row bit mask and AND with 0 gives 0.
    // but if any of the seat is reserved then we will have 1 at that bit so AND operation will give 1 bit resulting in > 0 result
    // for AND operation

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int[] reservedSeat : reservedSeats) {
            int row  = reservedSeat[0];
            int seat = reservedSeat[1];
            map.merge(row, (1 << seat), (a, b) -> a | b);
        }

        int result = (n - map.size()) * 2;

        int markOfSetOne = (1 << 9) | (1 << 8) | (1 << 7) | (1 << 6);
        int maskOfSetTwo = (1 << 7) | (1 << 6) | (1 << 5) | (1 << 4);
        int maskOfSetThree = (1 << 5) | (1 << 4) | (1 << 3) | (1 << 2);


        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int bookedSeatsMask = entry.getValue();

            boolean groupOne = (bookedSeatsMask & markOfSetOne) == 0;
            boolean groupTwo = (bookedSeatsMask & maskOfSetTwo) == 0;
            boolean groupThree = (bookedSeatsMask & maskOfSetThree) == 0;

            if(groupOne && groupThree)
                result = result + 2;
            else if(groupOne || groupTwo || groupThree)
                result = result + 1;
        }

        return result;
    }
}
