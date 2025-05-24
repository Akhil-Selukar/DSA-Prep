### 42 - Trapping Rain Water

**Question link** - [Link](https://leetcode.com/problems/reverse-prefix-of-word/)

**Topics** - Arrays, Two pointers

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** - <br>
maximum water that we can trap will depend on the min(maxHeightLeft, maxHeightRight). 
Hence we first need to calculate these values and then we can further calculate the blocks of water.
