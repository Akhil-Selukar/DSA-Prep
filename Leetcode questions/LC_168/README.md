### 168 - Excel sheet column title

**Question link** - [Link](https://leetcode.com/problems/excel-sheet-column-title/description/)

**Topics** - String

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1. 

**Intuition** -
Convert given number to base 26. We are starting from A i.e. in case of 0 remainder we are adding 'A' to the string hence
we have to subtract 1 every time before converting the remaining number to base 26.