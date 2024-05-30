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


