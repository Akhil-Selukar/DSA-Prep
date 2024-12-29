### 198 - House robber

**Question link** - [Link](https://leetcode.com/problems/house-robber/description/)

**Topics** - Recursion, DP

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
Here you are given N houses and you can start robbing houses from any house just the condition is you can not rob adjacent 
houses. And the goal here is to maximize the loot. So here to maximize the loot we need to check all the possible combinations
of houses that can be robbed and then compare the loot to get the maximum one. As we need to check all the combinations 
definitely this is a recursion problem. <br>
Now if we start from last house i.e. house N, then we have two options either we can rob that house or we can skip that house.
If we decide to rob it then we can not rob (N-1)<sup>th</sup> house but if we decide to skip it then we can rob (N-1)<sup>th</sup>.
So at every house we reach we will have these two options and based on the option we select we will have to decide the next
house we can rob. So the recursion tree and recurrence relation will be like below.

![LC-198 image-1](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_198/src/main/resources/images/LC-198%20image-1.jpg)

Here after analyzing above recursion tree we can easily say that at each step we have two choices to make, and finally we
need maximum of oll possible options. So the recurrence relation will be.
`maxLoot = Math.max(currentLoot + f(n-2), f(n-1))`
Here if we choose to rob the house in that case we will add the loot from that house in our current loot and we will move 
to the house next to adjacent one hence `currentLoot + f(n-2)`

Now here we are recalculating same values many times like f(2) in above recursion tre, hence we can use Dynamic programming 
and optimize the solution further.

