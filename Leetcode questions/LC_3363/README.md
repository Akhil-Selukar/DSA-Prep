### 3363 - Find the Maximum Number of Fruits Collected

**Question link** - [Link](https://leetcode.com/problems/find-the-maximum-number-of-fruits-collected/description/)

**Topics** - Arrays, Recursion, DP

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
Here the most important detail given is we have to reach to (n-1, n-1) cell **by using exactly 'n-1' steps**.<br>
Now if child 1 starting from (0,0) has to reach to (n-1, n-1), he has no other option than to move diagonally. (if he take 
even a single move other than diagonally, he will not be able to reach to the destination). So all fruits collected by child 1
are nothing but sum of diagonal elements. (including last (n-1, n-1) element).

Now if we draw all possible path with the given constraints for child 2, we can observe that child 2 can never go below diagonal.
If we move below diagonal he will not be able to reach the destination. So this is a very important detail we got. We dont have 
to move below diagonal for child 2. 

Similarly, for child 3 we can't go above diagonal element. 

Also, it is important to keep in mind that we have already picked up the fruits at (n-1, n-1) using child 1 hence for other 2 children
we don't need to pick the last cell.

------------------
#### Intuition for bottom-up approach

For child 1 same thing as that of above. We can just traverse all diagonal elements at keep on adding then (just like prefix sum but diagonally).

For child 2 if we observe carefully in row 2 child 1 can travel from row 1's three positions (0, n-2), (0, n-1) and (0, n).
But it is given that he is starting from (0, n-1) so he will not be able to collect fruits from (0, n-2) and (0, n) will be out of bounds.
If we check for row 3 and check from where he can come to row 3 and so on for all rows (keeping in mind that he can not go below diagonal).
We can observe that there is a triangle (inverted triangle) in grid above diagonal where child 2 can never reach. That triangle is important to 
mark as 0 in bottom-up approach

Similarly, in case of child 3 there will be a triangle pointing to right which can not be visited by child 3.

```
1  0  0  0  0  0  2
0  1  0  0  0  2  2
0  0  1  0  2  2  2
0  0  0  1  2  2  2
0  0  3  3  1  2  2
0  3  3  3  3  1  2
3  3  3  3  3  3  1
```

In above grid we can clearly see at which position which child can visit. The places marked with 0 are the places no child 
can visit even.

> Important thing to keep in mind while developing bottom up approach here is last cell (n-1, n-1) is already visited bu child 1
> hence child 2 and child 3 we will not take them to last cell.