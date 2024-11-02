### Queue datatype

Queue datatype is a datatype in java which follows First In First Out (FIFO) principle. This means that the element which
is inserted in the queue first will be removed from the queue first. We can not remove element from middle in the queue.

> In deque we can insert and remove from both the side.

To relate queue with real world we can imagine a line at billing counter of shopping mall, the person which stand in line
first will leave the line first while the person who joins the line last will leave the line last.

Queue is an interface, so to create an object we can use classes like LinkedList or ArrayDeque which either implement Queue 
directly or implement Dequeue interface which internally extends Queue.

![Queue in real world](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Custom%20queue/images/real%20world%20queue.jpg)