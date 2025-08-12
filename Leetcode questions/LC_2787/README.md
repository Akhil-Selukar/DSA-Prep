### 2787 - Ways to Express an Integer as Sum of Powers

**Question link** - [Link](https://leetcode.com/problems/ways-to-express-an-integer-as-sum-of-powers/description/)

**Topics** - recursion, DP

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
If we want to form `n` by adding some numbers pi to the power `x`  i.e. (p1<sup>x</sup> + p2<sup>x</sup> + p3<sup>x</sup> + ... + pi<sup>x</sup>)
then it is obvious that pi<sup>x</sup> can only go till n (hence pi<sup>x</sup> <= n). <br>
So we can get an array of [p1, p2, p3, ..., pi]. Then next part is we have to find subsequence from the array which gives addition 
equal to n. This is nothing but the recursion problem (DP).

