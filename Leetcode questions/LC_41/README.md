### 41 - First Missing Positive

**Question link** - [Link](https://leetcode.com/problems/first-missing-positive/description/)

**Topics** - Array, Sorting, Cyclic sort

**Note** - The smallest positive integer that can be present in any array is 1. So first we will check if 1 is present in 
given array or not. If it is present then we will check for next smallest which is 2, then 3 then 4 and so on. So this is
nothing, but we are expecting that the array should have all elements from 1 to N (There can be some negative numbers as per
questions, so we will neglect those numbers as we want first positive.) From this explanation we can conclude that we can 
use cyclic sort here.


**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1. 
