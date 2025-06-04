package org.akhil;

public class Solution {

    // Solution 1 - O(N^2)/O(1)  where N is length of string. N^2 because of loop and substring().
//    public String answerString(String word, int numFriends) {
//        int n = word.length();
//        if(numFriends == 1){
//            return word;
//        }
//
//        int possibleLongestWord = n - (numFriends-1);   // out of num friends 1 will receive the required answer (i.e. the Lexicographically Largest String) to make this string length wise largest we will have to give 1 char to all remaining friends and rest all chars will contribute to the answer string.
//
//        String result = "";
//
//        for(int i=0; i<n; i++){
//            int charsToTake = Math.min(possibleLongestWord, n-i);   // it can be possible that longest is not the lexicographically largest hence we have to check all possible strings and our string can either be of maxPossibleLength or less.
//
//            String subString = word.substring(i, i+charsToTake);
//
//            if(subString.compareTo(result) > 0){
//                result = subString;
//            }
//        }
//
//        return result;
//    }

    // Solution 2 - Even though this solution looks like it will take less time but above is more faster and intuitive.
    // In above example we were checking all the strings and finding the best out of it. But as we know we need lexicographically largest string so
    // it will be the one which start from the largest character. This is what we are using here. We are finding the index of starting point of the result string
    // i.e. index of lexicographically largest string first and then only generating the required substring.
    public String answerString(String word, int numFriends) {
        int n = word.length();

        if (numFriends == 1) {
            return word;
        }

        int i = bestStartingPoint(word, n);
        int possibleLongestWord = n - (numFriends - 1);
        int charsToTake = Math.min(possibleLongestWord, n - i);

        return word.substring(i, i + charsToTake);
    }

    private int bestStartingPoint(String word, int n) {
        int i=0;        // index to store best starting point
        int j=1;        // index to check if there is any better starting point available further.

        while(j < n){
            int k = 0;

            // skip the equal characters
            while ((j+k < n) && (word.charAt(i + k) == word.charAt(j + k))) {
                k++;
            }

            if ((j+k < n) && (word.charAt(j+k) > word.charAt(i+k))) {
                i = j; // updating best starting point
                j = j + 1;
            } else {
                j = j + k + 1; // skipping already checked characters
            }
        }
        return i;
    }
}
