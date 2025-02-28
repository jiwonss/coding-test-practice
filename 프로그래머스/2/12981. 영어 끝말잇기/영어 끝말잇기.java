import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        map.put(words[0], 1);
        
        for(int i = 1; i < words.length; i++) {
            if (map.containsKey(words[i]) || words[i].charAt(0) != words[i - 1].charAt(words[i - 1].length() - 1)) {
                return new int[] {i % n + 1, (int) i / n + 1};
            }
            map.put(words[i], 1);
        }

        return new int[] {0, 0};
    }
}