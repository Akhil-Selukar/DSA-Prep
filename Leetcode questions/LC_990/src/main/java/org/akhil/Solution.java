package org.akhil;

public class Solution {

    // O(N)/O(1)    because of size of disjoint set is constant i.e. 26
    public boolean equationsPossible(String[] equations) {
        DisjointSet ds = new DisjointSet(26);

        // Construct disjoint set
        for(String eq:equations){
            if(eq.charAt(1) == '='){
                ds.unionBySize(eq.charAt(0)-'a', eq.charAt(3)-'a');
            }
        }

        // check violations
        for(String eq:equations){
            if(eq.charAt(1) == '!'){
                if(ds.findParent(eq.charAt(3)-'a') == ds.findParent(eq.charAt(0)-'a')){
                    return false;
                }
            }
        }
        return true;
    }
}
