package Trie;

public class Trie {

    private TrieNode root;

    Trie(){
        root = new TrieNode();
    }
    private class TrieNode{

        private TrieNode[] children;
        private boolean isWord;

        TrieNode(){
            this.children = new TrieNode[26];
            this.isWord = false;
        }
    }

    public void insert(String word){
        if(word == null || word.isEmpty())
            throw new IllegalArgumentException("Invalid input!!");
        word = word.toLowerCase();
        TrieNode current = root;
        for(int i=0; i<word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(current.children[index] == null){
                TrieNode node = new TrieNode();
                current.children[index] = node;
            }
            current = current.children[index];
        }
        current.isWord = true;
    }

    public boolean search(String word){
        if(word == null || word.isEmpty())
            throw new IllegalArgumentException("Invalid input!!");
        word = word.toLowerCase();
        TrieNode current = root;
        for(int i=0; i<word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(current.children[index] == null)
                return false;
            else{
                current = current.children[index];
            }
        }
        return current.isWord;
    }

    public static void main(String[] args) {

    }
}
