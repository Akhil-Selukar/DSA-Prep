package org.akhil;

public class Solution {
    public int[] stringIndices(String[] words, String[] queries) {
        Trie root = new Trie();
        int smallestWordIndex = -1;         // in case of no suffix match we need to assign the smallest word index as result.
        int smallestWordLen = Integer.MAX_VALUE;

        for(int i=0; i<words.length; i++){
            root.insert(words[i], i);
            int wordLen = words[i].length();

            if(smallestWordLen > wordLen){
                smallestWordLen = wordLen;
                smallestWordIndex = i;
            }
        }

        int[] result = new int[queries.length];
        for(int i=0;i<queries.length; i++){
            int resIndex = root.checkPrefix(queries[i]);
            result[i] = resIndex == -1 ? smallestWordIndex : resIndex;
        }

        return result;
    }

    class Node{
        Node[] child;
        int wordIndex;
        int wordLength;

        public Node(){
            child = new Node[26];
            wordIndex = -1;
            wordLength = Integer.MAX_VALUE;
        }
    }

    class Trie{
        Node root = new Node();

        public void insert(String word, int index){
            Node temp = root;
            int n = word.length();

            for(int i=n-1; i>=0; i--){          // because we need to check suffix so need to reverse the word
                char ch = word.charAt(i);
                int charIndex = ch-'a';

                if(temp.child[charIndex] == null){
                    temp.child[charIndex] = new Node();
                }
                temp = temp.child[charIndex];

                if(temp.wordLength > n){
                    temp.wordLength = n;
                    temp.wordIndex = index;
                }
            }
        }

        public int checkPrefix(String word){
            int n = word.length();
            Node temp = root;
            int resultIndex = -1;

            for(int i=n-1; i>=0; i--){              // Need to check the suffix hence reverse the word and check for prefix
                char ch = word.charAt(i);
                int charIndex = ch-'a';

                if(temp.child[charIndex] == null){
                    return resultIndex;
                }
                temp = temp.child[charIndex];
                resultIndex = temp.wordIndex;
            }
            return resultIndex;
        }
    }
}
