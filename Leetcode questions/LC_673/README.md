### 673 - Number of longest increasing subsequence

**Question link** - [Link](https://leetcode.com/problems/number-of-longest-increasing-subsequence/)

**Topics** - Arrays, DP

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
This problem is an extension of [LC-300 Longest increasing subsequence](https://github.com/Akhil-Selukar/DSA-Prep/tree/master/Leetcode%20questions/LC_300).
In LC-300 we just calculated the length of longest increasing subsequence, here we have to find the count as. Hence we can 
use another array to hold the count of LIS till that index.