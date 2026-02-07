package org.akhil;

public class Solution {
    // Solution 1 - tracking prev A and post B
    // O(N)/O(N)
    // public int minimumDeletions(String s) {
    //     int n = s.length();

    //     int[] prefSumA = new int[n];
    //     int[] prefSumB = new int[n];

    //     // find at each index how many 'b' are there to the left of it
    //     int count = 0;
    //     for(int i=0; i<n; i++){
    //         prefSumB[i] = count;
    //         if(s.charAt(i) == 'b'){
    //             count++;
    //         }
    //     }

    //     // find at each index how many 'a' are theer to the right of it
    //     count = 0;
    //     for(int i=n-1; i>=0; i--){
    //         prefSumA[i] = count;
    //         if(s.charAt(i) == 'a'){
    //             count++;
    //         }
    //     }

    //     // now consider each index as the break point (the point which seperates 'a' and 'b' chars in string)
    //     // and see how many 'b' are there to the left of it and how many 'a' are there to the right of it (that many deletions
    //     // we will be needing if we consider the index as break point) So minimize the deletion here.
    //     int result = n;
    //     for(int i=0; i<n; i++){
    //         result = Math.min(result, (prefSumA[i] + prefSumB[i]));
    //     }

    //     return result;
    // }

    // ----------------------------
    // Solution 2 - tracking prev A and post B (just removed 1 loop)
    // O(N)/O(N)
    // public int minimumDeletions(String s) {
    //     int n = s.length();

    //     int[] prefSumA = new int[n];
    //     int[] prefSumB = new int[n];

    //     // find at each index how many 'b' are there to the left of it
    //     int countA = 0;
    //     int countB = 0;
    //     for(int i=0; i<n; i++){
    //         prefSumB[i] = countB;
    //         if(s.charAt(i) == 'b'){
    //             countB++;
    //         }

    //         prefSumA[n-i-1] = countA;
    //         if(s.charAt(n-i-1) == 'a'){
    //             countA++;
    //         }
    //     }

    //     // now consider each index as the break point (the point which seperates 'a' and 'b' chars in string)
    //     // and see how many 'b' are there to the left of it and how many 'a' are there to the right of it (that many deletions
    //     // we will be needing if we consider the index as break point) So minimize the deletion here.
    //     int result = n;
    //     for(int i=0; i<n; i++){
    //         result = Math.min(result, (prefSumA[i] + prefSumB[i]));
    //     }

    //     return result;
    // }

    // ----------------------------
    // Solution 3 - Using stack
    // O(N)/O(N)
    // public int minimumDeletions(String s) {
    //     int n = s.length();
    //     int result = 0;
    //     Stack<Integer> stack = new Stack<>();

    //     // here if we bserve we only have to delete char if we have a bad pair (i.e. b before a)
    //     // another thing is we are not deleting entire pair we just have to delete 1 char from each pair for minimum deletion
    //     // So in short we just need to perform deletions equal to no of bad pairs hence if we count no of bad pairs that will be the
    //     // required answer.

    //     for(int i=0; i<n; i++){
    //         if(s.charAt(i) == 'b'){
    //             stack.push(i);
    //         } else if (!stack.isEmpty()){   // that means we encounter an 'a' at index i and there was a 'b' before which is not yet paired with any 'a' to form a bad pair
    //             // so form a bad pair with current 'a' and remove the 'b' from stack as it is Paird now
    //             result++;       // no of bad pair increased
    //             stack.pop();    // removed the paird 'b'
    //         }
    //     }

    //     return result;
    // }

    // ----------------------------
    // Solution 4 - by tracking count of 'b'
    // O(N)/O(1)
    public int minimumDeletions(String s) {
        int n = s.length();
        int result = 0;

        // from above solution we can see that we just need to keep track of how many unpaired 'b' we have, that we can
        // do simply by a counter and eliminate the stack
        int bCount = 0;

        for(int i=0; i<n; i++){
            if(s.charAt(i) == 'b'){
                bCount++;
            } else if(bCount != 0){
                bCount--;
                result++;
            }
        }
        return result;
    }
}
