### 1043 - Partition array for maximum sum

**Question link** - [Link](https://leetcode.com/problems/partition-array-for-maximum-sum/description/)

**Topics** - Array, Recursion, DP

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
This problem is very similar to that of [LC-132 Palindrome partitioning II](https://github.com/Akhil-Selukar/DSA-Prep/tree/master/Leetcode%20questions/LC_132)
.Here as well we will have to use the front partitioning and restrict the partition size to the given value (i.e. k).  
Next thing is we need to update the partition elements with the maximum values and then add all the elements. Which is 
nothing but multiplying the maximum value in that partition with partition length. Hence while creating partition we need 
to make sure that we calculate and keep the max value and the partition length as well (as few partitions can be of length
smaller than k hence we can't directly multiply by k).
