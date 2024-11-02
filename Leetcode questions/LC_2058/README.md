### 2058 - Find minimum and maximum number of nodes between critical points

**Question link** - [Link](https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/description/)

**Topics** - LinkedList

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1. Here one question you can ask. What if there is only 1 critical nod exist in given list. In that case minimum and maximum 
distance will be [0, 0], or we have to return [-1, -1]?  

**Intuition** -<br>
Here we can identify the critical pointers easily by traversing the LinkedList from second node with three pointers (previousNode,
currentNode, nextNode) and keeping the track of these points to calculate minimum and maximum distance further. But the most 
important part here is to perform this efficiently.<br>
What we can do here is we can start from second node and check for critical nodes, and we can maintain three pointers. 
One for first critical node, another for last critical node (not actual last but the last found) and third for the minimum 
distance between critical nodes. Now as and when we identify a critical node we can update these pointers. The minimum distance
will be updated (if required) on identifying every critical node and the maximum distance we can calculate at the end by 
calculating the distance between first and last critical node. <br>

By this way the iterations required will be only 1 hence time complexity will be O(N) and as we are not using and additional
data structure which is dependent on length of list so space complexity will be O(1).

