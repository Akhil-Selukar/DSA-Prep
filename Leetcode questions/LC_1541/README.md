### 1541 - Minimum insertions to balance a parenthesis string

**Question link** - [Link](https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/)

**Topics** - String, Stack

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
Here the intuition is simple just like [921 - Minimum add to make parenthesis valid](https://github.com/Akhil-Selukar/DSA-Prep/tree/master/Leetcode%20questions/LC_921) 
with small update in logic.
1. We will initialize a stack to store '('.
2. If and ')' is encounter then we will check below conditions.
   1. If this is end of string?
   2. If the next element is also ')' or not (as we need pair of '))').
   3. If there is any '(' available in stack or not?
3. Based on above conditions we will either pop the element from stack or increment the counter by 1.
4. At the end of string we will check if there are any element left in stack?
5. If yes then add 2 in counter for each remaining element in stack (as in stack we have '(' and to compensate this we need 
two '))')
