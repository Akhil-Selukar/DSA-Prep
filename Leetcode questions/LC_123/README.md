### 123 - Best time to buy and sell stock III

**Question link** - [Link](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/)

**Topics** - Arrays, Recursion, DP

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
This problem is extension of the problem [LC-122 Best time to buy and sell stock II](https://github.com/Akhil-Selukar/DSA-Prep/tree/master/Leetcode%20questions/LC_122). 
In base problem we were allowed to do as many transactions as we want, but in this problem we are only allowed to do two 
transactions. Rest entire problem is same. Now as we are capped with two transaction and other conditions are same, hence 
we can just restrict the existing code of base problem to restrict it only till two transactions.

The important point to note here is 1 transaction is said to be completed when we perform both buy and sell operation. 

