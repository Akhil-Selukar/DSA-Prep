package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] gain = {-5,1,5,0,-7};

        System.out.println(largestAltitude(gain));
    }

    public static int largestAltitude(int[] gain) {
        int highest = 0;
        int totalAlt = 0;
        for(int alt:gain){
            totalAlt +=alt;
            if(totalAlt > highest){
                highest = totalAlt;
            }
        }
        return highest;
    }
}