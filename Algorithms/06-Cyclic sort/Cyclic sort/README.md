### Cyclic sort

When and why to use cyclic sort:<br>
- Cyclic sort takes O(N) time complexity. i.e. it sorts the array in one single iteration.
- When given numbers are in the range of 1 to N, use cyclic sort.


As here the numbers are in the range 1 to N, so after the sorting the numbers at i<sup>th</sup> index must be (i+1). 
Hence in this algorithm we will loop over the array and for each index we will check if the element at that index is equal to (i+1)
or not. If not the swap that element to its correct index i.e. (arr[i]-1)<sup>th</sup> index and repeat the step.

Have a look at below example.

Given array is `[3,5,2,1,4]` now the first iteration will start with i=0;

**Iteration 1:**</br>
Here we will check ideally the value should be i+1 i.e. 1 but the actual value at this index is 3. So we will swap 3 to its 
correct index which is (arr[i]-1) i.e. (3-1) i.e. 2.<br>
So after swapping the values our array will become `[2,5,3,1,4]` (we have swapped 3 with 2, and now 3 is at its correct place)

Now we will again check element at i<sup>th</sup> index which is 2 is equal to (i+1) i.e. 1. No, its not so again swap 2 to its
correct place. Which is (arr[i]-1)<sup>th</sup> index. (i.e. 1).<br>
After this swapping the array will be `[5,2,3,1,4]`

Again we will check value at i<sup>th</sup> index is (i+1) or not, here we have 5 at 0th index which is not equal to 1 so we will
swap 5 to its correct place i.e. (arr[i]-1)<sup>th</sup> index. (i.e. 4<sup>th</sup> index).<br>
After this swapping the array will be like `[4,2,3,1,5]`.

Again repeat the same step now at this time we will swap 4 to its correct index which is 3rd index and after this swapping
the array will look like `[1,2,3,4,5]`.

Now same thing we will check value at i<sup>th</sup> index is correct or not. Now this time it is correct so our 1st iteration is 
complete. So we will increment the i value and start second iteration.

**Iteration 2:**<br>
Here now we will check if the value at i<sup>th</sup> index is correct or not. So ideally the value should be i+1 i.e. 2 so 
2 is equal to 2, so we are good here and this iteration will be complete, and we will increment i by 1.

**Iteration 3:**<br>
Here now we will check if the value at i<sup>th</sup> index is correct or not. So ideally the value should be i+1 i.e. 3 so
3 is equal to 3, so we are good here and this iteration will be complete, and we will increment i by 1.

**Iteration 4:**<br>
Here now we will check if the value at i<sup>th</sup> index is correct or not. So ideally the value should be i+1 i.e. 4 so
4 is equal to 4, so we are good here and this iteration will be complete, and we will increment i by 1.

**Iteration 5:**<br>
Here now we will check if the value at i<sup>th</sup> index is correct or not. So ideally the value should be i+1 i.e. 5 so
5 is equal to 5, so we are good here and this iteration will be complete, and we will increment i by 1.<br>
Now after this increment the value of i will become greater than length of array. So loop will be over and array will be sorted.


To calculate the time complexity, if we check the number of iterations and comparisons we have to make in order to sort above 
array of 5 elements are. In first iteration we did 4 comparisons. i.e. (N-1) and total number of iterations are N. After 
first iteration all subsequent iterations has only 1 comparison. So overall the total number of operations will be<br>

= (N-1) + N<br>
= 2N - 1<br>
In complexity analysis we can ignore constants so the overall time complexity will be O(N)

