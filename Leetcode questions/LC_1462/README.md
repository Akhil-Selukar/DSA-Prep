### 1462 - Course Schedule IV

**Question link** - [Link](https://leetcode.com/problems/course-schedule-iv/description/)

**Topics** - Graph, Topological sort

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
Whenever we are required to anything with prerequisites then always think of topo sort.<br>
But in this question we need to consider entire parent hierarchy as well (i.e. if 'A' is prerequisite of 'B' and 'B' is prerequisite
of 'C' then 'A' is implicitly considered as prerequisite of 'C'. In this case we might think of disjoint set because of path
compression. But important thing to note that is during path compression we get ultimate parent only and not the parent in between.
I.e. if the chain is something like `A->B->C->D->E` then in disjoint set parent for all will be 'A' and we will not be able to 
answer the query is B prerequisite for D, as D will point A as its ultimate parent.<br>

Hence here we can use a 2D matrix where in column we will consider all child and in row we will have all parent.
in that case each column will have a cell corresponding to each row which means each child has a cell to store its relation with
every other node (relation -> is that node in column has other node in row as parent)<br>

We can fill this matrix simply during topo sort. If we have an edge from U to V, where U is the node fetched from queue during topo sort.  
so that means there is no indegree left for U and all parents of U were marked before. So we will iterate from 0 to n and see what all
nodes are marked as parent for U and those node we will mark as parent for V as well because as X is parent of U and U is parent to V
then X is also a parent of V. 

This solution/Topological sort will work here because in constraints it is given that there is no cycle present in the graph.
