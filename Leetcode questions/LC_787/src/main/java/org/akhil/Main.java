package org.akhil;

public class Main {
    public static void main(String[] args) {
        int noOfCities = 4;
        int[][] flights = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};  // {from, to, cost}
        int source = 0;
        int destination = 3;
        int k = 1;

        Solution solution = new Solution();

        System.out.println(solution.findCheapestPrice(noOfCities, flights, source, destination, k));
    }
}