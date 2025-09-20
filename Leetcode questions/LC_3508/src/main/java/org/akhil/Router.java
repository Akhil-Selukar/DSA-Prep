package org.akhil;

import java.util.*;

// Solution 1 - Bruteforce (TLE)
//public class Router {
//
//    private class Packet{
//        int source;
//        int destination;
//        int timestamp;
//
//        public Packet(int source, int destination, int timestamp){
//            this.source = source;
//            this.destination = destination;
//            this.timestamp = timestamp;
//        }
//    }
//
//    private int maxSize;
//    private Set<Packet> packetStore;    // to check duplicate packets
//    private Map<Integer, ArrayList<Integer>> destTimestamps;  // destination -> timestamps
//    private Queue<Packet> queue;                  // As we need FIFO
//
//    public Router(int memoryLimit) {
//        maxSize = memoryLimit;
//        packetStore = new HashSet<Packet>();
//        destTimestamps = new HashMap<>();
//        queue = new LinkedList<>();
//    }
//
//    public boolean addPacket(int source, int destination, int timestamp) {
//        Packet packet = new Packet(source, destination, timestamp);
//
//        if (packetStore.contains(packet)){      // duplicate packet exist
//            return false;
//        }
//
//        if (packetStore.size() >= maxSize) {        // max size reached
//            forwardPacket();
//        }
//
//        packetStore.add(packet);
//        queue.offer(packet);
//
//        destTimestamps.putIfAbsent(destination, new ArrayList<>());
//        destTimestamps.get(destination).add(timestamp);
//
//        return true;
//    }
//
//    public int[] forwardPacket() {
//        if (packetStore.isEmpty()){
//            return new int[0];
//        }
//
//        Packet pkt = queue.poll();
//        packetStore.remove(pkt);
//
//        return new int[]{pkt.source, pkt.destination, pkt.timestamp};
//    }
//
//    public int getCount(int destination, int startTime, int endTime) {
//        // if no packet exist for the given destination
//        if (!destTimestamps.containsKey(destination)){
//            return 0;
//        }
//
//
//        ArrayList<Integer> list = destTimestamps.get(destination);
//
//        int left = lowerBound(list, startTime);
//        int right = upperBound(list, endTime);
//
//        return right - left;
//    }
//
//    // binary search for first index >= target, starting from startIdx
//    private int lowerBound(ArrayList<Integer> list, int target) {
//        int startIndex = 0;
//        int endIndex = list.size();
//
//        while (startIndex < endIndex) {
//            int midIndex = (startIndex + endIndex) / 2;
//            if (list.get(midIndex) >= target){
//                endIndex = midIndex;
//            } else {
//                startIndex = midIndex + 1;
//            }
//        }
//        return startIndex;
//    }
//
//    // binary search for first index > target, starting from startIdx
//    private int upperBound(ArrayList<Integer> list, int target) {
//        int startIndex = 0;
//        int endIndex = list.size();
//        int midIndex = (startIndex + endIndex) / 2;
//
//        while (startIndex < endIndex) {
//            if (list.get(midIndex) > target){
//                endIndex = midIndex;
//            } else {
//                startIndex = midIndex + 1;
//            }
//        }
//        return startIndex;
//    }
//}

//--------------------------------
// Solution 2 - Optimized

public class Router {

    private int maxSize;
    private Map<String, int[]> packetStore;       // to check duplicates (key -> packet {source, dest, timestamp})
    private Map<Integer, ArrayList<Integer>> destTimestamps;  // destination -> timestamps
    private Map<Integer, Integer> destStartTimeIndex;  // destination -> startTimeIndex
    private Queue<String> queue;                  // As we need FIFO

    public Router(int memoryLimit) {
        maxSize = memoryLimit;
        packetStore = new HashMap<>();
        destTimestamps = new HashMap<>();
        destStartTimeIndex = new HashMap<>();
        queue = new LinkedList<>();
    }

    private String makeKey(int source, int destination, int timestamp) {
        return source + "_" + destination + "_" + timestamp;
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        String packet = makeKey(source, destination, timestamp);

        if (packetStore.containsKey(packet)){      // duplicate packet exist
            return false;
        }

        if (packetStore.size() >= maxSize) {        // max size reached
            forwardPacket();
        }

        packetStore.put(packet, new int[]{source, destination, timestamp});
        queue.offer(packet);

        destTimestamps.putIfAbsent(destination, new ArrayList<>());
        destTimestamps.get(destination).add(timestamp);

        destStartTimeIndex.put(destination, 0);

        return true;
    }

    public int[] forwardPacket() {
        if (packetStore.isEmpty()){
            return new int[0];
        }

        String pkt = queue.poll();
        int[] packet = packetStore.get(pkt);
        packetStore.remove(pkt);

        int destination = packet[1];
        int idx = destStartTimeIndex.get(destination);
        destStartTimeIndex.put(destination, idx + 1); // move start index forward instead of removing from list

        return packet;
    }

    public int getCount(int destination, int startTime, int endTime) {
        // if no packet exist for the given destination
        if (!destTimestamps.containsKey(destination)){
            return 0;
        }

        ArrayList<Integer> list = destTimestamps.get(destination);
        int startIndex = destStartTimeIndex.get(destination);
        int left = lowerBound(list, startTime, startIndex);
        int right = upperBound(list, endTime, startIndex);

        return right - left;
    }

    // binary search for first index >= target, starting from startIdx
    private int lowerBound(ArrayList<Integer> list, int target, int start) {
        int startIndex = start;
        int endIndex = list.size();

        while (startIndex < endIndex) {
            int midIndex = (startIndex + endIndex) / 2;
            if (list.get(midIndex) >= target){
                endIndex = midIndex;
            } else {
                startIndex = midIndex + 1;
            }
        }
        return startIndex;
    }

    // binary search for first index > target, starting from startIdx
    private int upperBound(ArrayList<Integer> list, int target, int start) {
        int startIndex = start;
        int endIndex = list.size();
        int midIndex = (startIndex + endIndex) / 2;

        while (startIndex < endIndex) {
            if (list.get(midIndex) > target){
                endIndex = midIndex;
            } else {
                startIndex = midIndex + 1;
            }
        }
        return startIndex;
    }
}
