package org.akhil;

public class RecentCounter {

    private int record[] = new int[10000];
    private int start;
    private int end;

    public RecentCounter() {
        this.start = 0;
        this.end = 0;
    }

    public int ping(int t) {
        while(this.start < this.end && (t-record[this.start] > 3000)){ // If the difference in time is greater than 3000ms, than increase the value of start unitl it's equal or less than 3000ms.
            this.start++;
        }
        this.record[this.end++] = t;      // Inserting the current time at the end
        return this.end - this.start;     // Returning the answer including the element added just now.
    }
}
