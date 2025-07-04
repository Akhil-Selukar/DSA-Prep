package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    // TC -> O(R * (N + maxWidth))    where R is number of rows in answer and N is number of words in words array.
    // SC -> O(R * maxWidth)
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int n = words.length;
        int index = 0;

        while(index < n){       // O(R)  where R is number of lines in output
            int letterCountInCurrLine = words[index].length();
            int normalSpacesCount = 0;
            int wordIndex = index+1;
                                  // normal spaces + letters till now + letters in new word + another space because of now word
            while(wordIndex < n && normalSpacesCount + letterCountInCurrLine + words[wordIndex].length() + 1 <= maxWidth) {     // O(N)     this loop will process each word exactly once
                letterCountInCurrLine = letterCountInCurrLine + words[wordIndex].length();      // only letters count
                normalSpacesCount = normalSpacesCount + 1;    // only spaces count (mandatory space not the extra ones)
                wordIndex++;
            }

            int totalSpacesInCurrLine = maxWidth - letterCountInCurrLine;

            int spaceBetween = normalSpacesCount == 0 ? 0 : totalSpacesInCurrLine / normalSpacesCount;
            int extraSpaces = normalSpacesCount == 0 ? 0 : totalSpacesInCurrLine % normalSpacesCount;

            if (wordIndex == n){    // i.e. last line
                spaceBetween = 1;
                extraSpaces = 0;
            }

            String justifiedString = getString(words, index, wordIndex, spaceBetween, extraSpaces, maxWidth);

            result.add(justifiedString);

            // in next line skip words considered in current line.
            index = wordIndex;
        }
        return result;
    }


    // O(maxWidth) in worst case
    private String getString(String[] words, int index, int wordIndex, int spaceBetween, int extraSpaces, int maxWidth) {
        StringBuilder sb = new StringBuilder();

        for(int i=index; i<wordIndex; i++){
            // add word
            sb.append(words[i]);

            // add compulsory spaces
            if(i != wordIndex-1) {      // don't want spaces after last word in current line
                for (int j = 0; j < spaceBetween; j++) {
                    sb.append(" ");
                }

                // add extra space (left prioritised)
                if (extraSpaces > 0) {
                    sb.append(" ");
                    extraSpaces--;
                }
            }
        }

        // in case of last line fill all remaining places with space
        while(sb.length() < maxWidth) {
            sb.append(" ");
        }

        return sb.toString();
    }
}
