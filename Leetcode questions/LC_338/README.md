### 338 - Counting Bits

**Question link** - [Link](https://leetcode.com/problems/counting-bits/description/)

**Topics** - Logic, DP (without recursion);

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
Solution 1 - We can write a simple function which count set bit of given number. But this function has to iterate over all bits of the number hence its complexity will be log(num) and we will have to do this for all numbers hence overall complexity will be O(NLog(N)).<br>

Solution 2 - if we observe carefully then number of set bits in number x is always equal to number of set bits in x/2. Also in case of odd number, number of set bits in number Y is always equal to (number of set bits in Y/2) + 1.<br>
This we can use and populate the required values using for loop.



