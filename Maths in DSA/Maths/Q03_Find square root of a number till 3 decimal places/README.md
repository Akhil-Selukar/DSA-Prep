### Find square root of a number

You are given with a number N and your task is to find the square root of the number. (You can assume that the given number will
be a perfect square.)

**Intuition** -<br>
It is very obvious that the square root of a number N will be less that the number itself and greater than 0. 
So our task becomes to start from 1 till N and check if the number multiplied by itself is equal to given number or not.
<br>Now the next thing we know is whenever we have sorted numbers then we can simply apply binary search. Hence our problem will
reduce to in the sorted numbers from 1 to N find a number P where P*P = N.