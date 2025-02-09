### 43 - Multiply strings

**Question link** - [Link](https://leetcode.com/problems/multiply-strings/description/)

**Topics** - String

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** - <br>
Here the catch is given numbers (num1 and num2) can be of any length and hence we can not convert then (i.e. cast them) to
int or Bigint or any other datatype. We have to keep them as string only and do the multiplication.<br>
Now while multiplying normally we do multiply digit by digit and keep track of carry and then add all numbers. This is what
we will be doing here.

![LC-43 image_1](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_43/src/main/resources/images/LC-43%20image_1.jpg)

![LC-43 image_2](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_43/src/main/resources/images/LC-43%20image_2.jpg)