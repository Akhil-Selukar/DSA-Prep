package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};

        System.out.println(canCompleteCircuit(gas, cost));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;

        for (int i = 0; i < gas.length; i++) {
            totalCost += cost[i];
            totalGas += gas[i];
        }

        if(totalGas < totalCost){
            return -1;
        }
        int gasInTank = 0;
        int startIndex = 0;

        for(int i = 0; i<gas.length; i++){
            gasInTank += gas[i];
            if(gasInTank >= cost[i]){
                gasInTank -= cost[i];
            } else {
                gasInTank = 0;
                startIndex = i+1;
            }
        }
        return startIndex;
    }
}