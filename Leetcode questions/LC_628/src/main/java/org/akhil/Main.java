package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] arr = {0,2,3,4};

        System.out.println(maximumProduct(arr));
    }
    public static int maximumProduct(int[] nums) {
        int ans = 1;
        if(nums.length <=3){
            for(int num:nums){
                ans *=num;
            }
            return ans;
        }

        for (int i = 0; i <nums.length; i++) {
            boolean isSwapped = false;
            for(int j=1; j<nums.length-i; j++){
                if(nums[j-1]>nums[j]){
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                    isSwapped = true;
                }
            }
            if(!isSwapped){
                break;
            }
        }
        int product1 = nums[0]*nums[1]*nums[nums.length-1];
        int product2 = nums[nums.length-3]*nums[nums.length-2]*nums[nums.length-1];

        // As our array is sorted here so all negative numbers will be at the start of the array. To maximize the product
        // we will have to either multiple two negative numbers so that the product will be positive and third number should be
        // the largest number in the array which will multiply that product to get max product. Or we can simply multiply
        // 3 largest numbers in given array. Whichever is maximum from these 2 cases will be the max product.

        return Math.max(product1, product2);
    }

    // Time complexity of above method is  O(N^2) as we are using bubble sort here.
    // Same problem can be solved in O(N) complexity as well.
    // As we need two minimum values from the array and three maximum values. So we can simply loop over the array and
    // find the required values and then check the two products just like above.

    public static int maximumProduct_2(int[] nums) {
        int ans = 1;
        if(nums.length <=3){
            for(int num:nums){
                ans *=num;
            }
            return ans;
        }

        int max1= Integer.MIN_VALUE;
        int max2= Integer.MIN_VALUE;
        int max3= Integer.MIN_VALUE;
        int min1= Integer.MAX_VALUE;
        int min2= Integer.MAX_VALUE;

        for(int i=0; i<nums.length; i++){
            if(nums[i]>max1){
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            } else if (nums[i]>max2){
                max3 = max2;
                max2 = nums[i];
            } else if(nums[i]>max3){
                max3 = nums[i];
            }

            if(nums[i]<min1){
                min2 = min1;
                min1 = nums[i];
            } else if(nums[i]<min2){
                min2 = nums[i];
            }
        }

        int product1 = min1*min2*max1;
        int product2 = max1*max2*max3;
        return Math.max(product1, product2);
    }
}