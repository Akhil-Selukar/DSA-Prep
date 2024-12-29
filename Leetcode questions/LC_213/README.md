### 213 - House robber II

**Question link** - [Link](https://leetcode.com/problems/house-robber-ii/description/)

**Topics** - Logic, Recursion

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
This problem is just an extension of [LC-198](https://github.com/Akhil-Selukar/DSA-Prep/tree/ef4813abaef98c52679bfe68983dee7c061f0c3a/Leetcode%20questions/LC_198)
only additional condition given here is the houses are arranged in circular manner so last house is adjacent to the first 
one hence if we are starting from index zero then we can only go till index N-1 because Nth index is directly adjacent to 
0th one and similarly if we are starting from house at index 1 then we can go till index N, because even if we rob house 
at index N still its adjacent index 0 will not be robbed.
