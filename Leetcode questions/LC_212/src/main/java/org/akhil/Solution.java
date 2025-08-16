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
    // Dominant TC -> O(M*N*4^L) i.e. of board traversal and helper function
    // SC -> O(W*L) where W is number of words in words array and L is average length of words in words array.


    // node structure
    class Node{
        Node[] child;
        boolean endOfWord;
        String word;

        public Node(){
            child = new Node[26];
            endOfWord = false;
            word = null;
        }
    }


    private int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public List<String> findWords(char[][] board, String[] words) {

        // Create a Trie and insert all words in Trie
        Node root = new Node();

        // insertion in Trie -> O(W*L) where W is total words in words array and L is average length of words.
        for(String word:words){
            Node curr = root;
            for(char ch:word.toCharArray()){
                int index = ch-'a';

                if(curr.child[index] == null){
                    curr.child[index] = new Node();
                }
                curr = curr.child[index];
            }
            curr.endOfWord = true;
            curr.word = word;
        }

        // traverse through the board and check each cell against trie.
        List<String> result = new ArrayList<>();

        // Board traversal (M*N)
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                char ch = board[i][j];
                if(root.child[ch-'a'] != null) {
                    helper(i, j, board, root, result);
                }
            }
        }
        return result;
    }

    // O(4^L) where L is the length of word we are searching in board.
    private void helper(int row, int col, char[][] board, Node curr, List<String> result) {
        // Handle the character at the current cell
        char ch = board[row][col];
        int index = ch - 'a';

        // Move to the next node in the trie. This line is now safe.
        Node nextNode = curr.child[index];

        if (nextNode.endOfWord) {
            result.add(nextNode.word);
            // Prevents adding the same word multiple times
            nextNode.endOfWord = false;
        }

        // Mark the current cell as visited to prevent cycles
        board[row][col] = '.';

        // Explore neighbors
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            // Check boundaries and if the cell has been visited
            if (newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length && board[newRow][newCol] != '.') {
                char nextChar = board[newRow][newCol];
                int nextIndex = nextChar - 'a';
                if (nextNode.child[nextIndex] != null) {
                    helper(newRow, newCol, board, nextNode, result);
                }
            }
        }
        // Backtracking: restore the board character
        board[row][col] = ch;
    }
}
