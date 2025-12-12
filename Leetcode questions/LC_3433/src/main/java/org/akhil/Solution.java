package org.akhil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    // Solution 1
    // O(ElogE + E*N)/O(N) where E is number of events and N is number of users
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        int[] result = new int[numberOfUsers];
        int[] status = new int[numberOfUsers];

        // we need to sort the given events based on timestamp because in given events it might happen that later events are given first
        // and we need to make sure that in case of "HERE" we only have to process online users.
        // Other part is if in case a situation where Message and offline events occur at same time then we need to process offline first
        // hence sort the events based on time first and in case of same time based on event type (offline first)
        Collections.sort(events, (a, b)->{
            int timeA = Integer.parseInt(a.get(1));
            int timeB = Integer.parseInt(b.get(1));
            if(timeA != timeB) {
                return timeA - timeB;
            } else {
                return b.get(0).compareTo(a.get(0));
            }
        });

        for(List<String> event:events){
            String eventType = event.get(0);

            switch(eventType.toLowerCase()){
                case "message" : {
                    int timeStamp = Integer.parseInt(event.get(1));
                    String ids = event.get(2);

                    if(ids.equals("ALL")){              // in case of "All" we need to process all mentioned ids irrespective of its status.
                        for(int i=0; i<numberOfUsers; i++){
                            result[i]++;
                            status[i] = status[i] + 60 - timeStamp < 0? 0: status[i];
                        }
                    } else if(ids.equals("HERE")){      // in case of here we only need to process online users (if a user is being online at the same time then that need to be considered)
                        for(int i=0; i<numberOfUsers; i++){
                            status[i] = status[i] + 60 - timeStamp <= 0? 0: status[i];
                            if(status[i] == 0){
                                result[i]++;
                            }
                        }
                    } else {        // if specific id's are given then we need to process those id's only irrespective of status.
                        String[] strIds = event.get(2).split(" ");
                        List<Integer> intIds = new ArrayList<>();
                        for(String id:strIds){
                            intIds.add(Integer.parseInt(id.replace("id","")));
                        }

                        for(int id:intIds){
                            result[id]++;
                        }

                        // during this event status of some users might change hence update the status
                        for(int i=0; i<numberOfUsers; i++){
                            status[i] = status[i] + 60 - timeStamp < 0? 0: status[i];
                        }
                    }
                    break;
                }
                case "offline":{            // in case of offline event mark the users given in id's as offline (i.e. the timestamp at which they went offline so that we can check during next event if the time difference is > 60)
                    int timeStamp = Integer.parseInt(event.get(1));
                    String[] strIds = event.get(2).split(" ");
                    List<Integer> intIds = new ArrayList<>();
                    for(String id:strIds){
                        intIds.add(Integer.parseInt(id));
                    }

                    for(int id:intIds){
                        status[id] = timeStamp;
                    }
                }
            }
        }
        return result;
    }
}
