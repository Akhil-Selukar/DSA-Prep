package org.dsaprep;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
//        BigInteger num1 = BigInteger.valueOf(12);
//        BigInteger num2 = BigInteger.valueOf(6);
//
//        BigInteger add = num1.add(num2);
//        System.out.println(add);
//
//        BigInteger sub = num1.subtract(num2);
//        System.out.println(sub);
//
//        BigInteger mult = num1.multiply(num2);
//        System.out.println(mult);
//
//        BigInteger div = num1.divide(num2);
//        System.out.println(div);
//
//        BigInteger rem = num1.remainder(num2);
//        System.out.println(rem);

        // --------------------------------------

//        BigInteger num1 = new BigInteger("1564852365788956645164665615497318");
//        BigInteger num2 = new BigInteger("2656484654846413515312151315446612");
//
//        BigInteger add = num1.add(num2);
//        System.out.println(add);
//
//        BigInteger sub = num1.subtract(num2);
//        System.out.println(sub);
//
//        BigInteger mult = num1.multiply(num2);
//        System.out.println(mult);
//
//        BigInteger div = num1.divide(num2);
//        System.out.println(div);
//
//        BigInteger rem = num1.remainder(num2);
//        System.out.println(rem);

        // -------------------------------------------

        BigDecimal num1 = new BigDecimal("0.04");
        BigDecimal num2 = new BigDecimal("0.03");

        BigDecimal sub = num1.subtract(num2);
        System.out.println(sub);

        System.out.println(factorial(100));

    }

    public static BigInteger factorial(int num){
        BigInteger answer = BigInteger.valueOf(1);
        for(int i=2; i<=num; i++){
            answer = answer.multiply(BigInteger.valueOf(i));
        }
        return answer;
    }
}