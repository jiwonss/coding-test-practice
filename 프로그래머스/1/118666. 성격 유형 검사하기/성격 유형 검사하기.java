import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('R', 0); map.put('T', 0);
        map.put('C', 0); map.put('F', 0);
        map.put('J', 0); map.put('M', 0);
        map.put('A', 0); map.put('N', 0);
        
        int[] score = {0, 3, 2, 1, 0, 1, 2, 3};
        
        String s; int c;
        for (int i = 0; i < survey.length; i++) {
            s = survey[i]; c = choices[i];
            if (c < 4) {
                map.put(s.charAt(0), map.get(s.charAt(0)) + score[c]);
            }
            if (c > 4) {
                map.put(s.charAt(1), map.get(s.charAt(1)) + score[c]);
            }
        }

        String[] type = {"RT", "CF", "JM", "AN"};
        String answer = "";
        for (int i = 0; i < 4; i++) {
            char a = type[i].charAt(0);
            char b = type[i].charAt(1);
            if (map.get(a) >= map.get(b)) {
                answer += a;
            } else {
                answer += b;
            }
        }
        return answer;
    }
}