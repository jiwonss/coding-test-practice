import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int t : tangerine) {
            if (map.containsKey(t)) {
                map.put(t, map.get(t) + 1);
            } else {
                map.put(t, 1);
            }
        }
        
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (a, b) -> b.getValue().compareTo(a.getValue()));
        
        int answer = 0;
        for (Map.Entry entry : list) {
            int key = (int) entry.getKey();
            int value = (int) entry.getValue();

            answer++;
            k -= value;
            if (k <= 0) break;
        }
        return answer;
    }
}