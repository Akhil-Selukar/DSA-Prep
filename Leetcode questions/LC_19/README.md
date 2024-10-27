### 19 - Remove Nth node from end of list

**Question link** - [Link](https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/)

**Topics** - LinkedList

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
Here the second solution is we are creating a dummy node and adding it before the head of actual LinkedList so the next of temp
node will be the head. then we are shifting the head 'n' places right, and again starting a pointerNode from actual head. 
Now if we move both (pointerNode and shifted head) at a time, then at the point when head becomes null the pointerNode will
be exactly at the node previous to the one which need to be deleted. Once we are at that node then it is easy to delete the node
by just altering the .next relations.
