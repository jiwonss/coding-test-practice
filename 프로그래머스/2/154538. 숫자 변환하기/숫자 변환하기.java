import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        Deque<Integer> q = new ArrayDeque<>();
        int[] visited = new int[1000001];
        
        q.offer(x);
        while (!q.isEmpty()) {
            int k = q.poll();
            if (k == y) return visited[k];
            for (long v : new long[]{k + n, k * 2, k * 3}) {
                if (v > 1000000 || visited[(int) v] != 0) continue;
                visited[(int) v] = visited[k] + 1;
                q.offer((int) v);
            }
        }
        return -1;
    }
}