### 987 - Vertical order traversal of a binary tree

**Question link** - [Link](https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/description/)

**Topics** - Tree, priorityQueue

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
Here in question the if we read the meaning of 'vertical order traversal' we are told 3 things.
1. `each column index starting from the leftmost column and ending on the rightmost column.` Meaning we need to start from 
leftmost column, so we need all nodes sorted based on their x-coordinate.
2. `top-to-bottom orderings for each column index.` Meaning if there are multiple nodes in a single column then those must
be sorted top-to-bottom, so we need all nodes sorted based on y-coordinate as well.
3. `There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values.` Meaning
if there are multiple nodes at same coordinates then those need to be sorted based on their value.

So overall we first need to group nodes based on x-coordinate then need to sort them based on y-coordinates and then if 
both are same in that case based on value.

Now to do this sorting we need to store the coordinates of all the nodes so we need a class which will hold value of that 
node, it's x-coordinate, and it's y-coordinate. Once we have that class we will have to create object of that class for all
nodes and store that object in some data structure based on above 3 rules. Then we can retrieve the objects from the data-structure
and for all such objects where x-coordinate is same we can group their values in a list and add that list in our result list.

Now here for this type of operation we can use priorityQueue, because priorityQueue provides us with comparator which allow
us to write our comparison rules. 

![LC_987 image-1](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_987/src/main/resources/images/LC_987%20image-1.jpg)
