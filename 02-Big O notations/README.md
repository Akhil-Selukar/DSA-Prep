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

### Big O notations (Asymptotic notations)

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
1. Big $\mathsf{\Omega}$ (i.e. Big Omega) means the best case scenario.
2. Big $\mathsf{\Theta}$ (i.e. Big theta) means the average case scenario.
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
all elements, but we found the element in 1 iteration of loop only. This best case scenario is represented by Big $\mathsf{\Omega}$ 
(i.e. Big Omega). 

Now the third scenario is, number which we want to find is neither at first place nor at the end. In this case the number 
of iteration of loop will be more than the best case scenario but less than the worst case scenario. This is the average 
case, and it is represented by Big $\mathsf{\Theta}$ (i.e. Big theta). In our array example let's say we want to find index of number 
8, in that case it the number of iterations which will be required are 4, which is more than best case but less than worst case.

(In general if not specifically asked for best of average case we always report worst case complexity (i.e. Big O). While
if you want to compare two algorithms you can use average case scenario as well.)

### Common time complexities 

Now we know about time complexity and how size of input affect the runtime of any algorithm. So let's understand some very 
common runtime complexities. 

1. O(1) - O(1) (i.e. Big O of 1) also call as constant time complexity. It represents that no matter what is the input size 
is, the time required for to run the code will be constant every time. 
For example, consider you are required to return the first element of given array. So in this case no matter how large the 
array is, every time you will be returning first element only i.e. element at index 0 (have a look at below code). So you will not have to loop over 
the array at any case. Hence irrespective of how many elements are there in the array the time required to fetch and return 
first element will always be constant. This is called as constant time complexity or O(1).

```java
public int getFirstElement(int[] arr){
    return arr[0];
}
```
Here we are considering input array will always have at least one value.

If we plot O(1) time complexity on graph of size of input vs time, the graph will be a parallel line to X-axis. (refer below graph) 

![O(1) complexity(02-Big O notations/images/O(1) complexity.png)](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/02-Big%20O%20notations/images/O(1)%20complexity.png)

2. O(N) - O(N) (i.e. Big O of N) also called as linear time complexity. It says that the time to execute the code (or number of 
operations) is directly proportional to the number of inputs/Size of input. Consider an example where you want to print all
element of a given array of size N. You will be looping over the array and printing all the elements inside the loop. In
this case if the array has 10 elements in it, then it will have to loop 10 times and time required to complete the operation
will be 10 time the time required for 1 iteration of the loop. If the number of elements increases to 100 the number of 
iterations will also increase to 100 and so as the time to complete the operation. So here we can clearly see that the 
number of operations or the time to execute the code is directly proportional to the size fo the array of number of elements 
in the array. Have a look at below code.

```java
public int printArrayElement(int[] arr){
    for(int i=0; i<arr.length; i++){
        System.out.println(arr[i]);
    }
}
```
Here we are considering input array will always have at least one value.

If we plot this complexity on a graph, it will be a straight line like below.

![O(N) Complexity graph(02-Big O notations/images/O(N) complexity.png)](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/02-Big%20O%20notations/images/O(N)%20complexity.png)


>Now here one thing we must understand is in case of any multiplying factor, we drop that multiplying factor while doing 
> asymptotic analysis. Have a look at below code.
> ```java
> public int printArrayElement(int[] arr){
>    for(int i=0; i<arr.length; i++){
>        System.out.println(arr[i]);
>   }
>    for(int j=0; j<arr.length; j++){
>        System.out.println(arr[j]);
>   }
> }
> ```
> Here in above example we are iterating over the loop two times and printing the array element two times. So the total
> number of iterations will be N for first loop and another N for second loop. Hence the overall time taken will be N+N i.e. 
> 2N. Hence in terms of asymptotic notations it will be O(2N).
> 
> But while doing asymptotic analysis we can safely drop the constant factor (i.e. 22 in this case). This is because 
> Big O notation is concerned with the asymptotic growth rate of an algorithm, meaning how the execution time scales as 
> the input size increases towards infinity. So in case of very large value of N the value for N and 2N will be any way very 
> larger than any small value of N. Also the overall value of number of operations/time is controlled by N (as N can vary from 
> 1 to infinitely large number) whereas constant factor 2 is a non-dominant term. Hence we can safely drop the constant 
> factor and say that the time complexity for above code is also O(N). 

