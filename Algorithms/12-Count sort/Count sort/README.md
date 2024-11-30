### Count sort

Count sort is a non comparison based sorting algorithm. That means for sorting an array we don't compare elements in the array
with each other. If we are not comparing the elements then how does sorting happen?, well we use frequency of elements and 
then modify the original array (or create a new array) based on the frequency of each element. Consider below example to 
understand the count sort algorithm.

Given array `nums = [2, 6, 4, 1, 8, 3, 1, 2, 4]`<br>
To sort this array using count sort we execute below steps.<br>
**Step 1** - Find the highest element in given array. (let's say 'n')<br>
**Step 2** - Create another array of size 'n+1'. (frequency array)<br>
**Step 3** - (As we have created array of size 'n+1' i.e. index 0 to 'n', and 'n' is the largest number in 'nums' array. 
So for all elements in nums array there will be an index in frequency array.) So traverse through nums array and add 
increment the value in frequency array for index which is present in nums array.
**Step 4** - Now traverse the frequency array and based on frequency modify the nums array or create a new sorted array.

Dry run on above example :<br> 

Given array is `nums = [2, 6, 4, 1, 8, 3, 1, 2, 4]`<br>
Step 1 - The largest number in nums array is 8.<br>
Step 2 - Create new frequency array of size '8+1' i.e. 9.

![Count sort image-1](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Algorithms/12-Count%20sort/Count%20sort/src/main/resources/images/Count%20sort%20image-1.jpg)

Step 3 - Iterate over elements in nums array and increment the respective index value in frequency array. (Have a look at 
below image to understand this better.)

![Count sort image-2](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Algorithms/12-Count%20sort/Count%20sort/src/main/resources/images/Count%20sort%20image-2.jpg)

Step 4 - Now iterate over frequency array and add the 'i' index of frequency array frequency[i] times in nums array.

![Count sort image-3](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Algorithms/12-Count%20sort/Count%20sort/src/main/resources/images/Count%20sort%20image-3.jpg)

At the end of above step the nums array will be completely sorted.

>Here as we are using frequency array of size 'm' (where m = max number in array + 1), so we space complexity will be O(M).
> Note that here we are modifying original nums array. If we create another sorted array then space complexity will be O(M+N).
> 
> For time complexity, as we are iterating over two arrays of size N and M. Hence, time complexity will be O(N+M).


> Here points to remember are this algorithm works well in case of small numbers.
> Disadvantages are it does not work well for decimal values and does not work well with large numbers.