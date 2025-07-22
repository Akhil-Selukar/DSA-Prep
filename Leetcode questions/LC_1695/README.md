### 1695 - Maximum Erasure Value

**Question link** - [Link](https://leetcode.com/problems/maximum-erasure-value/description/)

**Topics** - Set/HashMap and prefixSum, arrays

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** - <br>
Here examples in question are not that clear. Consider below example.<br>

nums = [4, 2, 4, 5, 6, 2];<br>
answer = 17<br>
[2, 4, 5, 6] because if we again include last 2, it will cause duplicate in the array. So the subarray we are taking sum of, must not have duplicates.

