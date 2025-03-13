import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int n = progresses.length;
        
        int[] release = new int[n];
        int p, s, div, mod;
        for (int i = 0; i < n; i++) {
            p = progresses[i]; s = speeds[i];
            div = (int) (100 - p) / s; mod = (100 - p) % s;
            release[i] = (mod == 0) ? div : div + 1; 
        }
        
        Deque<Integer> q = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        for (int r : release) {
            if (!q.isEmpty() && q.peek() < r) {
                list.add(q.size());
                q.clear();
            }
            q.offer(r);
        }
        list.add(q.size());
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}