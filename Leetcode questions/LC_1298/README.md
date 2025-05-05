### 1298 - Maximum Candies You Can Get from Boxes

**Question link** - [Link](https://leetcode.com/problems/maximum-candies-you-can-get-from-boxes/description/)

**Topics** - Queue

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -
<br>

**Note on complexity analysis:**

The maxCandies function has a while loop, and inside that while loop, it performs several operations, including the for loops for keysFound and boxesFound. These inner loops are not nested in a way that their execution count directly multiplies with the number of times the while loop runs for the same iteration.

**Big O for Sequential Operations**

When operations are performed sequentially (one after the other) within a loop or within a function, their time complexities are generally added. The dominant term among these sequential complexities determines the overall complexity of that section.

**Analyzing the while Loop**

The while loop continues as long as the queue is not empty. In the worst case, each box might be added to and removed from the queue once. So, the while loop itself can run up to O(N) times, where N is the number of boxes.

Analyzing the Operations Inside the while Loop (Per Iteration)

For each iteration of the while loop, we perform the following:

* `queue.poll()`: O(1)<br>
* `total += candies[polled]`: O(1)<br>
* Iterating through `keysFound`: In the worst case, a box can contain some number of keys. Let's say the total number of keys across all boxes is K. However, within a single iteration of the while loop, we process the keys of one polled box. The number of keys in that box is bounded by the input size, but we don't multiply this by the number of while loop iterations. We account for the processing of all keys across all boxes over the entire execution of the algorithm. The total time spent in these inner loops across all while loop iterations will be proportional to K.<br>
* Iterating through `boxesFound`: Similarly, a box can contain some number of other boxes. Let's say the total number of contained boxes across all boxes is B. Within one while loop iteration, we process the contained boxes of one polled box. The total time spent in these inner loops across all while loop iterations will be proportional to B.<br>
* Set operations `(add, contains)`: On average, these take O(1) time.

**Overall Time Complexity**

The while loop runs at most O(N) times. Inside each iteration, the work done is proportional to the number of keys and contained boxes in the current box being processed. Over the entire execution, each key and each contained box will be processed at most once (when the box containing them is polled). <br>
Therefore, the total time complexity is the sum of the time taken for each part:

* Initialization: O(N + K) for creating sets and the initial queue.
* while loop: The loop runs at most O(N) times, and the operations inside (including iterating through keys and contained boxes in total over all iterations) contribute O(K + B).<br>

Combining these, the overall time complexity is O(N + K + B). We add K and B because the processing of all keys and contained boxes happens within the overall process driven by the while loop, not for each of the while loop's iterations in a nested multiplicative way.

**Analogy**

Imagine you have a list of tasks (boxes in the queue). For each task, you might have a sub-list of items to process (keys and contained boxes). You go through each task in the list. For each task, you process all its sub-items. The total time is the time to go through all tasks plus the time to process all sub-items across all tasks, not the number of tasks multiplied by the number of sub-items per task.

In Big O notation, we are concerned with how the runtime scales with the input size. The total number of keys (K) and the total number of contained boxes (B) are factors that contribute to the overall work done by the algorithm, but their contribution is additive to the work done for processing each box in the queue.