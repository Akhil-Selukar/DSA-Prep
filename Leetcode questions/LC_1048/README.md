### 1048 - Longest string chain

**Question link** - [Link](https://leetcode.com/problems/longest-string-chain/description/)

**Topics** - Arrays, String, DP 

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
Here we need to find the length only and we can take element in any order. Also we know that for valid chain the difference 
between current word and next word will be of only 1 character. Hence we can first sort the given array based on string length
, then we can start from last word and in that we can try deleting character at each place one by once and check if it matches
with the previous word or not. If it matches then we can consider it in the longest chain else not. And we can repeat this 
for all words.  
