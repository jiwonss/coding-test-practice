import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        Map<String, Integer> cache = new LinkedHashMap<>(cacheSize, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > cacheSize;
             }
        };
        
        int answer = 0;
        for (String city : cities) {
            city = city.toLowerCase();
            if (cache.containsKey(city)) {
                answer += 1;
            } else {
                answer += 5;
            }
            cache.put(city, 1);
        }
        return answer;
    }
}