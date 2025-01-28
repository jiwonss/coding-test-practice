import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[][] pattern = {{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
        
        int n = answers.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (answers[j] == pattern[i][j % pattern[i].length]) {
                    cnt += 1;
                }    
            }
            map.put(i + 1, cnt);
        }
        
        int max = Collections.max(map.values());
        
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (max == entry.getValue()) {
                list.add(entry.getKey());
            }
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}