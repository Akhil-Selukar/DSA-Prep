### 312 - Burst balloons

**Question link** - [Link](https://leetcode.com/problems/burst-balloons/description/)

**Topics** - Recursion, DP

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
Here when we burst any balloon the points scored are multiplication of number written on that balloon and the adjacent 
balloons. Hence if we think of bursting a balloon and dividing the problem into smaller sub-problems of left balloons and 
right balloons. Then what if we burst the balloon at right edge of left sub-problem. We need value on the balloon which is 
on the right hand side neighbour, but that balloon is not the part of current sub-problem. Hence we can clearly see that 
the sub-problems are not independent of each other hence we can not solve them separately.<br>
Now to make sub-problems independent we can take reverse approach. i.e. instead of bursting the balloon at first, we can burst 
i<sup>th</sup> balloon at last. By this way we will be assured that all balloons to the left of i<sup>th</sup> balloon 
will have right neighbour as i<sup>th</sup> balloon and all balloons at right side of that balloon has left neighbour as 
that balloon. Now we can see that the sub-problems are independent.

Refer [this video](https://www.youtube.com/watch?v=VFskby7lUbw) for better understanding.

