import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Deque<Integer> q = new ArrayDeque<>();
        for (int a : arr) {
            while (!q.isEmpty() && a == q.peekLast()) {
                q.pollLast();
            }
            q.offerLast(a);
        }
        
        int n = q.size();
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = q.pollFirst();
        }
        return answer;
    }
}