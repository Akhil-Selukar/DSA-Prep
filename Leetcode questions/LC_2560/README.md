### 2560 - House Robber IV

**Question link** - [Link](https://leetcode.com/problems/house-robber-iv/description/)

**Topics** - Arrays, Binary search

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
Here the important point to note is that our answer will lie in the range of minimum value in nums and maximum value in nums.
And out of all those possible answers we need to find the minimum possible answer where the condition of alternate house robbery 
is satisfied. Hence finding a particular value in a sorted range is nothing but the Binary search problem.