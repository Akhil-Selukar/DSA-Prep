package org.akhil;

public class Solution {

    // O(N)/O(N)
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();

        int start = 0;
        int end = arr.length-1;

        while(start < end){
            while(start < end && !isVowel(arr[start])){
                start++;
            }

            while (end > start && !isVowel(arr[end])){
                end--;
            }
            swap(start, end, arr);
            start++;
            end--;
        }

        StringBuilder sb = new StringBuilder();
        for(char ch:arr){
            sb.append(ch);
        }

        return sb.toString();
    }

    private void swap(int i, int j, char[] arr){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private boolean isVowel(char ch){
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch=='o' || ch=='u'
        || ch =='A' || ch == 'E' || ch == 'I' || ch =='O' || ch == 'U'){
            return true;
        }
        return false;
    }
}
