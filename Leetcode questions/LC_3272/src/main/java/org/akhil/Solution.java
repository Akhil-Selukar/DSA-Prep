package org.akhil;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    private int count = 0;
    private long[] precomputedFact = new long[11];
    private Set<Long> considered = new HashSet<>();

    public long countGoodIntegers(int n, int k) {
        precomputeFactorial();
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < n; i++)
            number.append(' ');
        generatePalindromes(0, n, number, k);
        return count;
    }

    // precompute all factorials of numbers from 0 to 10;
    private void precomputeFactorial() {
        precomputedFact[0] = 1;
        precomputedFact[1] = 1;
        for (int i = 2; i <= 10; i++)
            precomputedFact[i] = i * precomputedFact[i - 1];
    }

    // method to count all permutations of given digits (Formula (N!)/(f1! * f2! ...fn!)) where f1 is the frequency of 1st digit f2 is frequency of 2nd and so on.
    private long countAllPermutations(int[] freq, int n) {
        long count = precomputedFact[n];
        for (int i = 0; i <= 9; ++i)
            count = count/precomputedFact[freq[i]];
        return count;
    }

    // To check all valid (not having leading 0's) arrangements
    private long allArrangements(String number, int n) {
        // check if this number is considered as a part of permutation of any other number (anagram check logic)
        char[] numArray = number.toCharArray();
        Arrays.sort(numArray);
        String sortedNumber = new String(numArray);
        long num = Long.parseLong(sortedNumber);
        if (considered.contains(num)) {
            return 0;
        }

        considered.add(num);    // if not considered earlier that add to considered set.

        // calculate frequency of each digit in the number
        int[] freq = new int[10];
        for (char c : numArray) {
            freq[c - '0']++;
        }

        // all possible permutations of the digits
        long totalPermutations = countAllPermutations(freq, n);

        // invalid permutations of the digits
        long invalidPermutations = 0;
        if (freq[0] > 0) {
            freq[0]--;
            invalidPermutations = countAllPermutations(freq, n - 1);
        }

        return totalPermutations - invalidPermutations;
    }

    // to check the divisibility by k
    private boolean isKPalindrome(String number, int k) {
        return Long.parseLong(number) % k == 0;
    }

    // generate all palindrome numbers of n digits.
    private void generatePalindromes(int index, int n, StringBuilder number, int k) {

        // if palindrome number is generated
        if (index >= (n + 1) / 2) {
            String numStr = number.toString();
            if (isKPalindrome(numStr, k))
                count += allArrangements(numStr, n);
            return;
        }

        // as we dont want leading 0 hence for 0th index start from 1 to 9 and for all other index start from 0 to 9.
        char start = (index == 0) ? '1' : '0';
        while (start <= '9') {
            number.setCharAt(index, start);                         // place value from 0/1 to 9 on index.
            number.setCharAt(n - index - 1, start);            // place same value at its mirror position (because we need palindrome)
            generatePalindromes(index + 1, n, number, k);       // recursive call for next index.
            start++;
        }
        number.setCharAt(index, ' ');                           // backtracking
    }
}
