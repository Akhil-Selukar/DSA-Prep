package org.akhil;

public class Solution {
    // O(N)/O(1)
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for(String op:operations){
            switch(op){
                case "--X", "X--" -> x = x-1;
                case "++X", "X++" -> x = x+1;
            }
        }
        return x;
    }
}
