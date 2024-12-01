### Square-root decomposition algorithm.

This algorithm is used to calculate range bound queries. For example if we are given an array of size 10 and asked to calculate
sum of numbers between index 2 to 7. (Here sum of numbers between index 2 to 7 is a range bound query. This can be anything
like average, min, max, multiplication, subtraction, etc..)

There are multiple ways to solve this type of problem. First and the simplest one is to run a loop from starting index till
end index and find the required answer. This will take O(N) time complexity. Another one is to use [Segment tree](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Trees/Segment%20tree/Segment%20tree/README.md)
This will take O(log(N)) time complexity. And the third one is to use square-root decomposition algorithm which will take O(sqrt(N)) 
time complexity.

In square-root decomposition we divide the array in chunks of `sqrt(N)` numbers. After that we solve the individual chunk 
for the operation (addition, subtraction, max, min, etc..) and then find the final answer based on given range. For range 
there can be three scenarios mentioned below.

Consider given array is `nums=[1, 3, 5, 2, 7, 6, 3, 1, 4, 8]`<br>
Here total number of elements are 10, so we will divide these numbers into chunks of 3 (i.e. int value of sqrt(10)).

![sqrt decomposition image-1](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Algorithms/14-Sqrt%20decomposition/Sqrt%20decomposition/src/main/resources/images/sqrt%20decomposition%20image-1.jpg)

Here we got 4 chunks. Now if we solve each chunk we will get below array.

![sqrt decomposition image-2](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Algorithms/14-Sqrt%20decomposition/Sqrt%20decomposition/src/main/resources/images/sqrt%20decomposition%20image-2.jpg)

Here we need addition of numbers between two index hence we took addition of individual chunk.<br>

Now next step is to check answer for actual given range (which is index 2 to index 7)<br>
Here there can be three cases.<br>

**Case 1** - given range coincide with one or more chunk. For example if the range in above example is index 3 to index 8.
In this case we can see that the given range consist of exactly two chunks (first one is index 3 to 5 and second one is 
index 6 to 8) and no other index is needed. So for this two individual chunks we already have answer calculated and we can 
simply get that answer and combine it to generate final answer.

![sqrt decomposition image-3](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Algorithms/14-Sqrt%20decomposition/Sqrt%20decomposition/src/main/resources/images/sqrt%20decomposition%20image-3.jpg)

**Case 2** - given range has partial part of a chunk at the start. For example consider range from index 2 till index 5.
Here from first chunk we need only index 2 and we have entire second chunk. In this case we can divide the range as from 
index 2 till 2 and entire chunk from index 3 to 5. For chunk 3 to 5 we already have the answer for range 2 to 2 we can 
run a for loop and calculate the answer.<br>
Here we know that the number of elements in a chunk are equal to sqrt(N) hence in worst case the for loop will run rill 
sqrt(N) times. Hence, this looping will not impact on time complexity.

**Case 3** -  given range has partial part of chunk at both the ends. For example in above example we can consider range 
from index 2 to index 7. This range we can split into index 2 to 2, index 3 to 5 and index 6 to 7.<br>
Here as well we can run a for loop for index 2 to 2, then take entire chunk from index 3 to 5 and then again run a for loop
from index 6 to 7. Here as well in worst case the for loop will rin sqrt(N) times hence the overall complexity will remain 
O(sqrt(N)).
