package org.akhil;

import java.util.*;

public class Solution {

    private class Pair implements Comparable<Pair>{
        String videoId;
        int frequency;

        public Pair(String videoId, int frequency){
            this.videoId = videoId;
            this.frequency = frequency;
        }

        @Override
        public int compareTo(Pair o) {
            if(this.frequency == o.frequency){
                return this.videoId.compareTo(o.videoId);
            } else {
                return this.frequency - o.frequency;
            }
        }
    }

    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        int currLevel = 0;
        queue.offer(id);
        visited.add(id);

        // BFS to find friends at given level.
        while(!queue.isEmpty()){
            int size = queue.size();
            currLevel++;
            for(int i=0; i<size; i++){
                int polled = queue.poll();
                for(int adj:friends[polled]){
                    if(!visited.contains(adj)){
                        visited.add(adj);
                        queue.offer(adj);
                    }
                }
            }

            if(level == currLevel){
                break;
            }
        }

        // finding videos watched by friends
        Map<String, Integer> videoFreq = new HashMap<>();
        while(!queue.isEmpty()){
            int polled = queue.poll();
            for(String videoId:watchedVideos.get(polled)){
                videoFreq.put(videoId, videoFreq.getOrDefault(videoId, 0)+1);
            }
        }

        List<Pair> videosList = new ArrayList<>();
        for(Map.Entry<String, Integer> entry:videoFreq.entrySet()){
            videosList.add(new Pair(entry.getKey(), entry.getValue()));
        }

        Collections.sort(videosList);

        List<String> result = new ArrayList<>();
        for(Pair pair:videosList){
            result.add(pair.videoId);
        }

        return result;
    }
}
