### 1203 - Sort Items by Groups Respecting Dependencies

**Question link** - [Link](https://leetcode.com/problems/sort-items-by-groups-respecting-dependencies/description/)

**Topics** - Graph, Topological sort

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
Here we not only have to sort based on which element should be before which one, but we need to ensure that the same group 
elements are also together keeping the original order same. Which means we need to sort groups as well as items in topologically 
sorted order.<br>
To achieve this we can first sort all elements topologically based on who need to be before whom. Then we can sort groups 
and after that collect elements (in sorted order) based on group and arrange them in required result list.

For this to implement we need group graph as well and for that we need to first assign some group for those elements which 
does not belong to any group. (These elements will be single element in a group).
The steps to solve this question will be like below.

1. Assign groups to single/ungrouped elements.
2. Create in-degree and adjacency lists for group and elements
3. Topological sort for elements.
4. Topological sort for groups.
5. Arrange elements based on group 
