### Stable count sort

Stable algorithm means the algorithms in which original order is preserved. In the count sort algorithm we are directly 
adding the numbers in sorted array based on the frequency, but we are not making sure that the numbers are preserving the 
original order. (Note that in case of numbers this will not make any difference).

To make this stable or to ensure that the order is maintained we can do small changes in the algorithm. We can convert the 
frequency array to prefix sum array. This array will give us the last position of the index value instead of frequency. 
So now we can start traversing from last element in original array and put it in the position obtained from prefix sum array.

Have a look at below example for better understanding.

Consider the given array is `nums=[4,3,1,5,3,1,3,5]`. Here the normal frequency array will be `frequency = [0,2,0,3,1,2,]`
Till now it is simple. Here each value in frequency array represents the number of occurrences of that index in actual array.
(value at index 0 is 0 means 0 is present 0 times in nums array. Value of index 1 is 2 which means 1 is present 2 times in 
nums array, and so on).

![Stable count sort image-1](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Algorithms/12-Count%20sort/Stable%20count%20sort/src/main/resources/images/Stable%20count%20sort%20image-1.jpg)

Now to create prefix sum array we have to start from index 1 of frequency array and add previous index value in it. By this 
way we will get the prefix sum array.

![Stable count sort image-2](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Algorithms/12-Count%20sort/Stable%20count%20sort/src/main/resources/images/Stable%20count%20sort%20image-2.jpg)

What exactly elements in prefix sum indicates are, if we start from last element of nums array (i.e. 5), then the value in
prefix sum array at index 5 (i.e. 8) represents the last position in final sorted array where 5 will be present. (As we 
are traversing nums array from end so we know that this 5 is the last 5 occurring in nums, also as 8 in prefix sum array 
represent the last position in sorted array where 5 will be present, so both are the last places and hence we are ensuring
the order to make algorithm stable.)

So at while traversing nums in reverse order `i=nums.length-1` (i.e. element 5) we can check the value at 5th index in 
prefix sum array which is 8. So put the 5 at 8th place (i.e. 7th index). Now as 7th index or 8th position is filled so if 
there is any other occurrence of 5 then that must go at 6th index i.e. 7th place. Hence, we decrement the value in prefix 
sum array for 5 and new value will be 7 (i.e. if any other 5 is present in nums place it at 7th position or 6th index ).
Next for `i=nums.length-2` (i.e. element 3), the value in prefix sum array is 5 so 3 will go to the 5th place or 4th index
and prefix sum will be updated by decrementing the value at index 3 by 1, and so on...

![Stable count sort image-3](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Algorithms/12-Count%20sort/Stable%20count%20sort/src/main/resources/images/Stable%20count%20sort%20image-3.jpg)

At the end of above iterations the entire array will be sorted.

> Here the important thing to note is prefix sum array does not represent the frequency, it represents the last position 
> in answer array where that element will be present. 