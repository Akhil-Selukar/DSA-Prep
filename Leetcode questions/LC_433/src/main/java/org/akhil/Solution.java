package org.akhil;

import java.util.*;

public class Solution {

    // O(N)/O(N)
    public class Pair{
        String gene;
        int mutations;

        Pair(String gene, int mutation){
            this.gene = gene;
            this.mutations = mutation;
        }
    }

    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if(!bankSet.contains(endGene)){
            return -1;
        }

        Queue<Pair> queue = new LinkedList();
        queue.offer(new Pair(startGene, 0));

        char[] allowed = {'A','C','G','T'};

        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            String gene = pair.gene;
            int mutations = pair.mutations;

            if(gene.equals(endGene)){
                return mutations;
            }

            StringBuilder sb = new StringBuilder(gene);
            for(int i=0; i<8; i++){
                char tempCh = gene.charAt(i);
                for(char ch:allowed){
                    if(ch != tempCh){
                        sb.replace(i, i+1, Character.toString(ch));

                        if(bankSet.contains(sb.toString())){
                            Pair newPair = new Pair(sb.toString(), mutations+1);
                            queue.offer(newPair);
                            bankSet.remove(sb.toString());
                        }
                    }
                }
                sb.replace(i, i+1, Character.toString(tempCh));
            }
        }
        return -1;
    }
}
