### 2163 - Minimum Difference in Sums After Removal of Elements

**Question link** - [Link](https://leetcode.com/problems/minimum-difference-in-sums-after-removal-of-elements/description/)

**Topics** - PriorityQueue, Arrays

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
In two different arrays keep track of minimum sum to the left of current index and maximum sim to the right of current index.
The resultant sum will be minimum when firstSum is smallest and secondSum is largest.
At the end for index i check left min sum at ith index and right max sum at (i+1)st index and check the difference.  
