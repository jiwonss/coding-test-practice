import java.util.*;

class Solution {
    
    class Stage {
        int n;
        double failureRate;
        
        Stage(int n, double failureRate) {
            this.n = n;
            this.failureRate = failureRate;
        }
    }
    
    public int[] solution(int N, int[] stages) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i < N + 1; i++) {
            map.put(i, 0);
        }
        
        for (int stage : stages) {
            if (stage == N + 1) continue;
            map.put(stage, map.get(stage) + 1);
        }
        
        List<Stage> list = new ArrayList<>();
        int k, v;
        int player = stages.length;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            k = entry.getKey();
            v = entry.getValue();
            if (v == 0) {
                list.add(new Stage(k, 0));
            } else {
                list.add(new Stage(k, (double) v / player));
            }
            player -= v;
        }
        
        list.sort((a, b) -> {
            int compare = Double.compare(b.failureRate, a.failureRate);
            if (compare == 0) {
                return Integer.compare(a.n, b.n);
            } 
            return compare;
        });
        
        int[] answer = new int[N];
        int idx = 0;
        for (Stage s : list) {
            answer[idx++] = s.n;
        }
        return answer;
    }
}