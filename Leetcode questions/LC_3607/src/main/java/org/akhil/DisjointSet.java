package org.akhil;

import java.util.*;

public class DisjointSet {

    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    // to store all connected plant to each plant (here we will keep track of all online plants)
    Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
    boolean[] onlinePlants;

    public DisjointSet(int n){
        if(n<0){
            throw new IllegalArgumentException("-ve n");
        }
        onlinePlants = new boolean[n];

        for(int i=0; i<n; i++){
            parent.add(i);
            size.add(1);
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            queue.offer(i);
            map.put(i, queue);
            onlinePlants[i] = true;
        }
    }

    public int findParent(int node){
        if(node == parent.get(node)){
            return node;
        }

        int ultParent = findParent(parent.get(node));
        parent.set(node, ultParent);
        return ultParent;
    }

    public boolean union(int u, int v){
        int uParent = findParent(u);
        int vParent = findParent(v);

        if(uParent == vParent){
            return false;
        }

        if(size.get(uParent) < size.get(vParent)){
            parent.set(uParent, vParent);
            size.set(vParent, size.get(uParent) + size.get(vParent));

            // add all plants connected to uParent in plants connected to vParent
            PriorityQueue<Integer> uConnectedPlants = map.get(uParent);
            PriorityQueue<Integer> vConnectedPlants = map.get(vParent);
            while(!uConnectedPlants.isEmpty()){
                vConnectedPlants.offer(uConnectedPlants.poll());
            }
        } else {
            parent.set(vParent, uParent);
            size.set(uParent, size.get(uParent) + size.get(vParent));

            // add all plants connected to vParent in plants connected to uParent
            PriorityQueue<Integer> uConnectedPlants = map.get(uParent);
            PriorityQueue<Integer> vConnectedPlants = map.get(vParent);
            while(!vConnectedPlants.isEmpty()){
                uConnectedPlants.offer(vConnectedPlants.poll());
            }
        }
        return true;
    }

    public void markPlantOffline(int node){
        onlinePlants[node] = false;
    }

    public int findClosestOnlinePlant(int node){
        // if plant itself is online then return the same plant
        if(onlinePlants[node]){
            return node;
        }

        PriorityQueue<Integer> queue = map.get(findParent(node));
        // lazy removal of offline plants and returning first online plant from priority queue.
        // priority queue because we need smallest possible online plant.
        while(!queue.isEmpty()){
            if(!onlinePlants[queue.peek()]){
                queue.poll();
            } else {
                return queue.peek();
            }
        }
        return -1;
    }
}
