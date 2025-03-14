### Segment tree

Segment Tree is a versatile data structure used in computer science and data structures that allows efficient querying and 
updating of intervals or segments of an array. It is particularly useful for problems involving range queries, such as finding
the sum, minimum, maximum, or any other operation over a specific range of elements in an array. This structure enables fast 
query and update operations with a time complexity of O(log n), making it a powerful tool in algorithm design and optimization.

#### How segment tree works and store the range based data?<br>
To understand how segment tree works and store range based data let's take an example. Consider the given array is `[1,5,6,3,4,9,7,2]`
and you are asked to calculate sum of numbers between index 2 to 6 (i.e. numbers 6, 3, 4, 9 and 7).<br>
Now to create segment tree for this example we have to follow below steps.<br>
**Step 1** - First consider the full range and it's sum. Add it in first node i.e. root node.<br>
**Step 2** - Divide the range in two parts and store divided ranges and their sum in left and right nodes.<br>
**Step 3** - Repeat the process till range becomes singular element (leaf nodes).

The final segment tree after following above steps will look like below.

![Segment tree image 1](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Trees/Images/Segment%20tree%20image%201.jpg)

From above tree we can clearly see that all leaf nodes are individual elements in given array and segment tree is always 
a perfect binary tree (i.e. each node except leaf node will have 2 child).

Now, once the tree is created we can start with the actual question of finding sum of elements between index range 2 to 6.
We can break down the range 2 to 6 into smaller pieces (i.e. [2,3], [4,5] and [6]) and all these small ranges are available 
in segment tree. So what needed is to traverse through the segment tree and get the values from respective node.

So the algorithm to calculate the answer will be<br>
**Step 1** - Start from the root node and traverse the tree.  
**Step 2** - There can be three cases at each node. Based on the case return the value (either actual or default. Here default value
will depend on mathematical operation you are doing for example in case of addition/subtraction the default value will be 0
while in case of multiplication default value will be 1, in case of finding minimum in given range default can be Integer.MAX_VALUE, etc)

**Case 1** - **Node interval** in segment tree is inside the query interval (i.e. in our example [4,5] interval in segment tree
is inside the actual query interval i.e. 2 to 6). In this case return the actual value in the node. So we will return 13.

**Case 2** - Node interval is completely outside query interval (in our example node interval [0,1] from segment tree is 
completely outside the query interval [2, 6]). In this case return the default value (i.e. 0 in our case).

**Case 3** - **Query interval** is inside the node interval (in our example query interval [2, 6] is completely inside 
node interval [0, 7] i.e. root node). In this case go for left and right node and check all the cases again.

At the end finally whatever is returned we can add/multiply/subtract, etc. and get the final answer. The recursion call
in our example will look like below.

![Segment tree image 2](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Trees/Images/Segment%20tree%20image%202.jpg)


#### Updating the value in given array at specific index.

Consider we are asked to update the value at index 3 from 3 to 7. This change will for sure have impact on the segment tree
and on final answer as well. So we have to update the tree when any element in array is updated. This update operation 
should also happen in O(log(N)) time complexity.
<br>Here instead of simply iterating over the array to calculate the answer we are using segment tree 
because normal iteration over array will have time complexity of O(N) while segment tree will do the same operation in O(log(N))
(Note that creating tree will require additional space though).

Now to update the value at index 3 we can start from the root node and keep on checking if the given index lie in node range 
or not, if it lies in the node range then check same thing for left and right for that node till we find the leaf node of that
index. Then update the value in leaf node and while going back in the recursive call keep on recalculating the value of 
each range node in the path. (Have a look at below diagram for better understanding.)

![Segment tree image 3](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Trees/Images/Segment%20tree%20image%203.jpg)

> Both update and calculation of answer will have time complexity of O(log(N)).
