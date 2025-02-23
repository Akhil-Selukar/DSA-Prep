### 556 - Next Greater Element III

**Question link** - [Link](https://leetcode.com/problems/next-greater-element-iii/description/)

**Topics** - String

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
case 1 - if digits in number are in descending order - No solution possible
<br>case 2 - if digits are in ascending order the swap last 2 digit to get the answer.
<br>case 3 - in case of no sorting
<br>3.1 - find digit 'd' from right which is less than previous digit.
<br>3.2 - to the right of digit found in 3.1 find smallest digit greater than 'd' (smallest)
<br>3.3 - swap d and smallest.
<br>3.4 - sort right hand side of index of d
