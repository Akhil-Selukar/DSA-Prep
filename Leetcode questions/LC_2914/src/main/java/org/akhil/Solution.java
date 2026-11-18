package org.akhil;

public class Solution {
    // Here the important thing to understand is, even though we can divide the string in group of any even numbers but it is very
    // obvious that if we make a group of 4 then there can be at max 2 changes which we will have to make (e.g.1010),
    // in case of group of 6 we will have to make at max 3 changes (e.g. 101010). But if we make group of 2 then at max we will have to
    // make only 1 change (e.g. 10 or 01). So even though it is allowed to make group of any even number but the logical decision will be
    // to make group of 2 chars only.
    // O(N)/O(1)
    public int minChanges(String s) {
        int n = s.length();
        int result = 0;

        for(int i=0; i<n-1; i+=2){
            if(s.charAt(i) != s.charAt(i+1)){
                result++;
            }
        }
        return result;
    }
}
