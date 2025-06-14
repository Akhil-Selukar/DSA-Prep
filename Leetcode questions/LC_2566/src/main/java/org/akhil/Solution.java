package org.akhil;

public class Solution {

    // O(L)/O(L) where L is length of num.
    public int minMaxDifference(int num) {
        // As we have to work on digits hence separate individual digits.
        String number = Integer.toString(num);
        char[] maxChars =new char[number.length()];
        char[] minChars =new char[number.length()];

        char digitToReplace = ' ';

        // find first digit other than 9 from left.
        for(char ch:number.toCharArray()){
            if(ch != '9'){
                digitToReplace = ch;
                break;
            }
        }

        // replace all occurances of digitToReplace with '9' to get max number possible
        for(int i=0; i<number.length(); i++){
            if(number.charAt(i) == digitToReplace){
                maxChars[i] = '9';
            } else {
                maxChars[i] = number.charAt(i);
            }
        }
        int maxNumber = Integer.parseInt(new String(maxChars));


        // replace all occurances of digitToReplace with '0' to get min number possible
        digitToReplace = number.charAt(0);

        for(int i=0; i<number.length(); i++){
            if(number.charAt(i) == digitToReplace){
                minChars[i] = '0';
            } else {
                minChars[i] = number.charAt(i);
            }
        }
        int minNumber = Integer.parseInt(new String(minChars));

        return maxNumber - minNumber;
    }
}
