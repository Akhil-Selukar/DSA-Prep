### Disjoint sets

Consider you are given below graph and asked is node 3 and 5 belong to same component or not?

![Disjoint set image-1](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/Disjoint%20set/images/Disjoint%20set%20image-1.jpg)

Even though the below is one single graph but there are two components (one is 1->2->3->4 and another is 0->5->6->7). 
As there is no connection or edge between these two components hence nodes 3 and 5 does not belong to same component. 
But how we can identify this?

Well one approach can be to start from node 3, do a BFS or DFS and check if we can reach till 5 or not. If we acn reach till
5 then that means those nodes are part of same component and if we are not able to reach till 5 then we can say that node
3 and 5 are in different components. <br>
But in case of BFS or DFS we have linear time complexity consider we are given linear graph of 1000 nodes and asked if
first node and last node are in same component or not. In this case we will have to traverse through entire 1000 nodes and 
then we can conclude the answer. Also what if in between the iteration the graph got updated in that case we might get 
incorrect answer. Hence, to solve this problem we use disjoint set.<br>
Disjoint sets give answer to above question in constant time complexity. Also disjoint set works in case of dynamic graphs
as well (i.e. changing graphs). Disjoing sets gives us two functionalities 
1. Finding the parent of any node
2. Union<br>
    a. Rank<br>
    b. Size


#### Union using rank<br>

To perform union using rank we need some initial configuration. First thing we need is a rank array which will be of 
size equal to number of node so that we can store rank of each node. Second is parent array and initially we will consider 
all nodes as orphan (i.e. they are parent of itself).

![Disjoint set image-2](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/Disjoint%20set/images/Disjoint%20set%20image-2.jpg)

Now the steps to perform union are:<br>
To find union of pair (U, V) i.e. pair from edges.
1. Find ultimate parent of U and V (uParentU, uParentV). Ultimate parent means the topmost parent (root node).
2. Find rank of uParentU and uParentV using rank array.<br>
   a. If both the ranks are equal then we can attach any node to other one and update patent and rank array accordingly.<br>
   b. Otherwise, always attach node of lower rank under the node of higher rank and update rank and parent arrays accordingly.
3. repeat the steps for all edges given.

First edge given in above example is (1, 2) `U = 1` and `V = 2`, hence we will find the ultimate parent of 1 and ultimate parent of 2 using parent 
array. For both the nodes as of now parent is that node itself, hence `uParentU = 1` and `uParentV = 2`. Now if we check 
ranks of ultimate parents then rank of both are 1 only hence we can attach any node under any node. (Here we are attaching 
node 2 under node 1). After attaching node 2 under node 1, parent of node 2 will change to 1 and rank of node 1 will be 
now 1. (rank is kind of similar to height of tree only.)

![Disjoint set image-3](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/Disjoint%20set/images/Disjoint%20set%20image-3.jpg)

Now in next iteration we will have edge (1, 3) i.e. `U = 1` and `V = 3`, hence we will find ultimate parents. `uParentU = 1`
and `uParentV = 3`. After this the rank of 1 is 1 while rank of 3 is 0. Hence node 3 will be attached below node 1, so 
parent of 3 will be updated to 1. As both 2 and 3 are at the same level under 1 hence there won't be any change in rank of 1.

![Disjoint set image-4](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/Disjoint%20set/images/Disjoint%20set%20image-4.jpg)

Next edge is (3, 4) so `U = 3` and `V = 4`,<br> `uParentU = 1` and `uParentV = 4`.<br>
`rank(1) = 1` and `rank(4) = 0`.<br> 
Here rank of ultimate parent of 3 is higher than the rank of ultimate Parent of 4 hence we will attach 4 under 3. After
this addition the rank of 3 will be updated to 1 and rank of 1 will be updated to 2.

![Disjoint set image-5](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/Disjoint%20set/images/Disjoint%20set%20image-5.jpg)

Next edge is (0, 5). So `U = 0` and `V = 5`,<br> `uParentU = 0` and `uParentV = 5`.<br>
`rank(0) = 0` and `rank(5) = 0`.<br>
As we have same ranks for both U and V hence we can attach any node under other one. Here we are attaching 5 under 0 hence 
rank of 0 will be updated to 1 and parent for 5 will be updated to 0.

![Disjoint set image-6](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/Disjoint%20set/images/Disjoint%20set%20image-6.jpg)

Next edge will be (5, 6). So `U = 5` and `V = 6`,<br> `uParentU = 0` and `uParentV = 6`.<br>
`rank(0) = 1` and `rank(6) = 0`.<br>
As the rank of ultimate parent of node 5 is greater than the rank of ultimate parent of 6 hence node 6 will go under node 5.
Hence, rank of node 5 and it's parent will be updated, also parent of 6 will become 5. 

![Disjoint set image-7](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/Disjoint%20set/images/Disjoint%20set%20image-7.jpg)

Next edge will be (5, 7). So `U = 5` and `V = 7`,<br> `uParentU = 0` and `uParentV = 7`.<br>
`rank(0) = 2` and `rank(7) = 0`.<br>
As the rank of ultimate parent of node 5 is greater than the rank of ultimate parent of 7 hence node 7 will go under node 5.
As node 6 and node 7 are at the same level hence there will not be any change in rank of 5 or 0. But the parent for 7 will 
be updated to 5 now.

![Disjoint set image-8](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/Disjoint%20set/images/Disjoint%20set%20image-8.jpg)

Now at this point if we are asked that is node 6 and node 4 belong to same component or not, then we can simply check the 
ultimate parent of 6 and ultimate parent of 4 if both the ultimate parents are equal then they belong to same component 
otherwise they are from different component of graph.<br>
Here if we want to calculate ultimate parent of 6 we will check the parent array for 6. The parent for 6 is 5 (note that
this is not the ultimate parent), hence we will check again the parent of 5 which is 0, again we will check parent of 0 which
is 0 itself which means there is no parent above 0 hence 0 will be the ultimate parent for 6. Similarly, for 4 the ultimate 
parent will be 1. Here both the ultimate parents are different hence node 6 and 4 are from different component. This is called
finding the parent.<br>
But wait, here to check the ultimate parent we have to keep on checking parent of parent which is for sure not the constant 
time complexity (it is log(N), traversal of tree). We need constant time complexity hence here after this graph we do 
**path compression**. We know here at the end we will be working with ultimate parent and not the immediate parent. Hence 
if during first iteration of find path process we got to know that ultimate parent of 6 is 0 then we can simply modify 
the parent of 6 to 0, Similarly we can do this for 7 as well. And in case of 4 we can modify the parent as 1.  
> It is very very important to note that while doing path compression we are not changing the rank, (even though height 
> of the tree is getting changed), This is what is difference of height and rank. Rank simply denote which component is 
> bigger and which one is smaller. 

![Disjoint set image-9](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Graphs/Disjoint%20set/images/Disjoint%20set%20image-9.jpg)

Now after path compression the steps to find the ultimate parent will be just 1 (even though first time when path compression 
happen it will take some time) Hence here the time complexity is as good as O(1) i.e. constant (exact time complexity is O(4 `\alpha`), 
this has a huge mathematical derivation which is not important or asked).

Now consider after last edge we have one more edge (0, 1) in this case as per above steps the rank of ultimate parents of 
0 and 1 are same hence we can attach any of the two node under other one. After this operation the answer to the same question 
is node 6 and 4 belong to the same component or not will now change (This is what is called dynamic graph that means graph 
which is changing at each step), and hence the answer to the question can also change.
