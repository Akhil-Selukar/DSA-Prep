### 494 - Target sum

**Question link** - [Link](https://leetcode.com/problems/target-sum/description/)

**Topics** - Recursion, DP

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
Here we are given an array and a target sum which we have to achieve by adding either + or - sign to the array element.
Here first thought is to find total number of ways we need to explore all possible ways. That means we need recursion. The
two choices we can have are either the current number can be +vr or -ve. And we can go on doing recursion calls.