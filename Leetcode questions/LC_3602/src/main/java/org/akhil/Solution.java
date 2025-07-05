package org.akhil;

public class Solution {

    // O(logN)/O(logN)
    public String concatHex36(int n) {
        StringBuilder sb = new StringBuilder();

        long square = (long)Math.pow(n, 2);
        long cube = (long)Math.pow(n, 3);

        sb.append(convert(square, 16));
        sb.append(convert(cube, 36));

        return sb.toString();
    }

    // O(log_base(N))/O(log_base(N))
    private String convert(long num, int base){
        StringBuilder sb = new StringBuilder();
        while(num > 0){
            int rem = (int)(num % base);
            num = num/base;

            if(rem <= 9){
                sb.append(rem);
            } else {
                sb.append((char) (rem+55));
            }
        }

        return sb.reverse().toString();
    }
}
