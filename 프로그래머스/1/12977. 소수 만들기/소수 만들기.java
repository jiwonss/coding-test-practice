import java.util.*;

class Solution {
    
    int n, answer;
    int[] arr;
    boolean[] visited;
    
    public int solution(int[] nums) {
        n = nums.length;
        arr = nums;
        visited = new boolean[n];
        answer = 0;
        combination(0, 0);
        return answer;
    }
    
    public void combination(int k, int start) {
        if (k == 3) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    sum += arr[i];
                }
            }
            if (check(sum)) answer += 1;
            return;
        }
        
        for (int i = start; i < n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            combination(k + 1, i + 1);
            visited[i] = false;
        }
    } 
    
    public boolean check(int n) {
        for (int i = 2; i < (int) Math.sqrt(n) + 1; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}