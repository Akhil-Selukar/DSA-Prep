### Dynamic programming

Dynamic programming is one of the most important part of programming. It is a problem-solving technique that break down 
the complex problem into smaller and more manageable sub-problems and storing teh result of those sub-problems so that 
they don't need to be recalculated. It saves a lot of computation time and problem can be solved faster.

To understand this better consider a very basic problem where we have to calculate and return the 5th fibonacci number. 
The basic code for this will be something like below. (where n = 5)

```java
class Main {
    public static void main(String[] args) {
        System.out.println(fibonacci(5));
    }

    public static int fibonacci(int n){
        if(n <=1){
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }
}
```

Here the base condition in above recursion is if the number is less than or equal to 1 we are returning the same number 
or else we are adding the (n-1)<sup>th</sup> fibonacci number and (n-2)<sup>th</sup> fibonacci number and returning the value
(i.e. recursive call). <br>
If we try to understand the flow of above program in more details, then below will be the recursion tree for this problem.

![DP image-1](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Dynamic%20programming/images/DP%20image-01.jpg)

As all the recursive calls ae executed from left to right so first f(5) will call f(4) which then call f(3) which further 
calls f(2) and the f(1) so the recursive call for f(4) will follow below order to calculate f(4). Which will make the 
time complexity of above code as O(N<sup>2</sup>)

![DP image-2](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Dynamic%20programming/images/DP%20image-02.jpg)

Here green arrows represents the function call and blue arrows represents the returned value after the entire function is 
executed. Here we can see that for calculating f(4) we have calculated f(3) and f(2). There as well we have calculated f(2)
twice, once for calculating f(3) and other one is for actual f(2) while calculating f(4) (LHS). So this is one repetition.
Also while calculating RHS of f(5) we will again have to calculate f(3) and for that we will again need f(2). So there 
are many repetitions involved in this recursive tree. Consider what if this calculation involve some complex logic in that 
case repeating the same logic again and again will not make any sense. If we have calculated a value before and we know 
that it will not change then we can reuse this same value. This is what dynamic programming does.<br>

There are two techniques to do this, 
1. Memoization (Some people call it as memorization)
2. Tabulation

#### Memoization technique<br>
This is also known as "top down" approach, because the problem is usually solved in the direction of main problem to the base cases.
Below are the steps involved in Memoization technique
1. Create an array of length (n+1) and initialize it with default value (dp array).
2. Whenever we want to find the answer for a particular value 'n', first check if the answer is present in dp array or not. 
If it is present then return that value and do not calculate it again.
3. If not present in the dp array then calculate it and before returning the calculated value store it in dp array.

Below will be the code using memoization for fibonacci number.

```java
class Main {
    public static void main(String[] args) {
        int[] dp = new int[5+1];
        Arrays.fill(dp, -1);
        System.out.println(fibonacci(5, dp));
    }

    public static int fibonacci(int n, int[] dp){
        if(n <=1){
            return n;
        }
        if(dp[n] != -1){
            return dp[n];   
        }
        return dp[n] = fibonacci(n-1, dp) + fibonacci(n-2, dp);
    }
}
```

Here in teh recursive calls will be reduced and the recursion tree will be simplified like below.

![DP image-3](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Dynamic%20programming/images/DP%20image-03.jpg)

Here as the answer for overlapping sub-problems will be returned from the array and will only be calculated once hence the 
time complexity will be O(N).

#### Tabulation<br>
This is also called as "bottom-up" approach where we start from the base case and reach the final answer that we want.
Below are the steps involved in Tabulation technique.
1. Declare a dp[] array of size n+1.
2. First initialize the base condition values, (i.e in this case i=0 and i=1 of the dp array as 0 and 1 respectively).
3. Set an iterative loop that traverses the array( from index 2 to n) and for every index set its value as dp[i-1] + dp[i-2]. 

```java
import java.util.Arrays;
class Main {
    public static void main(String[] args) {
        int n = 5;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;
        
        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        System.out.println(dp[n]);
    }
}
```

Here in this case as well we are calculating the value for dp[i] for N-2 times which is nothing but the time complexity of 
O(N). Also here we are using an array of size n+1 to store all calculated values hence space complexity is O(N).

> Note: Above answer will work fine but if we observe carefully the tabulation technique. Here for any i<sup>th</sup> iteration 
> we are not using values apart from (i-1)<sup>th</sup> and (i-2)<sup>th</sup> iterations value. Hence there is no point 
> in storing values for all other iterations. Consider you are asked to find 1000<sup>th</sup> fibonacci number then you will
> be storing 998 values which are not required hence here we can further improve space complexity of above solution to O(1)
> like below.

```java
class Main {
    public static void main(String[] args) {
        int n = 5;
        int secondPreviousValue = 0;
        int previousValue = 1;
        
        for(int i=2; i<=n; i++){
            int currentValue = previousValue + secondPreviousValue;
            secondPreviousValue = previousValue;
            previousValue = currentValue;
        }
        
        System.out.println(previousValue);  // because at nth iteration actual answer will be stored in previous (last line in loop)
    }
}
```


#### When to apply DP or how to identify DP problems.
Whenever you are asked to find all possible ways to do something or whenever you want to find the best possible way (or 
situation where you have to check all the possible ways to perform a task) There we can apply recursion and in recursion 
if we are calculating same value again and again we can use DP. 

Another important point is while solving the DP problem or recursion problem try to represent the problem in the form of 
indexes. Then perform all possible operations on the index. Then sum of all the possible operations you did will be number
of ways and min/max of it will be best and worst way.