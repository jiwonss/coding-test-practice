import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        char[] pattern = new char[26 - skip.length()];
        int idx = 0;
        for (int i = 'a'; i < 'z' + 1; i++) {
            char c = (char) i;
            if (skip.indexOf(c) == -1) {
                pattern[idx++] = c;
            }
        }

        int n = pattern.length;
        String answer = "";
        for (char c : s.toCharArray()) {
            int k = 0;
            for (int i = 0; i < n; i++) {
                if (c == pattern[i]) {
                    k = i;
                    break;
                }
            }
            answer += pattern[(k + index) % n];
        }
        return answer;
    }
}