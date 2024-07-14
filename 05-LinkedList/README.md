## 05 LinkedList

At first glance linkedlist looks very similar to that of arraylist because both of them can grow and shrink during runtime
and the syntax for both is similar. But there is a huge difference between them in terms of internal implementation and 
hence the time and space complexities for both varies. 

Unlike arraylist or array, elements in a linkedlist are not stored in continuous memory location, neither the memory is 
reserved nor assigned upfront. To visualize linkedlist in real like consider an example of treasure hunt game. The game 
starts with a note or clue of next location, Then on next location you find another note/clue for next location and so on
till the actual treasure. So here the first note/clue is only aware of the location next i.e. second note/clue, and it does
not aware of anny of the other note/clue. Also, these notes/clues can be stored at any random locations and need not be 
present next to each other. Similar to this in linkedlist first element has a link with (has the address of next element),
similarly second element has the address of third and so on. So all elements can be present at any locations as they know
the location of element next to them. Now as no continuous memory locations are required so no memory is reserved upfront.
and as and when a new element is added the value is stored at any memory location and a link is created between that location 
and the previous element.

Linkedlist have 4 types
1. Singly Linkedlist
2. Singly circular linkedlist
3. Doubly linkedlist
4. Doubly circular linkedlist

> Note: The first element of the linkedlist is considered as head of the linkedlist which indicates the starting memory 
> location and the last element is considered as the tail which indicates the end of linkedlist.  

Below we will see each type of linkedlist in details and difference between them. We will also see how linkedlist is stored 
in memory. Each element in linkedlist requires an additional memory location to store the link between itself and the next element.

#### 1. Singly linkedlist
In case of singly linkedlist each element will have the reference to or link of next element, but it will not have any reference 
of previous element. So in case of singly linked list we can traverse forward by using the link or reference to next element 
but traversing backward is not possible. Have a look at below image.

![Singly linkedlist(05-LinkedList/images/Singly LinkedList-01.png)](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/05-LinkedList/images/Singly%20LinkedList-01.png)

From above image we can see that the first element in linkedlist i.e. 'Java' is stored at memory location 'm35', hence 'm35'
became the head of the linkedlist. Then that first element holds the link to or reference to the next element 'C' i.e. 'm21'.
Similarly, 'C' holds the reference to 'C++' i.e. 'm55'. And at last 'Python' is the last element of the linnkedlist hence
the reference which is hold by 'Python' is null, so we will not be able to traverse further 'Python'. Also memory location of 
'Python' i.e. 'm74' became the tail.

From above image we can clearly see that only forward traversal is possible because we have reference to only next node, and 
as soon as we reach the end of linkedlist i.e. 'Python' we can't traverse further as no further reference is available. 
So if we want to access third element of linkedlist, we can't directly access it as we don't know the memory location of 3rd 
element. We have to access first element first then from there we have to go to second element using the link available.
Then from second element only we can go to third element and access it. So random access is not possible in very expensive 
in case of linkedlist as elements are stored in random memory locations.

#### 2. Singly circular linkedlist
In case of singly linkedlist above we saw that last element does not have any link or reference to other element. And hence 
as soon as we reach to the last element we can not move further. But in case of singly circular linkedlist, last element 
again point to or has reference to the first elemen, so as soon as we reach to the last element it points us to the first 
element again, and we can circle over the linkedlist again and again. 
Have a look at below image to understand it better.

![Singly circular linkedlist(05-LinkedList/images/Singly Circular LinkedList-01.png)](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/05-LinkedList/images/Singly%20Circular%20LinkedList-01.png)

Here if you observe the last element 'Python' it has link to first element 'Java', so we can traverse to first element from
last element and can loop over the linkedlist infinite number of times. The blue links form a circular links hence this is 
called as circular linked list, and only forward traversal is possible hence it is called as singly circular linkedlist.

#### 3. Doubly linkedlist
In case of doubly linked list each element has the link to its next and previous element both. Hence in case of doubly linkedlist
it is possible to traverse in both forward and backward direction. Have a look at below image.

![Doubly linkedlist(05-LinkedList/images/Doubly LinkedList-01.png)](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/05-LinkedList/images/Doubly%20LinkedList-01.png)

From above image we can see that each element has link to next and previous element (except first and last one). So as 
each element is aware of it's previous and next element, we can traverse both forward and backward in case of doubly linked 
list. In above image blue line denotes the link with next element while red line denotes the link to previous element.

#### 4. Doubly circular linkedlist

In case of Doubly linkedlist as we don't have any next element reference for last element and any previous element reference 
for first element, we can not traverse forward from last element and backward from first element. To overcome this we have 
doubly circular linkedlist. Here the last element has the reference to first element as next element and first element has 
reference to last element as previous element. So we can traverse continuously in circular fashion in both the directions.
have a look at below image.

![Doubly circular linkedlist(05-LinkedList/images/Doubly Circular LinkedList-01.png)](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/05-LinkedList/images/Doubly%20Circular%20LinkedList-01.png)