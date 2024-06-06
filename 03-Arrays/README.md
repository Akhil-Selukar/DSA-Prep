## 03 Arrays

### What is an array?
Array is a very common data structure in almost all programming language. To understand what array is, let's look at an 
real life example first. Consider below container of cookies.
![array-of-cookies(03-Arrays/images/array-of-cookies.jpg)](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/03-Arrays/images/array-of-cookies.jpg)

Here we can see that the container is specifically made for the circular cookies. The size of the container is fixed, so we
can only store specific number of cookies only, and all the cookies are placed exactly one after other (there is no space
in between two cookies to store some other things). If we list down all these properties for cookie container.

1. Have specific predetermined size.
2. Made specifically to store circular cookies.
3. All cookies are placed continuously, there is no other thing between them.
4. As they are stored in continuous memory locations we can identify each cookie by its index number. (i.e. place from 
start of the container)

This is what the properties of an array are.
1. Array has fixed size.
2. Array can contain element of same type (i.e. integer array can not store string value)
3. All array elements will be placed in continuous memory locations.
4. Arrays are index based, so we can identify each element based on its index value.

Have a look at below array of integers.

![array-of-int(03-Arrays/images/array-of-int.png)](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/03-Arrays/images/array-of-int.png)

Here we can see that we have an array of size 8, so we can store only 8 values in the array, and it is an integer array. 
So all the values in this array has to be integers. All the values are stored in continuous memory locations starting from 
1001, 1002, and so on. The index of array always start from 0. (It is important to note that index and memory locations are different.)

### Why to use array?
In many cases we need to store large number of values in our program, like if we want to store roll number of 100 students 
then if we create 100 different variables then the code will become difficult to read and maintain, because we will have 
to manage 100 variables carefully. But as we know that all roll numbers will be of same type let say integer, so we can 
create an array of size 100, called rollNumbers and then store all roll numbers in it. In this case we will have only 1 variable,
and we can access individual roll number based on index. So we are saving ourselves from managing 100 variables and making 
the code clean. 

> Important note - Array can have duplicate values.

### Types of array.

Arrays are of two types, single dimensional array and multidimensional array. In multidimensional array we have 2D array,
jagged array, etc.

Now a single dimensional array or (1D array) is the simplest form of array with only one row and multiple columns.
The element stored in a one dimensional array have only one index value (i.e. colum value) , while two-dimensional array 
is just like a matrix which has multiple row and multiple columns hence multidimensional array has two indices. Below are 
example of one dimensional and two-dimensional array.

![One dimensional array(03-Arrays/images/one-dimensional-array.png)](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/03-Arrays/images/one-dimensional-array.png)

Here we have only one row and total of 8 columns.<br>
The index of  4 is 2, index of 7 is 4, index of 10 is 6. So all element have only single index.

> Remember that counting of index start from 0 and not from 1, hence 5th column means 4th index. (same is applicable for 
> row index and depth index in case of multidimensional array.)

On the other hand have a look at below 2D-array.

![Two dimensional array(03-Arrays/images/two-dimensional-array.png)](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/03-Arrays/images/two-dimensional-array.png)

Here we have three rows and four columns.<br>
The index of any element in 2D array is always represented as row number first and then column number. Hence the index of 
4 is (0,2), the index of 7 is (1,0) and the index of 15 is (2,3)<br>
So when we want to access 4 we will look into first row and third column. Similarly, if we want to access 15 we will look 
into third row and fourth column. 

Now Three-dimensional array has depth along with row and column. Consider 3D array as a cube. 

![Three dimensional array(03-Arrays/images/three-dimensional-array.png)](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/03-Arrays/images/three-dimensional-array.png)

Here we can see the cube has depth (indicated by i and green color), rows (indicated by j and red color) and columns 
(indicated by k and cyan color). The index of any element in a three-dimensional array is represented as (i,j,k) i.e.
depth value then row value and then column value. So if we want to write index of 17 in above figure, then it will be 
(0,1,1) because 17 is at 0th level depth, 1st row and 1st column. Whereas if we want to write the index of 19, then it 
will be (1,0,2) because it is at 1st depth, 0th row and 2nd column.  

Now we have seen different types of array, but it is very important to understand how these arrays are stored in the 
memory, because at the start of this section we mentioned that `All array elements are placed in continuous memory locations.`
So in case of 1D array it is simple and clear that all the elements will be stored in continuous memory locations like below.

Consider we want to store a 1D array with 5 values [2,9,4,6,3].
(Consider each sell in below diagram represent a memory location) 

![1D-array-in-memory(03-Arrays/images/1D-array-in-memory.png)](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/03-Arrays/images/1D-array-in-memory.png)

As shown in above diagram (highlighted in green), the elements will be stored in continuous memory locations. And never 
like as shown in cells highlighted in red.

Now how about 2D-arrays. Well, 2D-array is stored in memory as a single 1D array only. It will store the entire first row,
then it will store entire second row just next to the first row and then third row and so on. Have a look at below diagram 
where the 2D array is stored in memory.

The array to store: <br>
[[ 4, 6, 9],<br>
 [ 8, 3, 5],<br>
 [ 7, 2, 1]]

The above array will be stored in memory as shown below.

![2D-array-in-memory(03-Arrays/images/2D-array-in-memory.png)](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/03-Arrays/images/2D-array-in-memory.png)

Here we can see that the memory location m35 to m37 represents the first row of given 2D array. Then immediately after that
from memory location m38 to m40 represent the second row and from memory location m41 to m43 we have 3rd row of the 2D array.
So in memory the 2D array is stored just like a normal 1D array with each row in 2D array placed immediately after the 
previous row.

2D array will never be stored like below in memory.

![2d-array-in-memory-incorrect(03-Arrays/images/2D-array-in-memory-incorrect.png)](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/03-Arrays/images/2D-array-in-memory-incorrect.png)

In case of 3D array, it will also be represented as multiple 2D arrays one after the other.
