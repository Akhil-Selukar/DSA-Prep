### 3362 - Zero Array Transformation III

**Question link** - [Link](https://leetcode.com/problems/zero-array-transformation-iii/description/)

**Topics** - Arrays, Priority Queue, Greedy

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
Here we have to minimize the number of queries required to make array zero array hence we will select that query first which 
can reduce maximum number of array elements. Which means we need to use greedy approach here. Now to identify such ranges we will
have to sort the queries (to get starting at given index i) and pull the longest range query first to cover longest range in 
single query. (this can be achieved by priority queue (MaxHeap)). <br>
Next once we started with a range (query) we can decrement elements till its end index. Hence we will have to keep the track of 
such active queries till we reach the end index. Here we can again smartly use priority queue (minHeap) this time, as the smallest
range will end first so we will be able to remove it from active queries first.<br>
At the end when all elements in array are converted to 0, we can simply check the number of queries used and subtract it from
total queries available to get the required answer.

