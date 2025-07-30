### 373 - Find K Pairs with Smallest Sums

**Question link** - [Link](https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/)

**Topics** - PriorityQueue, Arrays

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
As question says 'top k' hence 1st thing to try is queue and stacks.<br>
as we need top k sums hence we will have to add sum in priorityQueue. Also we need pairs hence while adding in result we need to
separate then sum into individual numbers from nums1 and nums2 as well (keep this in mind while formulating structure to add in priorityQueue).
