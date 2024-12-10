### 207 - Course schedule

**Question link** - [Link](https://leetcode.com/problems/course-schedule/description/)

**Topics** - Graph, Topological sort

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
Here we have dependency between two courses (i.e. one course can only be done if another is completed earlier.). Same kind of 
condition we follow in topological sorting order as well. We can write a node in the order only if the node which has inDegree 
to that node is already added in the sorted order. (Which is nothing but unless prerequisites are added in topological sort
we can not add current node.)<br>
Now if there is any such condition where prerequisites can not be achieved then that means we have a condition like 
A should be done before B and at the same time B should be completed before A. (i.e. cyclic dependency.) hence the question
is nothing but finding the cyclic dependency. If cyclic dependency is present then the courses can not be completed, else
we can complete the courses.

