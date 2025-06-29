### 1498 - Number of Subsequences That Satisfy the Given Sum Condition

**Question link** - [Link](https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/description/)

**Topics** - 2 pointer and sorting

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
Even though here it is mention that we have to find subsequences which preserve the order but as we are only concern with min
and max value from the subsequence, we can sort the array and it will be okay if order is nor proper.<br>
For example in array [1,3,5] if we write it as [1,5,3] or [3,5,1] or [5,1,3] the min and max values are not going to change and
it will always remain 1 and 5 respectively.


