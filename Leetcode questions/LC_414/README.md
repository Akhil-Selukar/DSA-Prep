### 414 - Third Maximum Number

**Question link** - [Link](https://leetcode.com/problems/third-maximum-number/description/)

**Topics** - Array, Sorting,

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1. 

**Intuition** -
Here we can use sorting and then search the third-highest number. In case of only two numbers are present multiple times or
size of array is less than 3 then we can return the maximum of the array. But till now what all algorithms we have discussed
all of them takes O(N<sup>2</sup>) time complexity so it is better if we loop over the array and find 3rd highest directly which
will take O(N) time complexity.
