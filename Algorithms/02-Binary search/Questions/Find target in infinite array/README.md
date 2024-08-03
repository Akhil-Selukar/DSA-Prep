### Find target in an infinite array.

You are given an infinite array of integers sorted in ascending order and an integer target. Your task is to find the 
index of target in given array. If the target element is not present in given array then return -1.

Example 1:<br>
arr = {1,2,3,4,6,8,9,10,16,18,19,23,26,.....}<br>
target = 8<br>

output = 5

Example 2:<br>
arr = {1,2,3,4,6,8,9,10,16,18,19,23,26,.....}<br>
target = 2<br>

output = 1

Example 3:<br>
arr = {1,2,3,4,6,8,9,10,16,18,19,23,26,.....}<br>
target = 5<br>

output = -1

Hint: To imitate an infinite array consider that you can not get the length of that array. 
<br>So you are not allowed to use `array.length` and that will be nothing but the infinite array.