package org.akhil;

public class Solution {
    // total angle a clock can cover is 360
    // we have 12 hr so angle between two adjacent hrs will be 360/12 = 30
    // in 1 hr we have 60 minutes and for Hr hand to travel from one hr to adjacent hr it takes 60 minuted hence
    // angle travelled by hr hand per minute is 30/60 = 0.5
    // in two adjacent hr marking we have 5 minutes markings hence 30 degree angle is divided in 5 parts by minute hand
    // so in 1 minute, minute hand cover 30/5 = 6 degree angle
    public double angleClock(int hour, int minutes) {
        if(minutes == 0){
            return 30 * Math.min(hour, 12-hour);
        }

        int minHandAngle = minutes * 6;   // angle of minute hand with 12
        int angleByHrHand = 30 * hour;  // angle of hr hand with 12

        // calculate angle covered by hr hand in given minutes
        double additionalAngle = 0.5 * minutes;

        double hrHandAngle = angleByHrHand + additionalAngle;

        double coveredAngle = Math.abs(hrHandAngle - minHandAngle);

        return Math.min(coveredAngle, 360-coveredAngle);
    }
}
