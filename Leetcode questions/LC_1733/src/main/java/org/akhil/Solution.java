package org.akhil;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    // O(N*L^2)/ O(N+U) where N is number of users, L is maximum number of languages known by a user and U is number of unhappy user
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        Set<Integer> unHappyUsers = new HashSet<>();        // to store users who can't talk to their friends

        for(int[] friends:friendships){
            int user1 = friends[0]-1;           // -1 because array index starts from 0
            int user2 = friends[1]-1;
            boolean happyUsers = false;

            for(int l1:languages[user1]){
                for(int l2:languages[user2]){
                    if(l1 == l2){
                        happyUsers = true;
                        break;
                    }
                }
            }
            if(!happyUsers){
                unHappyUsers.add(user1);
                unHappyUsers.add(user2);
            }
        }

        // iterate over unhappy users and count how many users can speak each language
        int[] languageCount = new int[n + 1];
        int maxPeople = 0;          // store number of people who can speak most popular language;
        for(int user:unHappyUsers){
            for(int language:languages[user]){
                languageCount[language]++;
                maxPeople = Math.max(maxPeople, languageCount[language]);
            }
        }

        return unHappyUsers.size() - maxPeople;
    }
}
