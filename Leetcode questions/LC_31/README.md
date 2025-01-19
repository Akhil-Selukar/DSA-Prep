### 31 - Next permutation

**Question link** - [Link](https://leetcode.com/problems/next-permutation/description/?envType=problem-list-v2&envId=array)

**Topics** - Arrays

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
The bruteforce approach here will be to generate all the permutations using recursion in lexicographical order and then 
find the given array in it. Once we find the given array, then next array to that will be our answer (in case given array 
is the last one then first will be the answer.)
But this approach will be very time consuming as it will have to generate all possible permutations and then loop over those
permutations and then find the required one. For array with 3 elements we will have 3! i.e. 6 permutations, for array with 5 
elements we will have 5! i.e. 120 permutations and so on so the time complexity for this approach will not be the best one.

Hence we can check for another approach here. First observation is in lexicographical order the first array will be the 
smallest one and last will be the largest one and each array will keep on increasing so if we write them and observe. There
will be a dip at certain index which will create this increasing trent we need to find that dip and then rearrange the number 
after that dip.

