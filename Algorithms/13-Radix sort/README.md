### Radix sort

In case of count sort we create frequency/prefix sum array of size 'max+1' where max is the maximum value in nums array.
But consider the array is something like `nums = [1,5,8,3,1,9999999]`. In this case max value is 9999999 so we will have to 
create frequency array of length 10000000, out of which almost all the space will be unused except index 1,5,8,3 and 9999999.
This is not good. This will consume unnecessary space and make the program slow as we will have to traverse through 10000000
places in array. This is the reason why count sort does not work well if the range or number is large. The solution to this 
problem is radix sort.

In Radix sort we sort the numbers iteratively based on their units, tens, hundreds, etc place. We use count sort to do the 
sorting but instead of creating a frequency array of size 'max+1' we create it of size 10 (because at any place in a number
only values possible are 0 to 9)

Consider given array `nums = [26, 458, 103, 73, 846, 5]`.
Here the largest number is 846 which is 3-digit number hence we will do count sort 3 times.<br>
During first iteration we will sort the array based on units place numbers so resultant array will be `nums = [103, 73, 5, 26, 846, 458]`<br>
In second iteration we will sort the array from first iteration based on tens place digit hence the array will become
`nums = [103, 5, 26, 846, 458, 73]`<br>
At final iteration we will sort the array based on hundreds place so the array become `nums = [5, 26, 73, 103, 458, 846]`.
This is the required answer

![Radix sort image-1](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Algorithms/12-Count%20sort/Radix%20sort/src/main/resources/images/Radix%20sort%20image-1.jpg)

> Here if we check the time complexity we are performing count sort k times (where k is the number of digits in the largest element)
> and time complexity of count sort is O(N+M) where M is the size of frequency array. So overall time complexity for radix 
> sort will be O(k(n+m)), but we know that in radix sort every time m will be 10 so constant. Hence we can eliminate the 
> constant and overall time complexity will be O(kn).
> And space complexity will be O(n) as we are creating new output array of size n. Frequency array will always be of size 10 
> so we can consider it as constant.