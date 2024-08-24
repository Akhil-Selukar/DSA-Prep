### 922 - Sort array by parity 2

**Question link** - [Link](https://leetcode.com/problems/sort-array-by-parity-ii/description/)

**Topics** - Array, Sorting,

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -
Here we can start from index 0 or index 1 and check if for any odd index do we have even value. If yes then we will find any
even index for which we have odd value. And once that index is found we can simply swap the values for those index.