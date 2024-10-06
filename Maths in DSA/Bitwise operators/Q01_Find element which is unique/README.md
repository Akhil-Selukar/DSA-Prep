### Find unique element in given array.

You are given an array in which all elements are present two times except 1 element. You have to write a function findUnique(int[] arr)
which will find the element which is not repeated and return it.

Ex:
Input: nums = [2,4,6,3,1,3,4,2,1];<br>
Output: 6 <br>(As all other elements are present twice in given array except 6)

**Intuition** -<br>
Here one way which all will think of is to run two loops and check each element if it is repeated or not. But here we will 
have to run two loops which is not good as it will increase the time complexity. So better approach will eb to use XOR operator.
As we know that XOR of 1^1 is 0 and 0^0 is also 0. So if we do XOR operation of a number with itself it will give 0. So if
we perform XOR operation on each element of array it will make all duplicate elements as 0 and the only remaining element will
the unique element. (Here we don't need to convert each number to binary as internally bitwise operators work on binary 
representation only.)