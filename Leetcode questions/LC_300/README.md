### 300 - Longest increasing subsequence

**Question link** - [Link](https://leetcode.com/problems/longest-increasing-subsequence/description/)

**Topics** - Recursion, DP

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
Here we need to find the longest subsequence but the condition is in subsequence all elements need to be in increasing order.
Hence, apart from just checking take and not take conditions we will also need to check if the current element is greater
than the previous one or not. To do this check we must have to know what was the element which we considered in the subsequence
just before this current iteration. Hence we need to carry the previous elements index/previous element as well.
