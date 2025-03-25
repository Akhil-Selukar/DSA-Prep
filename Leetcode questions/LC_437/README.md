### 437 - Path sum III

**Question link** - [Link](https://leetcode.com/problems/path-sum-iii/description/)

**Topics** - Tree, prefix sum

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
Here at each node we will keep on counting the sum possible and ways to get that sum. 
During traversal if we encounter any (sum - target) difference equal to already got value (sum - target = knownValue) then 
we can get the target by (sum - knownValue = target). i.e. entire current path from root till current node we can subtract
path where we had observed the knownValue as sum. (we will get the subpath or internal path)
