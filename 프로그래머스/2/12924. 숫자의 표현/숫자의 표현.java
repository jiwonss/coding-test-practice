import java.util.*;

class Solution {
    public int solution(int n) {
        List<Integer> num = new ArrayList();
        for (int i = 1; i < n + 1; i = i + 2) {
            num.add(i);
        }
        
        int answer = 0;
        for (Integer k : num) {
            if (n % k == 0) {
                answer++;
            }
        }
        return answer;
    }
}