package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] position = {2,2,2,3,3};

        System.out.println(minCostToMoveChips(position));
    }

    public static int minCostToMoveChips(int[] position) {
        int oddCount = 0;
        int evenCount = 0;

        for(int pos:position){
            if(pos%2 == 0)
                evenCount++;
            else
                oddCount++;
        }

        return Math.min(evenCount, oddCount);
    }
}