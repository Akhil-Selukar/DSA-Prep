### Binary tree.

A Binary Tree Data Structure is a hierarchical data structure in which each node has at most two children, referred to as 
the left child and the right child. It is commonly used in computer science for efficient storage and retrieval of data, 
with various operations such as insertion, deletion, and traversal.

Consider below binary tree.

![Binary tree image](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Trees/Images/Tree%20datastructure%20-%2001.jpg)


#### Some important terminologies.
1. **Size** of a tree - Size of a tree is nothing but the number of nodes in the tree. For the tree in above image size if 7.
2. **Parent** node - a node which has either one or two nodes connected below it is a parent node. (In above tree nodes 10, 8, 12 and 9 are parent nodes because all of them have child present)
3. **Child** node - a node which has parent is a child node. (In above tree 8 and 12 are child to 10 while 9 and 5 are child to 12)
4. **Sibling** nodes -  two nodes are siblings if  they have same parent node. (in above tree 9 and 5 are siblings as they have same parent 12)
5. **Edge** - a hypothetical line which is connecting to two nodes is called as edge.
6. **Leaf** node - a node which does not have any child is called as leaf node. (In above tree nodes 11, 3 and 5 are the leaf nodes)
7. **Height** of a node - height of a node is the maximum number of edges present from a leaf node till that node. (in above tree height of 12 is 2)
8. **Height of tree** - maximum number of edges present from root node till leaf node. (for above tree height is 3)
9. **Depth** of a node - maximum number of edges from root to that node is called as depth of that node. (depth of node 12 is 1)
10. **Level** of a node - level is the difference of height between that node and root node. In other words we can say that 
level is nothing but the number of ancestors a node has. (root node level is always 0 as there is no parent node for it.) (node 8 and 12 are at level 1)


#### Types of trees.
1. **Complete binary tree** - A complete binary tree is a tree where every level except the last one is full, and last level 
must be filled from left to right. Have a look at below image.

![Complete binary tree](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Trees/Images/Complete%20binary%20tree.jpg)

Here in above image 'Tree 1' and 'Tree 3' are complete binary tree while 'Tree 2' is not a complete binary tree. In 'Tree 2'
the last level is not filled in left to right order like 'Tree 3'.

2. **Full or strict binary tree** - In full or strict binary tree all nodes must either have 0 or 2 children. No node with 
only 1 child should be present.

3. **Perfect binary tree** - A perfect binary tree is a tree where all leaf nodes are at the same level and all levels are full.
In below tree we can see that all leaf nodes are at level 2 and there is no space left for another leaf node at 2nd level.

![Perfect binary tree](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Trees/Images/Perfect%20binary%20tree.jpg)

>All 'perfect binary trees' are 'full/strict binary trees' but not all 'full/strict binary trees' are 'perfect binary trees'

4. **Height balanced binary tree** - A height-balanced binary tree is defined as a binary tree in which the height of the 
left and the right subtree of any node differ by not more than 1. In other words we can say the **average height** must be O(log N).

5. **Skewed binary tree** - A skewed binary tree is a tree where every node has only 1 child. The height of skewed binary tree is O(N).

6. **Ordered binary tree** - Ordered binary tree is a binary tree where every node follows some rule or property. For example Binary search tree.
(where left child node is smaller and right child node is greater.)


#### Useful properties of binary trees.
1. In a '**Perfect binary tree**' of height 'h' total number of nodes are '2<sup>(h+1)</sup>-1'
<br>Proof: If we observe a perfect binary tree then the number of nodes in each level are 2<sup>level</sup>. 
(i.e. number of nodes at i<sup>th</sup> level are 2<sup>i</sup>). So if we add all nodes in a perfect binary tree of height h.<br>
2<sup>0</sup> + 2<sup>1</sup> + 2<sup>2</sup> + 2<sup>3</sup> + .... + 2<sup>h</sup><br>
This is nothing but a geometric progression and the answer to this GP is.<br>
   2<sup>(h+1)</sup>-1

2. Total number of leaf nodes in a 'Perfect binary tree' with height 'h' are '2<sup>h</sup>'
3. Total number of internal nodes in a 'perfect binary tree' with height 'h' are '2<sup>h</sup>-1'
   (i.e. total number of nodes - total number of leaf nodes)
4. If we have **'N' leaf nodes** in a binary tree then the least number of levels we have are 'log(N) + 1' levels.
5. If we have **total of 'N' nodes** then minimum levels that we can have are 'log(N+1)'.
6. If we have a **Strict binary tree** with **N leaf nodes**, then number of internal nodes are 'N-1'.
<br>Hence, `Number of leaf nodes = Number of internal nodes + 1`;
7. **Number of leaf nodes in any tree = 1 + number of internal nodes with 2 children.**