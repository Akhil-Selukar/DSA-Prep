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

