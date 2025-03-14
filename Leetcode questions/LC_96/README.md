### 96- Unique Binary Search Trees

**Question link** - [Link](https://leetcode.com/problems/unique-binary-search-trees/description/)

**Topics** - Tree, DP

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
Here if we check then in case of n = 0 i.e. no node is present then number of unique ways (BST's) is 1 i.e. empty tree.
If we have 1 node then the number of unique BST's is again 1 (i.e. single node). In case we have 2 nodes than we can arrange them
in 2 unique ways. In case of 3 nodes we can form unique ways as below.
1. If root node is 1, then remaining two nodes 2 and 3 will be on RHS of node 1. Now with those 2 nodes we can create 2 unique ways.
2. If root node is 2, then remaining two nodes will be arranged 1 at each side 1 to LHS and 3 to RHS. And we already know that with 1 node unique ways are 1 only.
3. If root node is 3, then remaining two nodes will be on LHS. And by rearranging those 2 nodes we can create 2 unique trees.

So overall ways to create unique trees are (2+1+2) i.e. 5. So in short, somehow if we are able to find the number of nodes 
to the left and right then we will be able to find the number of unique ways.

Now as it is given that the tree with N nodes will have nodes from 1 to N. Hence if we consider node number n as root node 
then all nodes from 1 to n-1 will be to the LHS and the nodes other than LHS node plus the root node will be on RHS
i.e. (all nodes - (n-1+1)) (n-1 LHS nodes and +1 root node). i.e. (all nodes - n).

Now from this we can simply calculate the unique ways to form tree with N nodes and store it in a DP array to reuse that value and 
calculate further unique ways for n+... nodes.
