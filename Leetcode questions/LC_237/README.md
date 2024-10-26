### 237 - Delete node in a LinkedList

**Question link** - [Link](https://leetcode.com/problems/delete-node-in-a-linked-list/description/)

**Topics** - LinkedList, Restructuring

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
Here in the question it is given that we are not given with the actual head of the LinkedList, instead the given node is the 
node which we want to delete. Also, the list is singly LinkedList so we can not move backward, neither do we know the 
number of nodes in the LinkedList. So the simplest way to just take the previous node of the node to be deleted and point its 
next to the next node of node to be deleted will not work here.<br>

So what we can do here is we can start from given node and shift all the elements after that node one place left and simply
remove the last node. This will work but in this approach shifting of all nodes will be required. So what we can do alternatively 
is we can just copy the value of next node to the node to be deleted (by that way only 1 shifting will be required) and then
point the node to be deleted to the node after its next node. (so here we are actually deleting the next node of given node
but before doing that we are copying that node to given node so that effectively the deleted node will be the given one.)

![LC_237 explanation.jpg](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_237/src/main/resources/images/LC-237.jpg)
