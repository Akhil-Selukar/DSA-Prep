### 136 - Single number

**Question link** - [Link](https://leetcode.com/problems/single-number/description/)

**Topics** - Arrays, Bitwise operations

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
Here simple way is by using hashMap we can count the frequency of each element and then return the element with frequency 1.
But this approach will use O(N) space complexity and we are asked to use only O(1) which is constant. Hence we can not use 
additional data structure to store frequency. We can not sort the array either because that will not be O(N) time complexity.
Hence the only thing remaining is we can do some operations on the entire array. We could have done the summation of all the
elements and then identified the missing one but that will work only if we have number from 1 to n in given array, here we 
can have number in any range and not necessarily continuous numbers. So the only thing remaining is to perform some bitwise 
operations. If we do XOR with 0 it results in same number, if we do `A XOR A` it gives zero and we also know that `(A XOR B) XOR C` 
is equal to `A XOR (B XOR C)` that means order does not matter in case of XOR (just like addition). Hence if we do XOR of 
all the elements of array then duplicate elements will cancel out i.e. will give 0 and non-duplicate element along with 0
will result in itself. Hence we will get the required answer.
