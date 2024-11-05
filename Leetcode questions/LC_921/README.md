### 921 - Minimum add to make parenthesis valid

**Question link** - [Link](https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/)

**Topics** - Stack

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
This problem is very similar to that of [20 - Valid parenthesis](https://github.com/Akhil-Selukar/DSA-Prep/tree/master/Leetcode%20questions/LC_20).
Same approach we can use here and add for each parenthesis we can check is the topmost element in stack is nullifying parenthesis 
or not. If yes then we will pop out the parenthesis from stack and if not then we will add the current parenthesis to stack.
At the end remaining elements in the stack will be those who need closing parenthesis. Hence we can simply return the count of
those elements.
