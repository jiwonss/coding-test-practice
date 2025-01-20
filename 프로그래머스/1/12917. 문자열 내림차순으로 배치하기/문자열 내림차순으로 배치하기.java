import java.util.*;

class Solution {
    public String solution(String s) {
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i > -1; i--) {
            sb.append(ch[i]);
        }
        return sb.toString();
    }
}