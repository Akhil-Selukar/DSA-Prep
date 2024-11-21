### BFS - Breadth First Search

BFS (Breadth First Search) is a tree traversal/searching algorithm where we visit the nodes level by level, which means 
first we will visit the root node, then both the child of root node, then all grandchild and so on. (Have a look at below 
image to understand the BFS better)

![BFS-image-1](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Trees/Images/BFS-image-1.jpg)

In above image we have a binary tree and if we observe the traversal of the tree we are first visiting the root node. Then 
we are visiting all nodes in next level (not visiting only left node and keep on going till left leaf node), and same we are 
repeating. So here we are traversing the tree horizontally. 

#### When to use BFS?
1. If on observation you feel that your answer lie near root node then go for BFS.
2. If you are asked to find something level wise, like find the level whose sum is maximum or anything then go for BFS.

#### Implementation step.
Here we can start with root node and easily print it. Then we can go to left node of the root node and print that node, but 
now as we have already at the left node of root node (node 2 in above image) it is difficult to go back to the right node of root node (i.e. node 3
in above image). Hence, here we need some data-structure to hold the nodes which are there to the left and right of current
node so that we can visit if later.<br>
Now here consider you are at root node (i.e. node 1), so you will put left and right node(node 2 and 3) in some data-structure.
After that you have to retrieve node 2 first and then node 3. While you are at node 2 you again have to store left and right 
node of node 2 (i.e. node 4 and 5) in the data-structure. After that you need node 3 first, before 4 and 5 as node 3 is from 
earlier level. So here we can observe a pattern, we are first retrieving the node which was inserted first, that means 'First
In First Out' which is nothing but the queue. Hence we will use queue here and as and when we visit any node we will store
left and right node in queue and to visit to the next node we will fetch the next node from queue.