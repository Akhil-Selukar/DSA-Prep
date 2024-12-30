### 62 - Unique paths

**Question link** - [Link](https://leetcode.com/problems/unique-paths/description/)

**Topics** - Recursion, Dynamic programming 

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
Here we are asked to find all the possible ways hence we will have to consider all possibilities when we are standing at a 
point. Here robot can move either right or down hence there are two possibilities for each cell. Hence at every iteration 
we will have two choices and we need to choose one first and test if we can reach till destination or not. If yes then we 
will count it in the total number of unique paths otherwise we will not count it. Then we will go with second option. This 
is nothing but the recursion. Also if we draw the recursion tree here we will see the repeating sub-problems hence we can 
apply DP as well.
