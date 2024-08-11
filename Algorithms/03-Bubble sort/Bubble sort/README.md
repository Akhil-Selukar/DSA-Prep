### Bubble sort

Here in this sorting algorithm we compare two adjacent element and if the first element is greater than the second element,
then we swap them. We repeat this process and at the end we get sorted array.

For example consider the given array is `[1, 4, 3, 6, 2, 5]`.<br> 

Here, at first iteration we will first compare element at index 0 and index 1 (i.e. 1 and 4 respectively)<br>
As 1 is less than 4 so no need to swap.<br>
Next we compare element at index 1 and index 2 (i.e. 4 and 3 respectively) and as 4 is greater than 3, so we will swap the elements here.<br>
So after swapping the array will be `[1, 3, 4, 6, 2, 5]`.<br>
Now next we will compare element at index 2 and index 3 (i.e. 4 and 6), as 4 is less than 6 so no need to swap.<br>
Next compare element at index 3 and 4 (i.e. 6 and 2) Here as 6 is greater than 2, so we will swap the elements and the array after swapping will be
`[1, 3, 4, 2, 6, 5]`.<br>
Next we will compare elements at index 4 and 5 (i.e. 6 and 5 respectively) and here as well we will swap as 6 is greater than 5.
So the resultant array after the first complete iteration will be `[1, 3, 4, 2, 5, 6]`. <br>
Here we can see that 6 is at correct place now So in second iteration we will repeat the same set of steps from index 0 to 
arr.length-1 (as last element is already at correct place now).

So after second iteration the resultant array will be `[1, 3, 2, 4, 5, 6]`. Then after third iteration it will be `[1, 2, 3, 4, 5, 6]`
Now after third iteration the array is completely sorted so in next iteration there will not be any swapping and hence if no swapping is done 
then we can break out from the loop as the array will be sorted.

>NOTE: This algorithm is also called as 'Sinking sort' or 'Exchanging sort' Algorithm.

The time complexity in this case will be as below.

In best case i.e. the array is already sorted.
In this case as well to check that the array is already sorted we will have to loop over the array completely so it will take O(N) time complexity.

In worst case i.e. the given array is sorted in descending order (i.e. we will have to shift each and every element to the other side of the array).
Here in this case below will be the number of iterations during each iteration.

Iteration 1: We will have to check all elements, so iterations will be N, for array of length N.<br>
Iteration 2: At this time last element will be on its place so the number of iterations will be N-1.<br>
Iteration 3: Now last two elements will be at the correct place so the number of iterations will be N-2<br>
So till last element the number of iterations will be 'N - (N-1)', which is nothing but 1.

So the total iterations will be <br>
= N + (N-1) + (N-2) + ..... + 1<br>

= N(N+1)/2<br>
If we simplify this equation we will get<br>

= (N<sup>2</sup> +N)/2<br>

Now after removing constants and non-dominant terms we can conclude that the time complexity of bubble sort is O(N<sup>2</sup>)

Here we are not using any extra space so space complexity will be constant i.e. O(1).

> An important thing to note that bubble sort is a stable algorithm.  
> That means if we have duplicates in the given array then the duplicates will be sorted but keeping their order intact.
> To understand better consider an example of circular and square boxes with number on it, and you are using bubble sort algorithm
> to sort the boxes based on the number on each box.
> 
> Given array of boxes is ([] represent square box while () represent circular box and number written inside is the number on that box.)<br>
> [2], (1), [5], [3], (3), (5), [4]
> 
> After sorting the result will be <br>
> (1), [2], [3], (3), [4], [5], (5)<br>
> 
> Here the thing to note is that in original given array square box of 3 is before circular box of 3, hence in sorted result
> we can see square box of 3 before circular box of 3. Same is true for box with number 5 as well. That means in case of duplicate 
> elements the algorithm maintain the original order, such algorithms are called stable algorithms.