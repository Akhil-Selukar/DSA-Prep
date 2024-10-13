### Euclid's algorithm to find GCD/GCF

**What is GCD/GCF?**<br>
GCD (Greatest Common Divisor) or GCF (Greatest Common Factor) of A and B is the greatest possible number which is factor of 
both A and B (means it should divide both A and B completely.)

**Euclid's algorithm**<br>
Euclidean algorithm or Euclid's algorithm, is an efficient method for computing the greatest common divisor (GCD) of two integers.
The equation of euclid's algorithm is.<br>

GCD(a,b) = GCD(reminder of (b,a), a)<br>
i.e. GCD(a,b) = GCD(b%a, a)<br>

Then we can apply same thing again and again till b%a becomes zero.

### To calculate LCM

**What is LCM?**<br>
LCM (Least Common Multiple) of A and B is a lowest number which is divisable by both A and B.
For example LCM of 3 and 4 is 12 because 12 is the smallest number which is completely divisable by both 3 and 4.

Now the relationship between LCM and HFC/GCD is 

LCM(a, b) = (a*b)/GCD(a,b)

Same equation we can use to calculate LCM now.