### 790 - Domino and Tromino Tiling

**Question link** - [Link](https://leetcode.com/problems/domino-and-tromino-tiling/description/)

**Topics** - Maths, DP with loop

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
In all such problems where we are asked to find number of ways we can arrange and all, if nothing is working then try writing 
the solutions for some test cases from starting.

for n=0 answer will be 0, for n=1 answer will be 1 for n=2 answer will be 2, if we write these values...

n = 0 ----> 0<br>
n = 1 ----> 1<br>
n = 2 ----> 2<br>
n = 3 ----> 5<br>
n = 4 ----> 11 ----> i.e. `2 * 5 + 1` <br>
n = 5 ----> 24 ----> i.e. `2 * 11 + 2`<br>
n = 6 ----> 53 ----> i.e. `2 * 24 + 3`<br>

If we carefully observe we can see a pattern here i.e. `F(n) = 2 * F(n-1) + F(n-3)`<br>
If we store first 4 values i.e. n=0 till n=3 then after that for all n the formula holds true. 
