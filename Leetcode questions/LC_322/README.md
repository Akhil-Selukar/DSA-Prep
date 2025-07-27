### 322 - Coin change

**Question link** - [Link](https://leetcode.com/problems/coin-change/description/)

**Topics** - Recursion, DP.

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
Here we are given with coins array and we have to create target total using the least number of coins. First approach which 
we might think is greedy approach. Like if the coins array is [1, 2, 5] and target is 11, then take the coin with the 
highest denomination and divide target with it `11/5` we will get 2. So we can take 2 coins of denomination 5. Now remaining
target will be of 1 so if we check for next highest denomination i.e. 2, then `1/2` will give us 0 coins of denomination 2.
Next highest denomination will be 1 so `1/1` will give us 1 coin of denomination 1 and remaining target will be 0. So the 
target is achieved and we need at least 3 coins to achieve the target `[5, 5, 1]`.<br>

But if we consider coins array like [9, 6, 5, 1] and target as 11. In this case if we use greedy approach we will get 
`[9, 1, 1]` i.e. 3 coins to reach the target. But the minimum coins we can take are 2 `[6, 5]` and we can still reach the 
target. Hence greedy algorithm will not work here. Hence we will have to explore all the possible combinations and then 
take the one with minimum coins. As here we have to explore all possible ways so we need to use recursion here.<br>

One thing to notice here is we have infinite supply of coins, which means we can take same coin again and again infinite 
number of times. But in traditional recursion approach we either take the current value or we do not take it and **move to 
the next value**. Here as we infinite supply of coins so if we have decided to take the coin that means the target is 
greater than the denomination of that coin then only we can take it. And it is possible that after taking 1 coin still 
the target is more that the denomination hence if we are taking the coin we shall not move to the next coin, instead we 
need to check for the same coin again. If our target is smaller than the denomination of current coin then only we should 
move to next coin as if is confirmed that we can not take that coin even once so there is no point in checking for the same 
coin again and again. 

> This is the most important point here, whenever in case of recursion we have infinite supply of element which we can 
> either take or not take. In that case move to next element only in case of not take. In case of take, check that same 
> element one more time for new/reduced target.

#### Another approach (Optimized)

Here we can try creating each amount starting from 1 till given amount using each coin like below. 
(amount 0 will always require 0 coins so we can directly put 0 for amount 0).

![LC-322 image](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_322/src/main/resources/images/LC-322%20image_01.jpg)