### 2616 - Minimize the Maximum Difference of Pairs

**Question link** - [Link](https://leetcode.com/problems/minimize-the-maximum-difference-of-pairs/description/)

**Topics** - Binary search

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** - <br>

Whenever in question we are asked to find Minimum of maximums or Maximum of minimums (i.e. minimize the maximum or maximize the minimum)
always think for applying binary search on possible solution value range.

Here in this question we want to find the minimum of difference of maximum of each pair group.
(Have a look at below image)

![LC-2616 image 1](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_2616/src/main/resources/images/LC-2616%20image-1.jpg)

We want to minimize the final answer (across all pair groups) where answer of individual pair group is maximum. To satisfy this
condition we will have to find such pair groups where individual pair difference start from minimum value and then goes on increasing.
This is the only way we can get final answer as minimum. To achieve this if we sort the array then the minimum difference 
of any number will be possible with only adjacent number (which will reduce the overhead of checking combination of an element with all
other elements in the array)

Final answer of the question can be at least 0 or at max the difference between largest and smallest element from array 
(i.e. nums[nums.length-1] - nums[0] after sorting the array). So we can apply binary search on this range and check if mid is answer of not
i.e. if we can create at least P pairs with difference less than or equal to mid value. And then find the lowest possible such mid.

> Same concept is used in coco eating banana problem.
