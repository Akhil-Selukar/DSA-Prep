### 202 - Happy number

**Question link** - [Link](https://leetcode.com/problems/happy-number/description/)

**Topics** - LinkedList cycle detection

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1. You can ask interviewer for example of both happy and non-happy number.

**Intuition** -<br>
Here at first glance the question looks very easy we can simply use a while loop and break the number into individual digits 
add their squares and check if it is one or not if yes then return true and if not then repeat the same steps again. This will
work for happy numbers but what about the number which are not happy, in that case the addition will never become 1 and 
the loop will be an infinite loop (basically how and at which point we will decide that the number is not happy and we shall
stop looping now). There is no way in this approach.

But if we look closely and manually trace the non-happy number for example 2. It will be like below,

2 -> 2<sup>2</sup> => 4<br>
4 -> 4<sup>2</sup> => 16<br>
16 -> 1<sup>2</sup> + 6<sup>2</sup> => 37<br>
37-> 3<sup>2</sup> + 7<sup>2</sup> => 58<br>
58-> 5<sup>2</sup> + 8<sup>2</sup> => 89<br>
89-> 8<sup>2</sup> + 9<sup>2</sup> => 145<br>
145-> 1<sup>2</sup> + 4<sup>2</sup> + 5<sup>2</sup> => 42<br>
42-> 4<sup>2</sup> + 2<sup>2</sup> => 20<br>
20-> 2<sup>2</sup> + 0<sup>2</sup> => 4<br>
4-> 4<sup>2</sup> => 16<br>
16 -> 1<sup>2</sup> + 6<sup>2</sup> => 37<br>
.... and so on

here we can see that after 20 it again started from 16. So if we write these numbers in a form of list it will be like below.

![LinkedList_cycle_1.jpg](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_202/src/main/resources/images/LinkedList_cycle_1.jpg)

From above image it is very clear that it is simply a cycle present in a LinkedList. So the problem narrowed down to just 
identifying if the cycle is present or not, and this can be easily done by using slow-fast pointer method. 