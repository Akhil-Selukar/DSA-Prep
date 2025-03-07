### Sieve of eratosthenes

This algorithm is used to find the prime numbers till N where N is given number.
The normal code to find all prime numbers till N is not really optimized and need multiple loops. 
This algorithm optimizes the prime number calculation by using soe pre-computation.

The core concept behind this algorithm is to mark all index (in an array which are not prime) and then just loop over resultant 
array and if it is not marked then the index is prime otherwise not.