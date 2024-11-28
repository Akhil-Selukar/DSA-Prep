### HashMap

**Why hashMap?**

Consider you are given 1000 elements, and asked to store all of them. Now after that you are asked to check if any element
is present in those 1000 elements or not. You will say simple just store the elements in an array and then loop over the 
array to check if given element is present or not. But the problem here is this will take O(N) time complexity. Okay so 
another solution is to use binary search tree, this is better than array but still it is taking O(log N) time complexity. 
What if we want to check/fetch the element in O(1) i.e. constant time complexity. Is it possible? Well the answer is yes, 
using HashMap.<br>
HashMap stores elements in a key-value pair. Whenever we want to check for any element or fetch eny element we can simply 
pass the key and get the value associated with the key.<br>
Consider you are storing sales record of all sales representatives in a company. 'Sheldon', 'Leonard', 'Howard', 'Raj', 
etc... are the sales representatives and their respective records are 30, 26, 28, 25, etc...<br>
Now here we can consider employee names as key and sales record as value and store them in a HashMap.

![HashMap image-1](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/HashMap/images/HashMap%20image-1.jpg)

Now if we want to check the sales record for Howard we can directly go the Howard's entry `map.get("Howard")` and get the value. (as of now 
there might be questions like how we can get till Howard's entry in constant time complexity, don't we have to traverse 
through all the entries and all? We will see how it works internally and how the entries are accessed in constant time 
complexity further.)

**How elements are stored in HashMap?**

From above explanation we are clear that all values are stored in the hashmap against a key. But how exactly this works?
Well every key in the hashmap is converted to a hash value. This hash value is nothing but a number calculated by using 
some mathematical calculations (you can check hashCode() method). So basically hashcode is nothing but numerical representation 
of given key. Now this numerical representation can be very long so, we need to reduce the value. This is done by using 
hashing. And then the value we get against that value we store the element. (have a look at below image for better understanding)

![HashMap image-2](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/HashMap/images/HashMap%20image-2.jpg)

In above image hashcode is calculated based on some mathematical calculations, the hashing we are using is also a mathematical
operation, and it does not depend on the number of elements you have. So all these operations are having constant time complexity
O(1).

Now there is one problem in above approach. The hashcode is unique for unique keys but after applying hashing mechanism 
we can get same index value for more than one hashcode. For example lets consider hash code for 'Leonard' is `5486312616` 
So after hashing we will get index 6. But index 6 is already occupied by 'Sheldon'. This situation is called as 'Collision'.
There are two ways to deal with collisions 
1. Chaining
2. Open addressing

Chaining means at each index of the array we have an arrayList and if two keys have same hash value after applying hashing 
then we simply add the elements in LinkedList at that index. Now here as well we have a problem.

![HashMap image-3](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/HashMap/images/HashMap%20image-3.jpg)

Here as well we have a problem, what if after hashing all the elements result into same index. Then all elements will be in
a LinkedList which is stored at a single index in an array. So whole hashMap concept is gone here. To prevent this we assume 
a load factor `&#945;` which is the probability of number of keys at each index. 
This is calculated as 

&#945; = n/m<br>
where, n = number of elements we are storing in the hashMap.<br>
m = size of the array we have.<br>

So if we want to store 20 elements, and we have array of size 10 then the load factor will be 2. Which means the probability 
of number of keys present at each index is 2 keys per index. So in this case if we want to find the element for any key, 
at max it will be at the 2nd place in the linkedList at a index so the time complexity will be O(1 + &#945;). Now in ideal 
case if all indices have &#945; number of values so &#945; will also become constant in this case so overall time complexity 
will be O(1) i.e. constant only.

