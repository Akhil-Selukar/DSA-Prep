### 947 - Most stones removed with same row or column

**Question link** - [Link](https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/description/)

**Topics** - Graph, Disjoint set

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>

Here we are given with a grid where 1 represent a stone, we can remove a stone if there is another stone available in the 
same row or column of that stone. And we want to find the maximum number of stones we can remove from given grid.<br>
Consider the below grid.

![LC-947 image-1](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_947/src/main/resources/images/LC-947%20image-1.jpg)

Here we can remove stone at (0,0) as it has common row with stone (0,1), then we can remove stone (0,1) as it has common 
column with stone(3,1). Then we can remove stone(1,0) as well as it shares common row with stone(1,2), then we can remove 
stone (2,3) as it share same column with stone (4,3) after this no stone can be removed.

![LC-947 image-2](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_947/src/main/resources/images/LC-947%20image-2.jpg)

Here we can remove 4 stones, but this is not the correct answer. We have another way as well.

![LC-947 image-3](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_947/src/main/resources/images/LC-947%20image-3.jpg)

Here we can remove 5 stone and this is the maximum which we can remove.

Now if we observe closely, we can say if two stones are sharing same row or same column then they are connected to each other.
If by this relation we create graph then in above example we will get 2 connected components.

![LC-947 image-4](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_947/src/main/resources/images/LC-947%20image-4.jpg)

Now if we start removing stones then at the end from each connected component we will have last 1 stone remaining as it will 
not  have anyone to share its row or column with. 

![LC-947 image-5](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_947/src/main/resources/images/LC-947%20image-5.jpg)

Hence, we can say from each component we will have one and only one stone left, so at the end of all removals number of 
stones remaining in grid will be equal to number of connected components. Now of we know the number of stones remaining 
then number of stones removed will be nothing but `Total stones - number of stones remaining`.

So now the problem boils down to creating disjoint set and finding number of connected components, Also find out number of 
stones and then subtract and get the answer. 

> Important note - Here in the question given is not the grid but are coordinates of stones. But above explanation is in
> terms of grid for understanding the intuition.