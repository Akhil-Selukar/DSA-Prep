### Self-balancing tree (AVL Tree)

In 'binary search tree' we saw that the node with smaller value goes to the left side of parent node and node with greater 
value goes to the right of the parent node, and in case of properly balanced tree with N nodes the height is 'log(N)' so 
if we want to search any element then the time complexity will be O(og(N)) as we know that the all smaller elements are at 
the LHS and all greater elements are at the RHS so we have to traverse only 1 path.

But there is a problem here. Consider we are adding element in the binary search tree in sequence `2,4,5,6,8,9.13,17`. Now
if we observe the tree created for this it will not be balanced.

![Imbalanced BST](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Trees/Images/imbalanced%20BST.jpg)

In above case as 2 is added first so root node became 2 then all the subsequent nodes added were greater that the previous 
one hence all were added to the right of previous node. Now if we want to search any element in this tree then we need to 
traverse through all the nodes and time complexity will become O(N), which is not good in case of tree. Hence, we need some 
sort of technique which can balance the tree automatically as soon as a node causing the imbalance is added. This is what 
is achieved by using self-balancing trees. There are many ways to implement self-balancing trees but the most important is
AVL tree. (Adelson, Velsky and Landis tree)

#### Algorithm for AVL tree :
**Step 1** - Insert the new node normally. (Node N)<br>
**Step 2** - Start from newly added node N and go up to find the node which makes the tree imbalance.<br>
**Step 3** - Using one of the 4 cases/rules below rotate the tree to make it balance.

**Case 1 - Left-Left case**<br>
Consider a perfectly balanced tree below, and we want to add new node '3'.

![AVL-case1-image1](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Trees/Images/AVL-case1-image1.jpg)

Here when we add new node '3' normally it will go left to the node '4'. Now as per step 2 if we start checking from newly 
added node upward, then node 3 is perfectly balanced, then node 4 is also perfectly balanced, node 5 is also balanced, 
node 6 is also balanced but node 8 is not balanced (the left hand side tree for node 8 has height 3 and right hande 
side tree has height 1. The difference 2 is greater than 1).<br>
Now here if we check the path from node where imbalance is present till the newly added node, the parent will be the node
at which imbalance is present, the child will be the node 5 and grand-child will be node 4.<br>

![AVL-case1-image2](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Trees/Images/AVL-case1-image2.jpg)

Here child (node 5) is left to parent (node 8) and grandchild (node 4) is also left to child (node 5), hence it is 'Left-Left case'
In this case to make the tree balanced we rotate the imbalanced tree right once.
(Here in place of node 6 and node 10 there can be any sort of subtree.)

![AVL-case1-image3](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Trees/Images/AVL-case1-image3.jpg)

Now, if we see the tree is balanced. (Here note that we have changed the parent for node 6 so that it should follow the rule
for binary search tree). After right rotation the tree is now perfectly balanced and all left nodes for each node are smaller
while all right nodes are greater. 

**Case 2 - Left-Right case**<br>
Here instead of adding node 3 in the perfectly balanced tree in above case, consider we want to add node 7.
The node 7 will be added to the right of node 6 as 7 is greater tha 6.

![AVL-case2-image1](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Trees/Images/AVL-case2-image1.jpg)

Now in this case if we start checking from the newly added node i.e. node 7 and go upward while checking for imbalance.
We can see that node 7 is perfectly balanced, node 6 is also balanced, node 5 is also balanced, but node 8 is not balanced.
So in this case if we check the path from imbalanced node till the newly added node which caused the imbalance we can see 
that the parent is node 8, child is node 5 and grandchild is node 6.

![AVL-case2-image2](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Trees/Images/AVL-case2-image2.jpg)

Here the child node (node 5) is to the left of parent (node 8) and grandchild (node 6) is to the right of child (node 5)
hence it is Left-Right case.<br>
To make this tree balance we first need to rotate child node to left so that all (parent, child and grandchild can be in a straight line)

![AVL-case2-image3](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Trees/Images/AVL-case2-image3.jpg)

Now after left rotation we can see that this became just like case 1. Hence, next thing we can do is to rotate right once.

![AVL-case2-image4](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Trees/Images/AVL-case2-image4.jpg)

Here we can see that after right rotation now the tree is completely balanced.


**Case 3 - Right-Right case**<br>
Consider below tree and in this tree want to add node 15.

![AVL-case3-image1](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Trees/Images/AVL-case3-image1.jpg)

Here node 15 will go to the right of node 12. Now in this case if we start from the newly added node and go upward to check
imbalance, we will see that node 7 is imbalanced node. (because left side of node 7 has height 1 and right side has height 3,
so the difference between height is greater than 1)</br>
In this case if we observe the path from imbalanced node till the newly added node we can see child is to the right of parent
and grandchild is also to the right of child node. (refer below image). Hence, this is called 'Right-Right case'.

![AVL-case3-image2](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Trees/Images/AVL-case3-image2.jpg)

Now to make this tree balanced we need to perform a left rotation.

![AVL-case3-image3](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Trees/Images/AVL-case3-image3.jpg)

After left rotation we can see that the tree is balanced now.


**Case 4 - Right-Left case**<br>
In above tree instead of 15, consider we have to add new node 8.

![AVL-case4-image1](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Trees/Images/AVL-case4-image1.jpg)

Now here if we start checking from newly added node and go upward we can find that the imbalance is occurred at node 7.<br>
Hence if we check the path from node 7 to node 8 (i.e. imbalanced node till newly added node) we can identify parent, child and
grandchild as below.

![AVL-case4-image2](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Trees/Images/AVL-case4-image2.jpg)

So here the child is at the right of parent and grandchild is at the left of child hence this is 'Right-Left case'.<br>
To make this tree balance, first we need to rotate the child node right once.

![AVL-case4-image3](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Trees/Images/AVL-case4-image3.jpg)

After this rotation we have parent, child and grandchild all in same line, so this is just like case 3 now.<br>
So to balance this state we need to rotate it left once.

![AVL-case4-image4](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Trees/Images/AVL-case4-image4.jpg)

After left rotation we can see that the tree is perfectly balanced now.

> If we check the time complexity for AVL tree. Then addition of new node will take O(log(N)) as at all the time tree will be
> balanced. Now after addition of node if we need to re-balance the tree then in that scenario we have already seen in above 
> 4 cases that at max 2 rotations/steps will be needed to balance the tree. Hence, rotation will take constant time complexity.
> So overall time complexity will be O(log(N)).