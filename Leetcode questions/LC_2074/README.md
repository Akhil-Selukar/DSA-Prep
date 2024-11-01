### 2074 - Revere nodes in even length groups

**Question link** - [Link](https://leetcode.com/problems/reverse-nodes-in-even-length-groups/description/)

**Topics** - LinkedList, List reversal

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>

It is given that we have to reverse the even length group and at first glance it is obvious that all even numbered group 
will have even number of nodes. But the important thing to notice here is that the last group which might not be the even 
numbered group, but it can have even number of nodes (incomplete group) in that case we do have to reverse that group 
(3rd testcase in given testcases on leetcode). So it is important here to count number of nodes in each group along with 
tracking which group it is.
