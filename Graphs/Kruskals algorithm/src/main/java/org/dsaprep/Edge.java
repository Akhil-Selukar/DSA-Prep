package org.dsaprep;

public class Edge implements Comparable<Edge>{
    private int weight;
    private int source;
    private int destination;

    public Edge(int weight, int source, int destination){
        this.weight = weight;
        this.source = source;
        this.destination = destination;
    }

    public int getWeight() {
        return weight;
    }

    public int getSource() {
        return source;
    }

    public int getDestination() {
        return destination;
    }

    @Override
    public int compareTo(Edge e) {
        return this.weight - e.weight;
    }
}
