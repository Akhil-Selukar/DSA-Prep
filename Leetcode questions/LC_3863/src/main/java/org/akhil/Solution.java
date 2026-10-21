package org.akhil;

public class Solution {
    // Here the most important thing to note are "We can SORT the substrings" and not Swap some characters.
    // Another important thing is we have to choose substring of length less that the length of given string.
    // So if we want to minimize the number of sort operations then we will obviously try to sort the longest possible
    // substring. And as we are not allowed to take substring of length n then we will take substring of length 'n-1'.
    // So n-1 means we either leave first char or last char.
    // now if we leave first char and then sort remaining chars in that case we performed 1 operation, and if the first char
    // is already the smallest then the entire string is sorted now. So the result will be 1.
    // Similarly, if we leave last char and sort remaining chars, and the last char is already the largest then also the
    // result is 1.
    // Next possibility is neither first nor last char is smallest or largest, and they are somewhere middle in the
    // string. Then first we will sort the substring from 0 to n-1 which will get the smallest at 0th index and largest at n-2th index
    // now to move largest char to last index i.e. n-1 we will need another sort in substring 1 to n-1, this will move the largest
    // char to the end of the substring. So total of 2 operations.
    //  Now there is an interesting edge case remaining here. What if largest character is at 0th index and smallest character is at
    // n-1st index. In that case 1st sort from 0 to n-2 will move largest char to n-2 index. Then second sort from 1 to n-1 will
    // move largest to n-1 and smallest to 1st index. At this point still smallest is not at the start of the string.
    // Hence we need 1 more additional sort to move smallest char which is at 1st index to the 0th index. hence the answer will be 3
    // Now all strings no matter where which char is present will fall under one of these 3 cases. and our answer will always be
    // either 1, 2 or 3. (Only in case of valid strings)
    // Now what about string is already sorted in that case we need 0 swaps.
    // But in case of string of 2 chars which is not sorted, here as per the given condition we can not take substring of length
    // n. So we can only choose substring of 1 char and no matter which char we choose we will never be able to switch it's place
    // hence in that case the answer will be -1.

    // O(N)/O(1)
    public int minOperations(String s) {
        int n = s.length();

        char max = s.charAt(0);
        char min = s.charAt(0);
        boolean isSorted = true;

        for(int i=1; i<n; i++){
            char ch = s.charAt(i);

            if(ch < s.charAt(i-1)){
                isSorted = false;
            }

            if(ch < min){
                min = ch;
            }

            if(ch > max){
                max = ch;
            }
        }

        // if it is already sorted
        if(isSorted){
            return 0;
        }

        // if not sorted but length of string is 2 then we can not take valid substring to sort hence return -1
        if(n == 2){
            return -1;
        }

        // if any of the edge character is at its correct position then we cna simply take substring excluding that character and sort it
        if(s.charAt(0) == min || s.charAt(n-1) == max){
            return 1;
        }

        // if min is at the end or max is at the start then we will need 2 operations
        for(int i=1; i<n-1; i++){
            if(s.charAt(i) == min || s.charAt(i) == max){
                return 2;
            }
        }

        return 3;
    }
}
