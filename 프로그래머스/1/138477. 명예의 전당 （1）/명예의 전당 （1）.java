import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int idx = 0;
        for (int i = 0; i < score.length; i++) {
            if (i < k) {
                pq.add(score[i]);
            } else {
                if (pq.peek() < score[i]) {
                    pq.poll();
                    pq.add(score[i]);
                }
            }
            answer[idx++] = pq.peek();
        }
        return answer;
    }
}