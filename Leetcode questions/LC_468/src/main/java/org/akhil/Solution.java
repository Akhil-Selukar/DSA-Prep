package org.akhil;

public class Solution {
    public String validIPAddress(String queryIP) {
        if(isIpv4(queryIP)){
            return "IPv4";
        } else if(isIpv6(queryIP)){
            return "IPv6";
        } else {
            return "Neither";
        }
    }

    private boolean isIpv4(String queryIP) {
        String[] parts = queryIP.split("\\.",-1);
        for(String part:parts){
            try{
                if(Integer.parseInt(part) > 255 || (part.charAt(0) == '0' && part.length() != 1)){
                    return false;
                }
            } catch(NumberFormatException e){
                return false;
            }
        }
        return parts.length == 4;
    }

    private boolean isIpv6(String queryIP) {
        String[] parts = queryIP.split(":", -1);
        for(String part:parts){
            try{
                if((Integer.parseInt(part, 16) > 65535) || part.length()>4){
                    return false;
                }
            } catch(NumberFormatException e){
                return false;
            }
        }
        return parts.length == 8;
    }
}
