### 143 - Reorder List

**Question link** - [Link](https://leetcode.com/problems/reorder-list/description/)

**Topics** - LinkedList, Slow-fast pointers

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
In this question we are asked to re-arrange the given LinkedList in specific pattern. Here as well the first thought can be 
lets take two pointers one from start i.e. head and second from end i.e. tail and then take elements one by one and add in
another list as per requirement. But here as well we have a problem that we can not move backward from last node, we can 
only go forward. Hence, here as well we can find the middle element and the reverse the list from middle till end and then
take two pointers one from start i.e. head and another form middle node and move both the pointers forward to get respective 
elements.
