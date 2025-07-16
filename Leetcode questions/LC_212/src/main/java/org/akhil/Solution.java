package org.akhil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    // Solution 1 - TLE
    // O(W *(M*N*4^(M*N)))
//    public List<String> findWords(char[][] board, String[] words) {
//        int m = board.length;
//        int n = board[0].length;
//
//        Set<String> foundWords = new HashSet<>();
//        boolean[][] visited = new boolean[m][n];
//
//        for(String word:words){
//            for(int i=0; i<m; i++){
//                for(int j=0; j<n; j++){
//                    if(word.length() <= (m*n) && canConstruct(board, word, i, j, 0, visited)){
//                        foundWords.add(word);
//                    }
//                }
//            }
//        }
//
//        List<String> result = new ArrayList<>();
//        for(String word:foundWords){
//            result.add(word);
//        }
//        return result;
//    }
//
//    private boolean canConstruct(char[][] board, String word, int i, int j, int wordIndex, boolean[][] visited) {
//        if(wordIndex >= word.length()){
//            return true;
//        }
//        if(i >= board.length || j >= board[0].length || i<0 || j<0){
//            return false;
//        }
//
//        if(!visited[i][j] && board[i][j] == word.charAt(wordIndex)){
//            visited[i][j] = true;
//            boolean result = canConstruct(board, word, i-1, j, wordIndex+1, visited)
//                    || canConstruct(board, word, i+1, j, wordIndex+1, visited)
//                    || canConstruct(board, word, i, j-1, wordIndex+1, visited)
//                    || canConstruct(board, word, i, j+1, wordIndex+1, visited);
//            visited[i][j] = false;
//            return result;
//        } else {
//            return false;
//        }
//    }


    // --------------------
    // Solution 2 - Trie Implementation

}
