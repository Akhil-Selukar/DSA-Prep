### 134 - Gas station

**Question link** - [Link](https://leetcode.com/problems/gas-station/description/)

**Topics** - 

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br> 
For simplicity consider cost as distance from current gas station to next gas station.<br>

Here if we check all the possible conditions (i.e. with valid solution and without valid solution) we can observe that
the valid solution only exist if the total gas that we can get from all stations is either greater than or at-least equal 
to the distance (cost) we want to travel. So first thing we can do is to check this condition and if it is not satisfied
we can simply return -1. <br>
Now next challenge is while iterating over the given array we can keep on checking till last element but if we are starting 
from some middle index (i) then to check if we can travel till 'i-1' we need to check from 0 till i-1 again after reaching 
to the end of array. Well this is not required because if we have 1st condition satisfied then at the end we will for sure 
have some gas left or at-least enough gas left to reach gas station at index 0 and then we can continue further till i-1.
So in short if from some index 'i' we are able to reach till end of the array and 1st condition is satisfied then we can 
safely say that we can reach till 'i-1' now. (try to simulate valid scenario using pen and paper to understand this better.) 
