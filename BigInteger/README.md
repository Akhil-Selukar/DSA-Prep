### BinInteger and BigDecimal class.

BigInteger class is used for the mathematical operation which involves very big integer calculations that are outside the 
limit of all available primitive data types. (The thing to note here is BigInteger is a class and not a primitive datatype).

Consider below example.

```java
public static void main(String[] args) {
        BigInteger num1 = BigInteger.valueOf(12);
        BigInteger num2 = BigInteger.valueOf(6);

        BigInteger add = num1.add(num2);
        System.out.println(add);

        BigInteger sub = num1.subtract(num2);
        System.out.println(sub);

        BigInteger mult = num1.multiply(num2);
        System.out.println(mult);

        BigInteger div = num1.divide(num2);
        System.out.println(div);

        BigInteger rem = num1.remainder(num2);
        System.out.println(rem);
    }
```

Here we have defined two BigIntegers using `BigInteger num1 = BigInteger.valueOf(12);` syntax. Here important thing to note 
is that inside the valueOf() function of BigInteger we can only pass long, but we can have a number beyond long range. 
In that case we can create BigInteger using syntax `BigInteger num1 = new BigInteger("1564852365788956645164665615497318");`

In above code some operations are also performed on BiIntegers.

<hr>
Similar to BigInteger we do have BigDecimal class as well to handle really large decimal values. Another place where BigDecimal
can be useful is to eliminate precision error in floating point arithmetics. Have a look at below code.

```java
public static void main(String[] args) {
        double num1 = 0.04;
        double num2 = 0.03;

        double answer = num1 - num2;
        system.out.pritln(answer);
    }
```

The expected answer for above code is 0.01 right?. But the actual answer we get is  0.01000000002. Why the extra 0.00000000002?
This is because decimals like 0.04 or 0.03 can not be represented in binary using finite number of bits which leads to the 
precision error in floating point arithmetics. This can be mitigated by using the BigDecimal class.

```java
public static void main(String[] args) {
        BigDecimal num1 = new BigDecimal("0.04");
        BigDecimal num2 = new BigDecimal("0.03");

        BigDecimal sub = num1.subtract(num2);
        System.out.println(sub);
    }
```

Now the above code will give the exact answer. (Note that we can store huge decimal number using BigDecimal class.)

Below method calculate the factorial value for numbers where factorial answer is beyond the range of integers.

```java
public static BigInteger factorial(int num){
        BigInteger answer = BigInteger.valueOf(1);
        for(int i=2; i<=num; i++){
            answer = answer.multiply(BigInteger.valueOf(i));
        }
        return answer;
    }
```

For example the factorial of 100 is `93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000`
which is handled and returned correctly by the method.