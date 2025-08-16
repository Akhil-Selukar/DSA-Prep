package org.akhil;

// TC ->
//      insert -> O(L) where L is length of word
//      search -> O(L) where L is length of word
//      prefix -> O(M) where M is length of prefix.
// SC -> O(K*L) where K is number of words stored in trie and L is average length of all words.
public class Trie2 {
    // Structure of Node in trie
    class Node{
        boolean endOfWord;
        Node[] child;
        // we can add another field String word to store word in case of endOfWord is true.

        public Node(){
            child = new Node[26];
            endOfWord = false;
        }
    }

    // ------------------
    // define the root node
    private Node root;

    // initialize the root
    public Trie2() {
        root = new Node();
    }

    // insertion in trie
    public void insert(String word) {
        Node curr = root;       // insertion always start from root

        for(char ch:word.toCharArray()){
            int charIndex = ch-'a';

            if(curr.child[charIndex] == null){
                curr.child[charIndex] = new Node();     // add child to curr with ch
            }
            curr = curr.child[charIndex];       // update curr node position
        }

        // out of for loop means entire word in inserted hence at last node (i.e. curr for now) update the endOfWord flag
        curr.endOfWord = true;
    }

    // search given word in trie
    public boolean search(String word) {
        Node curr = root;       // start from root

        for(char ch:word.toCharArray()){
            int charIndex = ch-'a';

            if(curr.child[charIndex] == null){
                return false;       // if the char is not present as child, we cant form the given word.
            }
            curr = curr.child[charIndex];
        }
        // at the end when we are iterated through entire given word it might possible that we have 'apple' stored but checking only for 'app'
        // so we need to check if current node has endOfWord flag set to true or not. If not then this is not the word in given word list.
        return curr.endOfWord;
    }

    // starts with
    public boolean startsWith(String prefix) {
        Node curr = root;

        for(char ch:prefix.toCharArray()){
            int charIndex = ch-'a';

            if(curr.child[charIndex] == null){
                return false;
            }
            curr = curr.child[charIndex];
        }
        return true;
    }
}
