### 452 - Minimum Number of Arrows to Burst Balloons

**Question link** - [Link](https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/description/)

**Topics** - Arrays, Sorting

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
> Whenever the problem is of intervals always try sorting.

Here we can sort the intervals (balloons) based on their start position.
Next we need is to identify the overlapping balloons (as the overlapping balloons can be burst in a single arrow).
there can be a situation where 1 balloon can overlap two different balloons separately, in this case we should not consider 
the balloon in both overlaps. Hence to handle this, in first arrow (i.e. first overlap where we will be shooting the arrow)
we can consider that common balloon till overlapping part only. (have a look at below diagram)

![LC - 452 image-1](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_452/src/main/resources/images/LC%20-%20452%20image-1.jpg)

Here in above case we can see that yellow balloon has common part with blue and red balloon, which means in a single arrow 
we can burst yellow and blue or yellow and red balloon. 

consider we burst yellow and blue balloon in a single arrow then while checking for red balloon we dont need to consider 
yellow balloon. Hence if we find any overlap then greedily we will consider the overlap as a combined burst and yellow balloon
will be considered till 3 (i.e. the common part of balloons we are bursting and once the balloons are burst, the common yellow 
balloon will not be present when we check for the red onc).

[LC - 452 image-2](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_452/src/main/resources/images/LC%20-%20452%20image-2.jpg)
