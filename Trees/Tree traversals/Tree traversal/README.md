### Tree traversals

Tree Traversal refers to the process of visiting or accessing each node of the tree exactly once in a certain order.
Tree traversal algorithms help us to visit and process all the nodes of the tree.

As tree is a non-linear data structure so unlike arrays or lists we can traverse elements/nodes of a tree in different ways
These different ways are called tree traversal techniques. Below are some of the most important tree traversal techniques.
1. Preorder Traversal
2. Inorder Traversal
3. Postorder Traversal


1. **Preorder Traversal** - In preorder traversal technique we traverse a tree in the order `Node -> Left child -> Right child`<br>
   This traversing technique is mostly used when we are evaluating any mathematical expression or we are making copy of a tree
   or serialization and deserialization. (converting tree to array.)
2. **Inorder Traversal** - In inorder traversal technique we traverse the tree in the order `Left child -> Node -> Right child`<br>
   The use/advantage of this traversal technique is when we do inorder traversal in binary search tree, we get elements in sorted order.
3. **Postorder Traversal** - In postorder traversal technique we traverse the tree in the order `Left child -> Right child -> Node`<br>
   This traversal technique is used when we want to delete the tree or whenever calculations are done using bottoms-up approach.

![Traversal techniques](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Trees/Images/Tree%20traversal%20techniques.jpg)