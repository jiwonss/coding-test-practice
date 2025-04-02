import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        
        int[] answer = new int[n];
        Deque<int[]> stack = new ArrayDeque<>();
        for (int i =  0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek()[1] > prices[i]) {
                int[] temp = stack.pop();
                answer[temp[0]] = i - temp[0];
            }
            stack.push(new int[]{i, prices[i]});
        }
        
        while (!stack.isEmpty()) {
            int[] temp = stack.pop();
            answer[temp[0]] = n - temp[0] - 1;
        }
        return answer;
    }
}