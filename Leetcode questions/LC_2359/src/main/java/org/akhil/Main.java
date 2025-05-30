package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] edges = {2,2,3,-1};
        int node1 = 0;
        int node2 = 1;

        Solution solution = new Solution();
        System.out.println(solution.closestMeetingNode(edges, node1, node2));
    }
}