package org.akhil;

import java.util.*;

public class Twitter {

    // class to store individual tweets
    private static class Tweet{
        int tweetId;
        int timePosted;     // this is noting but the counter indicating global number of tweet (so that we can sort and get most recent 10 tweets)

        public Tweet(int tId, int time){
            tweetId = tId;
            timePosted = time;
        }
    }


    // global variables
    static int timeStamp;           // act as global tweet id
    int feedMaxNum;                 // these many max tweets we need to show per user (10 given in question)
    Map<Integer, Set<Integer>> followees;       // to store who follows whom
    Map<Integer, List<Tweet>> tweets;           // to store which user posted which tweets

    // constructor to initialize the data structure
    public Twitter() {
        timeStamp = 0;
        feedMaxNum = 10;
        followees = new HashMap<>();
        tweets = new HashMap<>();
    }

    // easiest methods to implement are follow and unfollow
    public void follow(int followerId, int followeeId) {
        if(!followees.containsKey(followerId)){
            followees.put(followerId, new HashSet<Integer>());
        }
        followees.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        // invalid combination or user cannot unfollow itself
        if(!followees.containsKey(followerId) || followerId == followeeId){
            return;
        }
        followees.get(followerId).remove(followeeId);
    }

    public void postTweet(int userId, int tweetId) {
        // if this is first tweet for the user then create new list of tweets for that user and then add new tweet in it.
        if(!tweets.containsKey(userId)) {
            tweets.put(userId, new LinkedList<Tweet>());
            follow(userId, userId);  //follow itself
        }
        //add new tweet on the first place (every new tweet will be added to first place as we want to return most recent 10 tweets
        tweets.get(userId).add(0, new Tweet(tweetId, timeStamp++));
    }

    public List<Integer> getNewsFeed(int userId) {
        //min heap that the earliest tweet is on the top
        PriorityQueue<Tweet> feedHeap = new PriorityQueue<>((a, b) -> a.timePosted - b.timePosted);

        //add tweets of the followees
        Set<Integer> myFollowees = followees.get(userId);

        if(myFollowees != null){
            // iterate over all followees and get their tweets
            for(int followeeId : myFollowees){
                List<Tweet> followeeTweets = tweets.get(followeeId);

                if(followeeTweets == null) {
                    continue;
                }

                for(Tweet t : followeeTweets){
                    if(feedHeap.size() < feedMaxNum) {
                        feedHeap.add(t);
                    }
                    else{
                        if(t.timePosted <= feedHeap.peek().timePosted) {
                            break;
                        }
                        else{
                            feedHeap.add(t);
                            feedHeap.poll();    // remove the oldest tweet (the top one will be the oldest as we have sorted in ascending order in priority queue)
                        }
                    }
                }
            }
        }
        List<Integer> myFeed = new LinkedList<>();
        while(!feedHeap.isEmpty()){
            myFeed.add(0, feedHeap.poll().tweetId);
        }
        return myFeed;
    }
}
