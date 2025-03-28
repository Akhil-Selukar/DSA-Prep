package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    // O(N)/O(logN) in worst case space complexity will be O(N)
    List<Integer> answer = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        if(root == null){
            return answer;
        }
        postOrder(root);
        return answer;
    }

    private void postOrder(Node root){
        if(root == null){
            return;
        }

        for(Node child:root.children){
            postOrder(child);
        }
        answer.add(root.val);
    }
}
