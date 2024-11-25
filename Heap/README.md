### Heap

**Why we need heal and what is heap?**

Consider you are given N numbers and asked to find either smallest/largest out of those N numbers. Well it is simple we can
simply loop over the numbers and find the smallest/largest one. Okay, good but not the best we are iterating over all the 
numbers and in worst case the time complexity will be O(N).<br>
What if we need the smallest/largest number in O(1) time complexity. In that case the obvious answer is to store the numbers
in sorted format so that the first number (i.e. number at index 0) will always be the smallest/largest (based on sorting).
This is also good but what if we are given with some more numbers and asked to add those numbers in given N numbers and then
calculate the result. In that case we will have to insert the new numbers in existing array in sorted order and for that we 
will have to shift many elements. Same in case if we delete some numbers from given N numbers then also we will have to shift 
the entire sorted numbers. This will also have O(N) time complexity, so not that efficient. We want this operation as well 
efficient ensuring that we get smallest/largest element in O(1) time complexity.<br>
Here the heap comes into picture. Heap is a tree representation of collection of numbers where all numbers below a node is
greater/smaller than the number (greater if we want to find smallest, smaller if we want to find largest). Here one thing 
is important to note that we say tree **representation** and not an actual tree, this is because in heaps we don't have left 
and right nodes and elements does not actually store its left and right element's reference. Instead, all elements are stored
in a list by using some formulas such that if we consider first element in the list as root node and arrange subsequent 
elements as complete binary tree then it will satisfy the condition (all child will be smaller/greater than root).<br>
Have a look at below image for better understanding.

![Heap image-1](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Heap/images/Heap%20image-1.jpg)

Here if we observe the nums array is not actually sorted but if we create a **complete binary tree** using the elements 
it follows the rule that all elements below any node N are smaller than that node. So if we are asked to get the largest 
number from the given numbers we can always get the first number. Great this solves the first part i.e. getting the answer 
in O(1) time complexity but what about inserting and deleting elements? How can we maintain same rule while inserting or 
deleting any number form given numbers.<br> 
Well for that lets observe the above image (specifically any node and its left and right)

let's consider node 17, 14 and 16. The index value of these nodes in list are 2, 4 and 5 respectively (Consider the list
index starts from 1 instead of 0 for simplicity, we can adjust further to start it with 0 as well). Now if we observe the 
index value of parent node for 14 or 16 is `(index of 14 or 16)/2`. Same is true for all other nodes.
So we in general terms we can say that.<br>
`index of parent = i/2`<br>
where `i` is the index of child node.

Similarly, if parents index is `i` then<br>
`left child index = i * 2`<br>
and `right child index = (i * 2) + 1`

These are the three formulas which eliminates the need to have left and right pointer for each node. Because we are calculating
the required index instead of storing the reference.

![Heap image-2](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Heap/images/Heap%20image-2.jpg)

This is how the heap is represented.

**How to insert new element in heap?**

Consider in the same tree(heap) above we want to add another number 25. Now as 25 is the largest of all so it must come 
at the top in tree representation and at 1st index in the list. But adding element in the tree normally will be at the end 
and we are not sure that the number will be every time the greatest only so we have to place it at correct index where it will
hold the original rule true. So how to find that index and how to insert new element.?

To insert new elements steps are simple.<br>
**Step 1** - Insert the number normally at the end of the list (as it is represented as perfect binary tree so numbers will
be filled from left to right.) So add the number at the end normally.

![Heap image-3](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Heap/images/heap%20image-3.jpg)

**Step 3** - Check if the parent of the added node is less than the node or not. Now parent in list we can easily find using
the formulas mention above. If the parent is small then swap the parent with added number, else nothing to do.
(here we are checking parent is smaller because we are dealing with maxHeap i.e. maximum number at the first index.)

![Heap image-4](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Heap/images/Heap%20image-4.jpg)

Now again repeat the step 2 till we hit the else condition.

![Heap image-5](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Heap/images/Heap%20image-5.jpg)


![Heap image-6](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Heap/images/Heap%20image-6.jpg)

Now we can see that the largest element is automatically at the top (or at the first index). If we check the time complexity 
for this operation then at worst case we might have to traverse through the leaf node till root node which is nothing but 
height of the tree so time complexity will be O(log N) which is much better than O(N) in case of normal list.

**Deletion of a number**

Here consider we want to delete number 25, we can delete it easily because it is as the 1st index but then how to ensure that 
the second largest is at the top. For this we can just reverse the process we followed for inserting new number, i.e. instead 
of going from bottom to top now we will go from top to bottom. Below are the steps.

**Step 1** - remove the top most(1st index) element.

![Heap image-7](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Heap/images/Heap%20image-7.jpg)

**Step 2** - Now just put last element in list to the 1st position.

![Heap image-8](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Heap/images/Heap%20image-8.jpg)

**Step 3** - Now check the parents both the child and whichever child is greater swap the number with that child and repeat 
the process till its possible. And that's it.

![Heap image-9](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Heap/images/Heap%20image-9.jpg)


![Heap image-10](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Heap/images/Heap%20image-10.jpg)

Here as well the time complexity will be O(log N). Hence, this is much more efficient than normal List/arrays when we are 
dealing smallest, largest, etc type of conditions.