package org.dsaprep;

public class Pair {
    private int node;
    private int distance;

    public Pair(int node, int distance){
        this.node = node;
        this.distance = distance;
    }

    public int getNode() {
        return node;
    }

    public void setNode(int node) {
        this.node = node;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
