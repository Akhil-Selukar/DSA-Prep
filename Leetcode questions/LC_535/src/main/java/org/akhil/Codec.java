package org.akhil;

import java.util.HashMap;
import java.util.Map;

public class Codec {

    final static String BASE_URL = "http://tinyurl.com/";
    final static Map<String, String> map = new HashMap<>();

    // Encodes a URL to a shortened URL.
    // O(N)/O(MN) where N is length of URL and M is number of url pairs stored in map
    public String encode(String longUrl) {
        String shortURL = BASE_URL + longUrl.hashCode();
        map.put(shortURL, longUrl);
        return shortURL;
    }

    // Decodes a shortened URL to its original URL.
    // O(1)/O(MN) where N is length of URL and M is number of url pairs stored in map
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }
}
