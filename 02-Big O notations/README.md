## 02 Big O notations

### What is Big O?
In last section we saw that algorithm is nothing but steps that need to be followed to solve given problem. And we also 
learnt that there might be more than one way/algorithm to solve a problem, and to determine which algorithm is better we
evaluate the algorithm on two aspects correctness and efficiency (with respect to the problem we are trying to solve).

Let's take an example, you have captured an excellent photograph, and you want to share it with your friend who live 100 
miles away. Now there can be many possible ways to share the photograph, like you can share it via whatsapp, you can email 
the photograph to your friend, you can take a printout and courier it, or you can travel to his/her place and share the 
photograph. 

So in this example the problem in hand is to deliver the multimedia (photograph) to your friend. And different algorithms 
are you can send it via whatsapp, email, courier, or you can travel yourself. So how we can decide which algorithm will be 
the best for us. At first glance to the problem anyone might say that sending the photograph via whatsapp will be the quickest
and less expensive way to solve the problem at hand (sharing one photograph via whatsapp will hardly take 2-3sec and 200-300Kb 
of data which will hardly cost you anything like 1-2 INR at max.). But course you will not prefer traveling all the way 100 
miles to deliver just 1 photograph because it will take minimum of 2 hr to travel and will cost you around 300-500 INR. 
So the best algorithm in this case will be the first one. 

But consider you have a complete album of 1000 photos and 500 videos, and you want to share all of them with your friend. Now if you think 
carefully, 1000 photos and 500 videos will be almost 2-3Gb of data and sending that much amount of data via whatsapp or email
might take 8-9 hr, even many a times you might get error while uploading large video files, or you can miss some photos 
or videos or probably can send same file twice. Also, the amount of data which will be required to send all the files will 
be more than 2-3Gb which will cost you around 500-600 INR. On the other hand if you choose to travel to your friends house 
it will take same 2hr or travel and 300-500 INR and there won't be any chance of missing of some files. So in this scenario
second algorithm will be better than the first one. Even for the second algorithm it will not matter you are carrying just 1 photograph
of 1000 or 10000 photographs. The amount of time required will remain same, while in case of first algorithm the amount of 
time required will change directly in proportion with the number of files you want to send.

So from above example we can clearly see that based on the data (i.e. input in computer science) the choice of algorithm 
or the efficiency of algorithm changes. So to measure the efficiency of an algorithm we can represent the time required 
for that algorithm to solve given problem in the form a mathematical equation. For example in above case, for sending 1
file via whatsapp it will take 5 sec, so we can represent the total time taken by this algorithm to send 'N' number of files 
as

>time required = 5 * N sec 
> <br>
> <br>where 'N' is number of files to send. 
> <br>Now based on internet connection the constant '5' i.e. seconds required to transfer one file can vary. So in general
> we can say that the time required to send files/data via this algorithm is in sync with number of files (amount of data)
> and in computer science terms it is represented by O(N) (i.e. Big O of N)

And in case of second algorithm the time taken to travel 100 miles not at all depend on how many files you want to transfer.
So in other words the time required to transfer 'N' files via this algorithm will always be constant no matter how large 
the value of 'N' became. This constant time is represented in computer science terms as O(1) (i.e. Bug O of 1)

Hence, in case of first algorithm as value of N increases the amount of time increases. So we can say that after one particular
value of 'N' time required for transferring files via whatsapp will become more than the time required to deliver the files 
by traveling to the other place. And that will be the point where you can say that 1st algorithm is no more efficient.

If you plot the time taken Vs number of files to send on a graph for both the algorithms you will get a graph like below.

![Time complexity graph for O(N) and O(1)](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/02-Big%20O%20notations/images/O(N)%20vs%20O(1).png)


**So Big O is nothing but the matrix which is used to describe the efficiency of an algorithm.
And O(N) or O(1), etc. are the way of showing how the runtime of a function/algorithm increases with 
respect to the number of inputs. It is also called as Time complexity** 

### Big O notations

Consider second algorithm in above example where we are driving 100 miles to share the photos and videos with friend. In 
this case the time required to solve the problem in hand (i.e. delivering photos and videos) does not depend on the amount 
of data. But there are can be some conditions which are out of our control and can affect the time, like traffic conditions 
or condition of road. These conditions are out of our control and can vary during each trip. So based on these conditions
there will be three scenarios.
1. We can find huge traffic and very bad road conditions, in this case the time required will be more.
2. We can find moderate traffic and average road condition, in this case the time required will be less than the above condition, but it is not the best time.
3. We can find no traffic at all with excellent road conditions. in this case the time will be minimum out of all cases. 

So there will be one best scenario, one worst scenario and one average scenario. All this three scenarios are represented 
by using different big O notations.
1. Big $$\Omega$$ (i.e. Big Omega) means the best case scenario.
2. Big $$\Theta$$ (i.e. Big theta) means the average case scenario.
3. Big O (i.e. Big O or Big Omicron) means the worst case scenario.

Now let's take an actual computer science example to understand this better.<br>
Consider you have an array with 6 numbers in it like below, and your task is to find index of given number from the array.
We are using a for loop to traverse through the array so that we can compare each number with given number to find out the 
index of matching number.

![Array example 1(02-Big O notations/images/Array_example-1.png)](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/02-Big%20O%20notations/images/Array_example-1.png)

In this example problem in hand is to find given number from an array of 6 elements, hence N is 6 here.
The algorithm which we are using is to loop over the array and match each value with given value.

Now in this scenario the worst thing that can happen is we have to loop over entire array to find the given number because
the number which we want to find is at the end of given array.
For example if we want to find the index of number '4' in that case our for loop will execute 6 times, i.e. N times.
Hence in worst case scenario the time complexity will be directly proportional to N. This is called Big O (i.e. worst case scenario).

Second thing that can happen is we can luckily find the given number in first iteration only, because the number which we 
want to find is present at the start of given array. For example in above example if we want to find number 5. In that case
we will have to loop over the array only once. So this is the best case scenario, here even if our algorithm is to loop over
all elements, but we found the element in 1 iteration of loop only. This best case scenario is represented by Big $$\Omega$$ 
(i.e. Big Omega). 

Now the third scenario is, number which we want to find is neither at first place nor at the end. In this case the number 
of iteration of loop will be more than the best case scenario but less than the worst case scenario. This is the average 
case, and it is represented by Big $$\Theta$$ (i.e. Big theta). In our array example let's say we want to find index of number 
8, in that case it the number of iterations which will be required are 4, which is more than best case but less than worst case.

(In general if not specifically asked for best of average case we always report worst case complexity (i.e. Big O). While
if you want to compare two algorithms you can use average case scenario as well.)

