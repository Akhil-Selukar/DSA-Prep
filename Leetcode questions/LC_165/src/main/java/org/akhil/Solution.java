package org.akhil;

public class Solution {

    // O(max(M,N)/O(1))
    public int compareVersion(String version1, String version2) {
        int v1Index = 0;
        int v2Index = 0;

        while(v1Index < version1.length() || v2Index < version2.length()){
            int valInV1 = 0;
            int valInV2 = 0;

            while(v1Index < version1.length() && version1.charAt(v1Index) != '.'){
                valInV1 = valInV1 * 10 + (version1.charAt(v1Index)-'0');
                v1Index++;
            }

            while(v2Index < version2.length() && version2.charAt(v2Index) != '.'){
                valInV2 = valInV2 * 10 + (version2.charAt(v2Index)-'0');
                v2Index++;
            }

            if(valInV1 < valInV2){
                return -1;
            }
            if(valInV1 > valInV2){
                return 1;
            }

            v1Index++;
            v2Index++;
        }

        return 0;
    }
}
