package org.akhil;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        /*
         * Use - To search element in given array.
         *
         * Prerequisites - Array must be sorted and if sorting order is not known.
         *
         * Algorithm -
         *      a. set start index to 0 and end index to arr.length-1.
         *      b. find middle index
         *          mid = start + (end - start)/2
         *      c. check if target is equal to arr[mid], if not then check if target lies on LHS of mid or RHS of mid.
         *      d. based on which side target lies shift start to mid+1 or end to mid-1;
         *
         * Time complexity - O(log N)
         *
         * Space complexity - O(1)
         * */
    }
}