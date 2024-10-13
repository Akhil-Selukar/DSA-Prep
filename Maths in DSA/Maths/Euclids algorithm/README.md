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

