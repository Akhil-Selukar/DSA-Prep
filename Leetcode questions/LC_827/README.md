### 827 - Making a large island

**Question link** - [Link](https://leetcode.com/problems/making-a-large-island/description/)

**Topics** - Graph, Disjoint set

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -</br>
Here we are dealing with connected group of 1's in a grid hence we can say that grid can be considered as graph. Next thing 
given is we have to contentiously change a 0 to 1 and check if it forms the largest connected group/component or not, i.e. 
we are querying at every iteration and the graph is changing at every iteration hence this is a dynamic graph and the data
structure which is suitable for dynamic graph and querying over dynamic graph is Disjoint set. Hence we will use Disjoint set
here. But the issue is Disjoint set need node numbers (i.e. a single number to represent each node/cell) but here we have 
row and column representing each cell. Hence we need to convert row and column to cell number. 
For that have a look at below grid and conversion of row and column to cell number.

![LC-827 image-1](https://github.com/Akhil-Selukar/DSA-Prep/blob/b40efe4b8078a96e6373cddf5c92bf406122b1be/Leetcode%20questions/LC_827/src/main/resources/images/LC-827%20image-1.jpg)

Here we have `M x N` matrix so total elements in a row will be N (horizontal) and total number of elements in a column 
will be M (vertical). Now if we want to calculate the cell number of (2 ,2) then here row is 2 and column is also 2.
So if we have reached till 2nd row that means row 0 and row 1 are fully covered hence we can say number of elements covered 
under 2 rows = `2 * N` which is nothing but `row * N` in general terms. Then after that from row number 2 (i.e. 3rd row) 
we are standing at column index 2, so this row is only partially covered. Now as the indexing is 0 based hence when we say 
we are at index 2 that also mean from 0 we have covered 2 cells (cell with column index 0 and cell with column index 1) 
Hence total cells covered in partially travelled row are 2. So overall cells covered will be `row * N + column`. In above 
case `2 * 4 + 2` which is `10` (noting but the cell number).

Now next thing is we will first create the disjoint set and add all cells (node) which has value 1 in it. This will create
the components or group of all connected cells (which are nothing but the islands in this problem.) Here we need total number
of cells forming that island so that we can finally return the number of cells in the largest one. Here number of cells connected
to each other is nothing but the size hence we will use unionBySize in disjoint set.<br>

For below graph after populating the disjoint cet below will be the status of disjoint set.

![LC-827 image-2](https://github.com/Akhil-Selukar/DSA-Prep/blob/b40efe4b8078a96e6373cddf5c92bf406122b1be/Leetcode%20questions/LC_827/src/main/resources/images/LC-827%20image-2.jpg)

After this we will start placing 1 at each empty places (0 in actual problem). Here placing 1 means adding the element to 
disjoint set. After adding the element the disjoint set we can check the size of ultimate parents and if the size is greater 
that what size that we have we can say that new larger island is identified. and at the end we can return the size (after all)
testing for all empty places (0's).

**Edge case:**

Consider in above graph if we convert cell (2,3) to 1, then in that case we will have 3 adjacent 1's cell (2,2), cell (1,3)
 and cell(3,3). Hence our code might add 4 elements for graph having cell (1,3), then 5 elements of graph having cell (2,2)
and again it will add 5 elements because cell (3,3) also belong to the same graph in which cell (2,2) belong. And we are not 
applying any check to exclude already considered component. For this we need to identify each component no matter from which
cell in that component we are visiting. This can be identified by using ultimate parent (because a component will have only
one ultimate parent). Hence, can store ultimate parent of all connected components in a set (as set does not allow duplicates)
hence at the end we will have all unique components which are connected by adding 1 at any empty cell.

![LC-827 image-3](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_827/src/main/resources/images/LC-827%20image-3.jpg)
