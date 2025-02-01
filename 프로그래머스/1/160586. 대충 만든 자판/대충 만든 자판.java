import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 'A'; i < 'Z' + 1; i++) {
            map.put((char) i, 101);
        }
        
        for (String k : keymap) {
            for (int i = 0; i < k.length(); i++) {
                char c = k.charAt(i);
                map.put(c, Math.min(map.get(c), i + 1));
            }
        }
        
        int[] answer = new int[targets.length];
        int idx = 0;
        for (String target : targets) {
            int cnt = 0;
            for (int i = 0; i < target.length(); i++) {
                char c = target.charAt(i);
                if (map.get(c) == 101) {
                    cnt = -1;
                    break;
                }
                cnt += map.get(c);
            }
            answer[idx++] = cnt;
        }
        return answer;
    }
}