3. O(N<sup>2</sup>) - also called as quadratic complexity. It says that the number of operations or time to execute the code
increases exponentially as number of input increases. For example have a look at below code.

```java
public int printNumbers(int n){
    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            System.out.println(i+" "+j);
        }
    }
}
```
Here in above code if we pass n as 10 then the code will print numbers from 00 to 99 (i.e. total of 100 numbers). If we 
pass n as 100 then it will print numbers from 00 to 9999 which means total of 10000 numbers. So the number of iterations 
are n<sup>2</sup> times. Hence we say that the complexity for this loop is O(N<sup>2</sup>). If we add another loop inside 
loop of j, then the complexity will become O(N<sup>3</sup>) and so on. 

If we plot this complexity on the graph. Then it will be like below.

![Quadratic complexity(02-Big O notations/images/O(N^2) complexity.png)](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/02-Big%20O%20notations/images/O(N%5E2)%20complexity.png)

> Have a look at below code and try to identify the number of operations which will be performed while running the code.
> ```java
> public int printNumbers(int n){
>    for(int i=0; i<n; i++){
>        for(int j=0; j<n; j++){
>            System.out.println(i+" "+j);
>        }
>    }
>    for(int k=0; k<n; k++){
>        System.out.println(k);
>    }
> }
> ```
> In above code example if we pass n as 10 then first it will print values from 00 to 99 and then the loop of k will print 
> the values from 0 to 9. So the total number of operations/iterations will be 100 + 10 i.e. 110. In terms of complexity if
> we write the time complexity for above code then it will be O(N<sup>2</sup>) for the first part and O(N) for the second,
> so the overall time complexity will be O(N<sup>2</sup> + N).
> 
> Now if you increase the value of N to 100 the total number of iterations will be 10100, where the contribution of second
> loop (loop of k) O(N) is just 100 which is much less than the contribution of i and J loop i.s. O(N<sup>2</sup>). So here 
> N is non-dominant term of O(N<sup>2</sup> + N). Hence we can safely drop N and say that the overall complexity for above 
> code is O(N<sup>2</sup>).  


4. O(logN) - Also called as logarithmic complexity, says that the number of operations or time to execute the code increases 
logarithmically as number of input increases. To understand this better consider below example.

Consider you have a sorted array of size 8, and you are given with a number. Your task here is to find if given number is 
present in the array or not.

So here the algorithm we can use is to loop over the array elements one by one and compare it with given element. But here
an important thing to notice is that the array is sorted, so we can use this additional detail for our advantage. We can use
divide and conquer algorithm here.(we will study this in details further)

As we know that the array is sorted, so we can divide the array in two parts from middle. Then we can check if the last
element of first half of the array is greater than or equal to the given number or not. If yes then we can completely 
ignore the second half of the array as the array was sorted and last element of first half id greater than or equal to given
number means if given number exists in the array then it must be in this half only. Again we can repeat this process till 
we find the element or the array is divided into individual numbers. 

Let's see this example diagrammatically with actual numbers and count the number of maximum iterations that can require 
to find element in an array of 8 elements.

Consider you are given with below sorted array, and you are asked to check if 4 is present in the given array or not.
![O(logN) example image - 1 (02-Big O notations/images/O(logN)-1.png)](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/02-Big%20O%20notations/images/O(logN)-1.png)

Now let's use above algorithm here (Divide and conquer).

Step 1 will be to divide the array in two parts and check in which part the given number can be present.
So as shown in below figure we divided array into two parts each containing 4 elements. And if you check now the last element of 
first part i.e. 6 is greater than 4 (i.e. number you are looking for) so you can straightaway ignore second half of the array.

![O(logN) example image - 2 (02-Big O notations/images/O(logN)-2.png)](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/02-Big%20O%20notations/images/O(logN)-2.png)

