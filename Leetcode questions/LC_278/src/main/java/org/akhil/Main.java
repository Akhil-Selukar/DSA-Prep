package org.akhil;

public class Main {

    static int badVersion = 4;
    public static void main(String[] args) {
        int n = 5;
        System.out.println(firstBadVersion(n));
    }

    public static int firstBadVersion(int n) {
        int start = 0;
        int end = n;

        while(start<=end){
            int mid = start + (end-start)/2;

            if(!isBadVersion(mid-1) && isBadVersion(mid)){
                return mid;
            } else if(isBadVersion(mid)){
                end = mid;
            } else if(!isBadVersion(mid)){
                start = mid+1;
            }
        }
        return -1;
    }

    public static boolean isBadVersion(int version){
        return version >= badVersion;
    }
}