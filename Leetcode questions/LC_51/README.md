### 51 - N-Queens

**Question link** - [Link](https://leetcode.com/problems/n-queens/)

**Topics** - Recurssion, Backtracking

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -
Here obviously we can/have to place 1 queen in each row, so we will have to go row by row. That means first we will place first queen 
in first row then we will go to second row there we will find safe spot for queen to place and place the queen there, then we
have to go to 3rd row again find safe spot and put the queen there so it is clear that we have tp use recursion.
Now while placing first queen in first row all places in first row will be safe so we can put the queen anywhere in first row.
but as we keep on going down the rows it might happen that the choice we made in first or second or any of the previous row 
is not allowing us any safe spot in current row. So we might need to undo our decision and rethink from first row. Hence we 
need to consider backtracking as well.
