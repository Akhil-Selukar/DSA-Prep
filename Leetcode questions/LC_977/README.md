### 977 - Square of a sorted array

**Question link** - [Link](https://leetcode.com/problems/squares-of-a-sorted-array/description/)

**Topics** - Array, Sorting,

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1. 

**Intuition** -
Here as it is given that we can't use trivial solution i.e. squaring the array first and then sorting it. And we have to 
solve it in O(N) complexity. So we can create a new answer array with length N. Then we can use two pointer method and 
start one pointer from start of given array and another pointer from end of given array. Now absolute value at whichever pointer
is greater that we can add in the result array at the end and shift that pointer by 1.

This approach will work because given array is also a sorted array in ascending order.