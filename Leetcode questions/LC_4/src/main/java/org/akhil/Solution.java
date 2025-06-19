package org.akhil;

public class Solution {
    /**
    * Definition of the Median -
    * The median is "the middle value when a sorted array is split exactly in half."
    * If the number of elements is odd, the median is the middle element.
    * If it's even, the median is the average of the two middle elements.
     */

    // Solution 1 - bruteforce (merge two arrays and find the median)
    // O(M+N)/O(M+N)
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int n = nums1.length;
//        int m = nums2.length;
//
//        int[] arr = new int[n+m];
//        int p1 = 0;
//        int p2 = 0;
//        int index = 0;
//
//        while(p1 < n && p2 < m){
//            if(nums1[p1] < nums2[p2]){
//                arr[index++] = nums1[p1++];
//            } else if(nums1[p1] >= nums2[p2]){
//                arr[index++] = nums2[p2++];
//            }
//        }
//
//        if(p1==n){
//            while(p2 != m){
//                arr[index++] = nums2[p2++];
//            }
//        }
//
//        if(p2==m){
//            while(p1 != n){
//                arr[index++] = nums1[p1++];
//            }
//        }
//
//        if(arr.length % 2 == 0){
//            p1 = ((n+m)/2)-1;   // -1 because index start from 0
//            return (double)(arr[p1] + arr[p1+1])/2.0;
//        }
//
//        return arr[(n+m)/2];
//    }


    // Solution 2 - two pointers method (As we know median will be the exact middle element hence we can skip total/2 elements from combined array)
    // we don't have to actually combine them we can just maintain pointers.
    // O(M+N)/O(1)
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int n = nums1.length;
//        int m = nums2.length;
//
//        int p1 = 0;
//        int p2 = 0;
//        int num1 = 0;
//        int num2 = 0;
//        int counter = 0;
//
//        while(counter <= (n+m)/2){
//            num2 = num1;            // hold previous element as in case of M+N is even we need previous and current both elements.
//            if(p1 != n && p2 != m){
//                if(nums1[p1] < nums2[p2]){
//                    num1 = nums1[p1];
//                    p1++;
//                } else {
//                    num1 = nums2[p2];
//                    p2++;
//                }
//            } else if(p1 == n){
//                num1 = nums2[p2];
//                p2++;
//            } else {
//                num1 = nums1[p1];
//                p1++;
//            }
//            counter++;
//        }
//
//        if((n+m)%2 == 1){
//            return (double) num1;
//        } else {
//            return (num1 + num2)/2.0;
//        }
//    }


    // Solution 3 - Followup question solution
    // TC - O(log(min(M+N)))/O(1)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        if(n > m){
           return findMedianSortedArrays(nums2, nums1);       // to make time complexity O(log(min(M,N)) (the min(M,N) part, log part is because of Binary Search)
        }

        // binary search
        int start = 0;
        int end = n;    // as N is min(M,N) now hence we are applying BS on smaller array.

        while(start <= end){
            int mid1 = start + (end-start)/2;        // partition index in nums1.
            int mid2 = (m+n+1)/2 - mid1;             // partition index in nums2.   (as total left partition size must be equal to (M+N)/2 (+1 is because array index starts from 0 and we want to include median in left partition)

            int maxInLeftPartition1 = mid1 == 0 ? Integer.MIN_VALUE : nums1[mid1-1];
            int maxInLeftPartition2 = mid2 == 0 ? Integer.MIN_VALUE : nums2[mid2-1];

            int minInRightPartition1 = mid1 == n ? Integer.MAX_VALUE : nums1[mid1];
            int minInRightPartition2 = mid2 == m ? Integer.MAX_VALUE : nums2[mid2];

            // if partition is valid then we found the median
            if((maxInLeftPartition1 <= minInRightPartition2) && (maxInLeftPartition2 <= minInRightPartition1)){
                if((m+n)%2 == 0){
                    int sum = Math.max(maxInLeftPartition1, maxInLeftPartition2) + Math.min(minInRightPartition1, minInRightPartition2);
                    return sum/2.0;
                } else {
                    return (double) Math.max(maxInLeftPartition1, maxInLeftPartition2);
                }
            } else {
                if(maxInLeftPartition1 > minInRightPartition2){
                    end = mid1-1;
                } else {
                    start = mid1 + 1;
                }
            }
        }
        return 0.0;
    }
}
