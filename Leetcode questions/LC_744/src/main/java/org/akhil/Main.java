package org.akhil;

public class Main {
    public static void main(String[] args) {
        char[] letters = {'c','f','j'};
        char target = 'c';

        System.out.println(nextGreatestLetter(letters, target));
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        int startIndex = 0;
        int endIndex = letters.length-1;

        while(startIndex<=endIndex){
            int midIndex = startIndex + (endIndex - startIndex)/2;

            if(target<letters[midIndex]){
                endIndex = midIndex-1;
            }else {
                startIndex = midIndex+1;
            }
        }
        return letters[startIndex%letters.length];
    }
}