import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i < n + 1; i++) {
            map.put(i, 1);
        }
        for (int r : reserve) {
            map.put(r, map.get(r) + 1);
        }
        for (int l : lost) {
            map.put(l, map.get(l) - 1);
        }
  
        Arrays.sort(lost);
        
        int pre, nxt;
        for (int l : lost) {
            if (map.get(l) == 1) continue;
            pre = l - 1; nxt = l + 1;
            if (pre > 0 && map.get(pre) == 2) {
                map.put(pre, map.get(pre) - 1);
                map.put(l, map.get(l) + 1);
            } else if (nxt <= n && map.get(nxt) == 2) {
                map.put(nxt, map.get(nxt) - 1);
                map.put(l, map.get(l) + 1);
            }
        }
        
        int answer = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 0) {
                answer += 1;
            }
        }
        return answer;
    }
}