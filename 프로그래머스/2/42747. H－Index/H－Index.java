import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int n = citations.length;
        
        Arrays.sort(citations);
        
        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, Math.min(i + 1, citations[n - i - 1]));
        }
        return answer;
    }
}