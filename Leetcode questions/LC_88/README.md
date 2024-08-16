### 88 - Merge sorted array

**Question link** - [Link](https://leetcode.com/problems/merge-sorted-array/description/)

**Topics** - Array, Sorting, 

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1. Can array be of size 0? (Shall we handle such edge case or not?)

**Intuition** -
Here we are given that we have to solve the problem in O(m+n) time complexity, where m and n are the number of elements in
two given arrays. So it means we will get to loop over both the arrays once, and we cant have nested loops.<br>
Also it is given that the size of first array is (m+n) and we have to add all the element in second array into the first array
and sort it.<br>Also both the given arrays are sorted.<br>
So what we can do here is we can start iterating both the arrays from their last elements. Check which element is greater
and add that element to the last (i.e. m+n<sup>th</sup>) index of first array. Element from whichever array is added we will
take second last element from that array now and repeat the same process.<br>
This we will repeat till we check and add all the elements from second array to the first array (because that is what is asked)<br>
If there are any elements left in first array we can leave them as it is as they are already sorted (both given arrays are sorted -given).