#### Square root using newton raphson method.

You are given a number N, find the square root of N. (error of 0.5 is allowed)

**Theory** -<br>
Newton raphson formula is<br>

root = 0.5*(x + N/x)<br>
where N is the number of which sq root is needed.<br>
x is our guess.<br>

Let's consider our guess is correct then in that case x is the actual square root of N.<br>
Hence, &radic;N = x<br>

Hence, our equation will become.<br>

&radic;N = 0.5*(&radic;N + N/&radic;N)<br>

Which can be simplified to.<br>

&radic;N = 0.5*(&radic;N + &radic;N)

Which is noting but

&radic;N = 0.5*(2&radic;N)

0.5 is nothing but 1/2 hence 1/2 and 2 will cancel each other, and we will get.

&radic;N = &radic;N


> We will keep on guessing the root till the above equation is not satisfied (i.e. withing the error range).
> 
> To check the error we can simply check root = x or not i.e. root - x should be less that error threshold.
