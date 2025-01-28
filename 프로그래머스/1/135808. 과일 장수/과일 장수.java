import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        List<Integer> list = new ArrayList<>();
        for (int s : score) {
            list.add(s);
        }
        Collections.sort(list, Collections.reverseOrder());
        
        
        int answer = 0;
        for (int i = 0; i < list.size() - m + 1; i = i + m) {
            answer += list.get(i + m - 1) * m;   
        }
        return answer;
    }
}