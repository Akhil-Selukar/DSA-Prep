### Custom circular queue

In the [Custom queue implementation](https://github.com/Akhil-Selukar/DSA-Prep/tree/master/Custom%20queue/Custom%20queue%20implementation)
when we remove an element we have to shift all other elements to left by 1 place. Hence, the time complexity for just removal 
of an element becomes O(N), which is not a good complexity. So to fix this we can use Circular Queue.
In circular queue all the elements are arranged in circular manner and the complexity of removing as well as adding an element
is O(1)

Initially let's assume the size of the queue is 5 and you have added all the 5 elements then the queue will be something like 
below.
[Circular queue representation-1](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Custom%20queue/images/Circular%20queue%201.jpg)

Now let's consider you want to remove an element from the above queue, as we know that the element from queue will be removed 
from front (i.e. FIFO) so here instead of removing the actual element and then shifting the elements to left what we do is 
we just move the start pointer ahead and the earlier index where start pointer was will be now available to rewrite (i.e. add 
new element). So here actual deletion is not being performed, we are just playing with the pointers.
[Circular queue representation-2](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Custom%20queue/images/Circular%20queue%202.jpg)

So here now the elements which will be removed next is 3 (i.e. start pointer) and if we check all the elements then it will
be from start till end-1, and end will be available to accommodate another value.