From above image you can see that in just 1 iteration we have eliminated 4 numbers and new search array is of only four elements.

Now let's see second iteration. In this iteration we again divide the search array into two parts and repeat the same process. 

![O(logN) example image - 3 (02-Big O notations/images/O(logN)-3.png)](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/02-Big%20O%20notations/images/O(logN)-3.png)

From above screenshot you can see that in second iteration we eliminated two elements and now the remaining elements are only 
two.

In third iteration as well let's divide the remaining element and repeat the same process.

![O(logN) example image - 4 (02-Big O notations/images/O(logN)-4.png)](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/02-Big%20O%20notations/images/O(logN)-4.png)

Here at the end of 3rd iteration you will reach at the point where the array can not be split further.
Here in this example the number 4 is found at the end of 3rd iteration. 

So overall if you observe instead of looping over all the array elements one by one and comparing the element with given 
number (Where the max iterations required will be 8). Here in this case we only required 3 iterations.

Now if you notice and apply some maths here, you will observe for any N (i.e. length of array). The number of iterations in 
divide and conquer can be calculated by using below formula.

> 2<sup> i</sup> = N
> 
> where, <br>
> i = number of iterations<br>
> N = length of array (Size of input)
> 
> We have used 2 here because we are splitting the array into two parts.

Now if you re-write this as to calculate value of i instead of N. Then it will be.

> i = log<sub> 2 </sub>N
> 
> where, <br>
> i = number of iterations<br>
> N = length of array (Size of input)

Hence, for increase in input N the number of iterations increases in logarithmic order. So you can say that the time complexity
for this example if O(logN).

If you plot this complexity in graph then you will get a line similar to that of O(1) but slightly slanted and above it.
(refer below graph)

![O(logN) complexity graph (02-Big O notations/images/O(logN) complexity.png)](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/02-Big%20O%20notations/images/O(logN)%20complexity.png)

> In general, constant or logarithmic are considered to be the best time complexity and exponential/Quadratic is considered to 
> be the worst time complexity for any algorithm.

### Adding and multiplying time complexities.

In one of the earlier section we saw that in case of below example we can drop the constant while reporting the time complexity.

```java
public int printArrayElement(int[] arr){
   for(int i=0; i<arr.length; i++){
       System.out.println(arr[i]);
  }
   for(int j=0; j<arr.length; j++){
       System.out.println(arr[j]);
  }
}
```

Here we can drop the constant because constant was non-dominant term. We know for sure that for any inout both the loops 
will execute same number of time. So whatever is the effect of increase in size of input, it will be same on both the loops.
But now let's look at below example.

```java
public int printArrayElement(int limit1, int limit2){
   for(int i=0; i<limit1; i++){
       System.out.println(i);
  }
   for(int j=0; j<limit2; j++){
       System.out.println(j);
  }
}
```

In this example it is not necessary that limit1 and limit2 will always be equal. Hence number of iterations of first loop 
and number of iterations of second loop will be different. (At some cases there might be no iteration for one loop and 
a huge number of iteration of another loop). So we can't say that complexity here only depend on one input. It indeed depend
upon both the inputs. Now here both the inputs are independent and will run one after another. So if the time complexity for 
first loop is O(limit1) (i.e. directly proportional to the size of first input) and time complexity for second loop is 
O(limit2) (i.e. directly proportional to second input). So the overall complexity will be addition of both. i.e. 
O(limit1) + O(Limit2). Let's say size of inputs are N and M then O(N)+O(M). So the overall complexity will be 
O(N+M) (i.e. addition). Here we can not drop any term as both terms are independent.

Similarly, if the loops are interdependent but limits are different like in below example.

```java
public int printNumbers(int m, int n){
    for(int i=0; i<m; i++){
        for(int j=0; j<n; j++){
            System.out.println(i+" "+j);
        }
    }
 }
```

Here we are looping over the loop of j for every value of i. Now here as well m and n are totally independent, and it is 
possible that one can be small but other can be really huge and create significant impact on time complexity. Hence here 
as well we cannot drop any term. In this case the complexity will be O(NM) (i.e. multiplication). 

