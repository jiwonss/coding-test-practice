import java.util.*;

class Solution {
    public int[] solution(String s) {        
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            map.put((char) (i + 97), -1);
        }
    
        int[] answer = new int[s.length()];
        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.get(c) != -1) {
                answer[idx++] = i - map.get(c);
            } else {
                answer[idx++] = -1;
            }
            map.put(c, i);
        }
        return answer;
    }
}