### Sum triangle from array

**Question link** - [Link](https://www.geeksforgeeks.org/sum-triangle-from-array/)

**Topics** - Recursion, Arrays

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1. 

**Intuition** -
Here we can clearly see that the final sum of all adjacent elements is printed first and then sum just before the final sum and so on.
So we can figure out that the output is printed while returning the recursive calls. So we can conclude that we have to use recursion here.