import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        Map<String, Integer> xMap = new HashMap<>();
        Map<String, Integer> yMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            xMap.put(String.valueOf(i), 0);
            yMap.put(String.valueOf(i), 0);
        }
        for (int i = 0; i < X.length(); i++) {
            String n = String.valueOf(X.charAt(i));
            xMap.put(n, xMap.get(n) + 1);
        }
        for (int i = 0; i < Y.length(); i++) {
            String n = String.valueOf(Y.charAt(i));
            yMap.put(n, yMap.get(n) + 1);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 9; i > -1; i--) {
            String n = String.valueOf(i);
            int cnt = Math.min(xMap.get(n), yMap.get(n));
            for (int j = 0; j < cnt; j++) {
                sb.append(n);
            }
        }
        
        String answer = sb.toString();
        if (answer.isEmpty()) return "-1";
        if (answer.charAt(0) == '0') return "0";
        return answer;
    }
}