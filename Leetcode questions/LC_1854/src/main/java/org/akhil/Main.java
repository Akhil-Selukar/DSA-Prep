package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[][] logs = {{1950,1961},{1960,1971},{1970,1981}};

        System.out.println(maximumPopulation(logs));
        System.out.println(maximumPopulation2(logs));
    }

    public static int maximumPopulation(int[][] logs) {
        int[] years = new int[2051];
        int maxPop = years[1950];
        int maxYr = 1950;

        for(int[] log:logs){
            years[log[0]] += 1;
            years[log[1]] -= 1;
        }

        for(int i=1950; i<years.length; i++){
            years[i] = years[i]+years[i-1];

            if(maxPop < years[i]){
                maxPop = years[i];
                maxYr = i;
            }
        }
        return maxYr;
    }

//    #################### little optimised code #####################
    public static int maximumPopulation2(int[][] logs) {
        int[] years = new int[101];
        int maxPop = years[0];
        int maxYr = 1950;

        for(int[] log:logs){
            years[log[0]-1950] += 1;
            years[log[1]-1950] -= 1;
        }

        for(int i=1; i<years.length; i++){
            years[i] = years[i]+years[i-1];

            if(maxPop < years[i]){
                maxPop = years[i];
                maxYr = i+1950;
            }
        }
        return maxYr;
    }
}