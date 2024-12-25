package org.akhil;

import java.util.*;

public class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        DisjointSet ds = new DisjointSet(accounts.size());
        HashMap<String, Integer> mapMainMail = new HashMap<>();


        for(int i=0; i< accounts.size(); i++){
            for(int j=1; j<accounts.get(i).size(); j++){    // j starts from 1 because 0 is always name, and we need email here
                String mail = accounts.get(i).get(j);
                if(!mapMainMail.containsKey(mail)){
                    mapMainMail.put(mail, i);
                } else {
                    ds.unionBySize(i, mapMainMail.get(mail));
                }
            }
        }

        List<String>[] mergedMail = new List[accounts.size()];   // array of List<String>
        for(int i=0; i< accounts.size(); i++){
            mergedMail[i] = new ArrayList<>();
        }

        for(Map.Entry<String, Integer> it: mapMainMail.entrySet()){
            String mail = it.getKey();
            int node = it.getValue();

            int ultimateParent = ds.findParent(node);
            mergedMail[ultimateParent].add(mail);
        }

        List<List<String>> answer = new ArrayList<>();

        for(int i=0; i< accounts.size(); i++){
            if(mergedMail[i].size() == 0){
                continue;
            }

            Collections.sort(mergedMail[i]);
            List<String> acc = new ArrayList<>();
            acc.add(accounts.get(i).get(0));
            acc.addAll(mergedMail[i]);
            answer.add(acc);
        }
        return answer;
    }
}
