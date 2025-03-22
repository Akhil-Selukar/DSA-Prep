package org.akhil;

public class Solution {
    public boolean isValidSerialization(String preorder) {
        int availableSlots = 1;     // initially we can have only 1 slot available where we can add root node.

        String[] nodes = preorder.split(",");

        for(String node:nodes){
            availableSlots--;           // each node will consume 1 slot (no matter it is a null node or a node with actual value)
            if(availableSlots < 0){     // available slots will be zero at the end (i.e. last element) but it can not go negative (which means we can not add any more elements further)
                return false;
            }
            if(!node.equals("#")){
                availableSlots += 2;        // each valid node with number provides two new valid slots (left and right)
            }
        }

        return availableSlots == 0;     // If we are out of elements and still we are remaining with some slots then it is not a valid tree
                                        // as it is given in question that at the end each leaf node is # and # provides 0 valid slots so at the end all slots must be consumed.
    }
}
