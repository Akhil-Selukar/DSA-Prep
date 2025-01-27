### 179 - Largest number

**Question link** - [Link](https://leetcode.com/problems/largest-number)

**Topics** - Arrays, String

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>

Here if we consider test case `[3,30,34,5,9]` to generate the maximum number we need to sort this array in `[9,5,34,3,30]`.
If we take first two elements i.e. 3 and 30 and concatenate them (as we need to create number by concatenating only.) So we
will get `330` (a+b) and `303`(b+a). So here 330 is greater hence we will go with a first and then b hence in sorted array we
will put 3 first then 30 (i.e nothing to be done). Then if we compare next two element we will i.e. 30 and 34, then (a+b)
will be 3034 and (b+a) will be 3430. Here 3430 is greater hence we will take 34 before 30. Now again if we check 3 and 34
then it will be 343 is greater than 330 hence 34 will be before 3 so the array at this stage will look like `[34,3,30,5,9]`
and in same way of we keep on sorting then we will get the required array. 
This sorting can be easily done by using String comparator.
