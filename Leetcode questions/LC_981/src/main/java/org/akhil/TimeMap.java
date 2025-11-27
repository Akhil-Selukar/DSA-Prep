package org.akhil;

import java.util.*;

public class TimeMap {

    class Pair{
        String value;
        int time;

        public Pair(String value, int time){
            this.value = value;
            this.time = time;
        }
    }

    Map<String, List<Pair>> map;
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key, new ArrayList<>());
        }

        map.get(key).add(new Pair(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }

        List<Pair> list = map.get(key);
        if(list == null || list.size() == 0){
            return "";
        }

        Collections.sort(list, (a, b)->{
            return a.time-b.time;
        });

        int start = 0;
        int end = list.size()-1;
        int result = 0;

        while(start <= end){
            int mid = start + (end-start)/2;

            if(list.get(mid).time == timestamp){
                return list.get(mid).value;
            }

            if(list.get(mid).time < timestamp){
                result = mid;
                start = mid + 1;
            } else {
                end = mid-1;
            }
        }

        return list.get(result).value;
    }
}
