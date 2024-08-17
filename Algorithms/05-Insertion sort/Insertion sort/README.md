### Insertion sort

Note: If array has length less than 2 that means we have either empty array or array with 1 element, which is always sorted.

The basic idea behind insertion sort is, we will start from index number 1. Then we insert that element to it's correct place in 
left hand side array. So after every iteration the left hand side array to the current array will be sorted. (i.e. partial sorting)

For example:
consider given array is `[3,2,4,1]`.

Iteration 1:<br>
We will start from index 1 and compare the element at index 1 with it's left hand side element(i.e. compare 2 with 3).
If element at index is less that the LHS element then swap it. So after this our array will become. `[2,3,4,1]`

Iteration 2:<br>
Now in second iteration we will compare element at index 2 with it's LHS element. So is 4 less than 3? No this is false 
hence we will break the loop (as there is no point in checking further as we know LHS side of current index will be sorted in previous iteration). 
So the resultant array after this iteration will be `[2,3,4,1]`.

Iteration 3:<br>
In this iteration we will check element at index 3 to its LHS elements. i.e. we will check 1 with 4. Now 1 is less than 4 
hence we will swap the elements and the array will become `[2,3,1,4]`. Now we will check 1 again with it's LHS element here as 
well 1 is smaller than 3 so again swap the elements and the array will be like `[2,1,3,4]`. Again 1 will be checked with LHS element
and will be swapped, and finally we will get `[1,2,3,4]` as final sorted array.


Complexity for this algorithm will be as in worst case (i.e. array is sorted in descending order).
In first iteration we will do 1 comparison, in second iteration we will do 2 comparisons, in 3rd iteration we will do 3 comparisons and 
so on till last iteration we will do N-1 comparisons. 

So total comparisons will be 1+2+3+.....+(n-1)

That means (N-1)*(N-1+1)/2

which is (N<sup>2</sup>-1)/2

Means O(N<sup>2</sup>)

While in best case scenario when given array is already sorted for each iteration it will only check with it's previous element
So total comparisons will be (N-1) only. Which means linear complexity i.e. O(N).


**When to use insertion sort.**<br>
Insertion sort works good with partially sorted array.<br>
It is mostly used with hybrid algorithms.<br>
Insertion sort is a stable algorithm.
