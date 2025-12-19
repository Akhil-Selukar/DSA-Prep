package org.akhil;

import java.util.*;

public class Solution {

    // Solution 1 - WRONG (This can be the 1st Solution which we might think of)
    // But this will fail for test case like n=5, meetings = [[1,4,3],[0,4,3]] and firstPerson = 3
//    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
//        Set<Integer> knowsSecret = new HashSet<>();
//        knowsSecret.add(0);
//        knowsSecret.add(firstPerson);
//
//        Arrays.sort(meetings, (a, b)->{
//            return a[2]-b[2];
//        });
//
//        for(int[] meeting:meetings){
//            int p1 = meeting[0];
//            int p2 = meeting[1];
//
//            if(knowsSecret.contains(p1)){
//                knowsSecret.add(p2);
//            }
//
//            if(knowsSecret.contains(p2)){
//                knowsSecret.add(p1);
//            }
//        }
//
//        List<Integer> result = new ArrayList<>();
//        for(int val:knowsSecret){
//            result.add(val);
//        }
//        return result;
//    }


    // ------------------------
    // Solution 2 - Using graph (CORRECT solution)
    // O(M+N)/O(M+N)
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        // create adjacency list using meetings
        List<List<int[]>> adj = new ArrayList<>();

        // O(N)
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        // O(M)
        for(int[] meeting:meetings){
            int p1 = meeting[0];
            int p2 = meeting[1];
            int time = meeting[2];

            // undirected graph because when P1 is having meeting with P2 means P2 is also having meeting with P1
            adj.get(p1).add(new int[]{p2, time});
            adj.get(p2).add(new int[]{p1, time});
        }

        // track who know secret and also it might possible that while traversing 1 had meeting with person 0 at time 0
        // and then some person 3 had meeting with 4 at time 5 and post that we are given that 1 had meeting with 3 at time 2.
        // so if we go sequentially then even though 3 got to know secret from 1 at time 2 we will mark this post evaluating meeting of 3 and 4
        // hence we will not mark 4 as the one who know the secret which will be wrong Ideally secret will travel through 0-[0]->1-[4]->3-[5]->4
        // hence we will need to track the earliest time at which one got to know the secret.

        int[] discoveredAt = new int[n];        // to store earliest time of discovery of secret
        Arrays.fill(discoveredAt, Integer.MAX_VALUE);
        discoveredAt[0] = 0;
        discoveredAt[firstPerson] = 0;

        // BFS  (O(N+M))
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});               // person 0 knows the secret initially i.e. at time 0
        queue.offer(new int[]{firstPerson, 0});     // 0 also told the secret to first person at time t=0

        while(!queue.isEmpty()){
            int[] polled = queue.poll();
            int person = polled[0];
            int timeOfDiscovery = polled[1];

            // Optimization: If we already found a better time for this person, skip we have already processed it for better time
            // Without this there will be TLE
            if (timeOfDiscovery > discoveredAt[person]){
                continue;
            }

            // check for all other people with whom this person has meeting
            for(int[] neighbor:adj.get(person)){
                int neighborPerson = neighbor[0];
                int meetingTime = neighbor[1];

                if(meetingTime < discoveredAt[neighborPerson] && meetingTime >= timeOfDiscovery){
                    discoveredAt[neighborPerson] = meetingTime;
                    queue.offer(new int[]{neighborPerson, meetingTime});
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(discoveredAt[i] != Integer.MAX_VALUE){
                result.add(i);
            }
        }

        return result;
    }
}
