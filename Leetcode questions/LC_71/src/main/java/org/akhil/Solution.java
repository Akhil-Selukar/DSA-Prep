package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder("/");
        String[] arr = path.split("/");

        List<String> list = new ArrayList<>();

        for(String str:arr){
            if(str.equals("..")){
                if(!list.isEmpty()){
                    list.remove(list.size()-1);
                }
                continue;
            }
            if(str.equals("") || str.equals(".")){
                continue;
            }
            list.add(str);
        }

        for(String s:list){
            sb.append(s);
            sb.append("/");
        }

        sb.deleteCharAt(sb.length()-1);
        return sb.length()==0 ? "/" : sb.toString();
    }
}
