### Sieve of Eratosthenes (method to find prime numbers)

Sieve of Eratosthenes is one of the greatest method to find all prime numbers between 1 and N, where N is the given number.

**Explanation :**<br>
By definition we know that the prime numbers are those which are divisible by 1 and itself.<br>

Consider an example where N = 20.<br>
If we write all numbers from 2 to 20 (as 1 is neither prime nor composite)<br>
2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20

If we check first number i.e. 2 which is prime, then all multiple of 2 till 20 will be for sure composite (as they are multiple 
of 2). So we can strike out all multiple of 2.

**2**, 3, ~~4~~, 5, ~~6~~, 7, ~~8~~, 9, ~~10~~, 11, ~~12~~, 13, ~~14~~, 15, ~~16~~, 17, ~~18~~, 19, ~~20~~

Now in next iteration we will have 3, which is not struck, so we can consider 3 as prime and all multiple of 3 will be composite.
Hence

**2**, **3**, ~~4~~, 5, ~~6~~, 7, ~~8~~, ~~9~~, ~~10~~, 11, ~~12~~, 13, ~~14~~, ~~15~~, ~~16~~, 17, ~~18~~, 19, ~~20~~

Now next is 4 which is already struck so we can ignore it as it is composite (struck).  
And if you observe the remaining numbers now, all the numbers are prime.<br>
That means just like factors we can iterate till sqrt(N), and strike all the multiples. The remaining will be the prime numbers 
between 1 till given number N.

This method is called **Sieve of Eratosthenes**. The space complexity for this method is O(N) as we need to create array of size N.
And to calculate time complexity if we see the code.

```java
for(int i=2; i*i<n; i++){
    if(!arr[i]){
        for(int j=i*2; j<=n; j+=i){
            arr[j] = true;
        }
    }
}
```

Here if we have total N numbers then the numbers divisible by 2 from 2 to N will be N/2. So we will be striking out N/2 terms 
when we loop for 2 (i.e. internal loop will run for N/2 times).<br>
Similarly for 3 (i=3) total numbers divisible by 3 between 2 to N will be N/3. Hence inner loop will run N/3 times.<br>
For 4 as it is already struck in first iteration hence no loop will run. 
Hence, let's say for prime number P, inner loop will run N/P times.

So if we add all, we will get<br>

N/2 + N/3 + N/5 + N/7 + N/11 + N/13 + .....

If we take N as common,<br>

N(1/2 + 1/3 + 1/5 + 1/7 + 1/11 + 1/13 + ....)

This is nothing but sum of inverse of first N prime numbers,<br>
By harmonic progression the value is log(log(N)).

Hence, the entire value will be `N log(log(N))` which is nothing but the time complexity for this code.

