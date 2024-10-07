### Find if the given number of a power of 2 or not.

You are given a number, your task is to find if the given number is a power of 2 or not.

**Intuition** -<br>
We know that for the number to be a power of 2, it's binary representation must have only one `1` in the entire binary representation.
For example 4 which is a power of 2 hence the binary representation of 4 `100` has only one `1` at 3rd place, while 10 is not a power
of 2 hence the binary representation of 10 i.e. `1010` has total two `1` in it.

Now here 1 approach can be to run a while loop by performing right shift on the number and extract LSB in every iteration and 
maintain a counter showing the number of `1` obtained. At the end if counter is 1 then its a power of two.<br>
Here the complexity will be O(logN) (as discussed in Q03).

The another thing we can do is. We know if the number is a power of 2 then it will have only one `1` in
it's binary representation. Now if we subtract 1 from that binary representation it will turn all bits to the RHS of `1` to 
`1` (which was earlier 0 in original number) and at the same time it will turn actual `1` in given number to `0`. Now in this 
case if we do & operation on both the numbers we must get 0 and if the answer is not 0 then that means the number is not a 
power of 2.

Ex:<br>
Consider given number is 4.<br>
Binary representation of 4 is `100`.
Now if we subtract 1 from this we will get 3 which is `11` (which can be represented as `011`).<br>

Now if we use & operation between this two numbers. 
`100` & `011` we will get `000` which is 0. Hence we can say 4 is power of 2.

Similarly, if we consider 10. Now binary for 10 is `1010` while binary for 9 is `1001`<br>
If we use & operation now `1010` & `1001` we will get `1000` which is not 0 hence this is not the power of 2.

Here we are not atall looping over anything and getting the answer in one single step so time complexity will be O(1).