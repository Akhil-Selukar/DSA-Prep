package org.akhil;

class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int result = 1;
        for(int i=0; i<n; i++){
            int product = nums[i];
            int lcm = nums[i];
            int gcd = nums[i];
            for(int j=i+1; j<n; j++){
                product *= nums[j];
                lcm = (int)lcm(lcm, nums[j]);
                gcd = (int)gcd(gcd, nums[j]);

                if(product == lcm*gcd){
                    result = Math.max(result, j-i+1);
                }
            }
        }
        return result;
    }

    private long gcd(long a, long b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (a == 0) {
            return b;
        }

        return gcd(b%a, a);
    }

    private long lcm(long a, long b) {
        a = Math.abs(a);
        b = Math.abs(b);
        long gcd = gcd(a, b);
        if(gcd == 0){
            return 0;
        }
        return (a*b)/gcd;
    }
}
