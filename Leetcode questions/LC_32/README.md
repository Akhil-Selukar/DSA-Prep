### 32 - Longest Valid Parentheses

**Question link** - [Link](https://leetcode.com/problems/longest-valid-parentheses/description/)

**Topics** - String, Stack

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
As question is about checking valid parenthesis, we will have to keep track of all opening parenthesis so that when we encounter
a closing one we can check of validity hence always give a thought to stack in such questions.

Now the index at which we found '(', if we add that index to stack and for each ')' if we pop the index at the end we will 
remain with all the index which are breaking the validity of string. Hence entire string between these indices will be valid.
So we can check the length of such strings and find max out of it.

**IMPORTANT** - In this approach we need to handle two edge cases those are, longest valid string at the end of given string 
and longest valid string at the start of given string.
