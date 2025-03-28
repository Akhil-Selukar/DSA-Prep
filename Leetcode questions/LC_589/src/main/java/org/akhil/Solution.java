package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    // Solution 1 - O(N)/O(logN) worst case O(N) space complexity.
    List<Integer> answer = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if(root == null){
            return answer;
        }
        preOrder(root);
        return answer;
    }

    private void preOrder(Node root){
        if(root == null){
            return;
        }

        answer.add(root.val);
        for(Node child:root.children){
            preOrder(child);
        }
    }
}
