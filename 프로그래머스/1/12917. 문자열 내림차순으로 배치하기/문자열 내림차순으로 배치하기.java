import java.util.*;

class Solution {
    public String solution(String s) {
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        
        String answer = "";
        for (int i = s.length() - 1; i > -1; i--) {
            answer += ch[i];
        }
        return answer;
    }
}