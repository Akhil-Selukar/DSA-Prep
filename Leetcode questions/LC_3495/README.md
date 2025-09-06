### 3495 - Minimum Operations to Make Array Elements Zero

**Question link** - [Link](https://leetcode.com/problems/minimum-operations-to-make-array-elements-zero/description/)

**Topics** - 2D-array, Maths

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
Here bruteforce approach can be for every range [l, r] we can add all elements from l to r in a priorityQueue and then every time
take out two largest elements and divide them by 4. If we get division as 0 then fine otherwise we will add non-zero division value back
to queue and repeat this till queue becomes empty. The number of step required we can count via a counter here.

This approach will work but as the constraints are higher i.e. l can be 1 and r can be 10<sup>9</sup> so total 10<sup>9</sup> elements in 
1 range and there can be 10<sup>5</sup> such ranges. So this approach will for sure give TLE. (but is it good to explain this 
approach in interview.)

Now the optimized approach is, if we check for some pattern then the constant operation is divide each element from the range 
by 4, and we get constant value for some group of elements. So if we could identify the groups then we can break the range in
groups and find the count. So let's check the relation between value and it's division value.

for `val=1` steps required `s=1`<br>
for `val=2` steps required `s=1`<br>
for `val=3` steps required `s=1`<br>
for `val=4` steps required `s=2` (because 4/4 = 1 (step 1), then 1/4 = 0 (step 2)).<br>
for `val=5` steps required `s=2`<br>
for `val=6` steps required `s=2`<br>
for `val=7` steps required `s=2`<br>
for `val=8` steps required `s=2`<br>
for `val=9` steps required `s=2`<br>
for `val=10` steps required `s=2` (because 10/4 = 2 (step 1), then 2/4 = 0 (step 2)).<br>
.<br>.<br>.<br>
for `val=15` steps required `s=2`<br>
for `val=16` steps required `s=3`<br>
for `val=17` steps required `s=3`<br>
for `val=18` steps required `s=3`<br>
.<br>.<br>.<br>
for `val=63` steps required `s=3`<br>
for `val=64` steps required `s=4`<br>


Here we can observe that for val range from 1 to 3 we need 1 step, value ranging from 4 to 15 we need 2 steps and so on 
So in general 

for range [4<sup>s-1</sup>, 4<sup>s</sup>-1] we need s steps.

> After above observation the only thing we need to take care while writing the code is if in case given range of [l, r] lies 
> in partially in one range of s steps and partially in another range of s+1 steps.