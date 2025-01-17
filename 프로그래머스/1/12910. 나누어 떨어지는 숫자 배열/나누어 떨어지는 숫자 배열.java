import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        Arrays.sort(arr);
        
        List<Integer> result = new ArrayList<>();
        for (int a : arr) {
            if (a % divisor == 0) {
                result.add(a);
            }
        }
        
        if (result.size() == 0) {
            return new int[]{-1};
        }
        
        int[] answer = new int[result.size()];
        int idx = 0;
        for (int r : result) {
            answer[idx++] = r;
        }
        return answer;
    }
}