> To remember this in simple way, whenever the scenario is like do this **and after you finish** do that, the complexity 
> will be added. And if the scenario is like do this **for every** that, then complexity will be multiplied. 

### Space complexity

Till now, we learnt that to decide the efficiency of an algorithm we can use time complexity which is nothing but in the 
worst scenario as size of input increases then what will be the impact of it on time of execution. But time complexity is 
not the only deciding factor. Consider your code is executing in 1 sec every time, but it requires 50Mb of memory space.
In large scale applications this much amount of memory for just a single call is not atoll accepted, so the algorithm will 
not be considered as the efficient algorithm.

This analysis of impact on memory consumption by the algorithm as the size of input increases is called as space complexity. 
For example consider below method for addition of two numbers.

```java
public int addNumbers(int num1, int num2){
    return num1 + num2;
}
```

In this case no matter you pass 1 and 2 as num1 and num2 or 100000 and 99999. The memory required for this code to execute 
will not be affected. Hence the complexity in terms of memory space i.e. space complexity for above code is O(1) i.e. constant

Whereas consider below code.

```java
public long calculateFactorial(int n){
    if(n <= 1){
        return 1;
    }
    return n * calculateFactorial(n-1);
}
```

Here if we call calculatefactorial() method with n = 3. Then it will call itself with value 2 (i.e. 3-1) and that call will 
again call the same method with value of n as 1 (i.e. 2-1). This method calling itself is called as recursion (we will see
this in detail further). This recursion will continue till value of n become 1. And meanwhile all the calls to calculateFactorial()
method for all other values are stored in memory. 

So in case of N=3,<br>
First actual call will be calculateFactorial(3)<br>
This call will be stored in memory and another call will be triggered i.e. calculateFactorial(2)<br>
Now this call will also be stored in memory and another call will be triggered i.e. calculatefactorial(1)<br>
Now this call will return 1. which will then resume the call of calculateFactorial(2) and multiply that 1 with 2 and generate
2 as a result.<br>
This 2 is then transferred to resume the call calculateFactorial(3), here that 2 will be multiplied with 3 to generate result as 6.<br>
And finally the 6 will be returned.

So here for N=3, total of three calls was made and stored in the memory. Consider for N=1000, there will be 1000 such calls
stored in memory. And it will consume memory 1000 times. So here memory utilization is getting increased in direct proportion 
with size of input hence here the space complexity is O(N).

### How to calculate complexity of any algorithm in terms of BigO?
To calculate the time complexity of any piece of code we can use below rules.

1. Any assignment statement and if statement which is being executed only once will have O(1) complexity.
2. A simple for loop (with no internal loops) will have O(N) complexity.
3. A nested loop where controlling parameter is same will have O(N<sup>2</sup>) complexity.
4. A loop where we are dividing the controlling term by 2 in each iteration will have O(log N) complexity.
5. The overall complexity of code will be the addition of all individual complexities (dropping the non-dominant complexities.)

For example have a look at below code.

```java
public void checkAddition(int n){
    int sum = 0;
    for(int i=0; i<=n;i++){
        sum += i;
    }
    if(sum>100){
        System.out.println("This was the number you are looking for!");    
    } else {
        System.out.println("The number is very small.");    
    }
}
```

Here, first statement is simple assignment statement i.e. `int sum = 0;` so it will have O(1) time complexity.<br>
Then we have a for loop which contains again a simple addition and assignment so no nested loops, hence the time complexity 
will be O(N) here.<br>
Then we have a if statement which will have time complexity of O(1), Then couple of print statement which again have complexity of O(1).

![Calculating the time complexity(02-Big O notations/images/calculation of space complexity.png)](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/02-Big%20O%20notations/images/calculation%20of%20space%20complexity.png)

So the overall time complexity of the code will be<br>

O(1) + O(N) + O(1) + O(1) + O(1) + O(1) + O(1)<br>

Now if we remove the non-dominant time complexities, then the final time complexity will be O(N).

Hence, the time complexity of above algorithm/code is O(N).