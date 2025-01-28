import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }
        
        int[] answer = new int[photo.length];
        int idx = 0;
        for (String[] p : photo) {
            int score = 0;
            for (String person : p) {
                if (map.getOrDefault(person, 0) == 0) continue;
                score += map.get(person);
            }
            answer[idx++] = score;
        }
        return answer;
    }
}