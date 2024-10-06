### Check if given number is odd or even.

You are given with a number, you have to return true is the number is even else return false.

Ex: Input: num = 35<br>
Output: false

**Intuition** -<br>
We know that all bitwise operators works on binary representation of given number also in computer memory everything is stored in 
binary format. Also in case of binary number system 2<sup>0</sup> (i.e. 1) is only even number, other all powers of 2 are even.
So if the bit associated with 2<sup>0</sup> is 1 then that means the given number has to be odd number.<br> Now to check
if the bit associated with 2<sup>0</sup> is odd or even, we know that if we apply AND operator (&) on any number with 1, we
get the same number where-as with 0 we get 0 always. So we can do AND operation between given number and 1. So we will get
the element associated with 2<sup>0</sup>. Now if the element is 1 that means the given number is for sure odd number, otherwise
it is an even number.